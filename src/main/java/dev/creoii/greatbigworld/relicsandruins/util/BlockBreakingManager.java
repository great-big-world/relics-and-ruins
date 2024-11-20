package dev.creoii.greatbigworld.relicsandruins.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import dev.creoii.greatbigworld.GreatBigWorld;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockBreakingManager extends PersistentState {
    private static final Type<BlockBreakingManager> STATE_TYPE = new Type<>(BlockBreakingManager::new, BlockBreakingManager::createFromNbt, null);
    private static BlockBreakingManager instance;
    @Nullable
    private MinecraftServer server = null;
    private Map<BlockPos, BlockBreakingInfo> blockBreakingInfos = Maps.newHashMap();

    public static BlockBreakingManager getInstance(MinecraftServer server) {
        return instance == null ? instance = getServerState(server) : instance;
    }

    public Map<BlockPos, BlockBreakingInfo> getBlockBreakingInfos() {
        return blockBreakingInfos;
    }

    public void addBlockDamage(World world, @Nullable PlayerEntity player, BlockPos pos, int amount) {
        int totalDamage = getBlockDamage(pos) + amount;
        if (totalDamage >= 10) {
            if (player != null)
                ((ServerWorld) world).getServer().getPlayerInteractionManager((ServerPlayerEntity) player).tryBreakBlock(pos);
            BlockBreakingInfo info = new BlockBreakingInfo(pos, 10, -1);
            world.getPlayers().forEach(player1 -> ServerPlayNetworking.send((ServerPlayerEntity) player1, info));
            blockBreakingInfos.remove(pos);
            world.setBlockBreakingInfo(info.entityId(), pos, -1);
        } else {
            setBlockDamage(world, pos, totalDamage);
        }
    }

    public void setBlockDamage(World world, BlockPos pos, int amount) {
        BlockBreakingInfo info = new BlockBreakingInfo(pos, amount, -1);
        blockBreakingInfos.put(pos, info);
        world.setBlockBreakingInfo(info.entityId(), pos, amount);
        world.getPlayers().forEach(player1 -> ServerPlayNetworking.send((ServerPlayerEntity) player1, info));
    }

    public int getBlockDamage(BlockPos pos) {
        return blockBreakingInfos.containsKey(pos) ? blockBreakingInfos.get(pos).damage() : -1;
    }

    public void load(ServerWorld world) {
        server = world.getServer();

        for (BlockBreakingInfo info : blockBreakingInfos.values()) {
            if (info.entityId() == -1) {
                setBlockDamage(world, info.pos(), info.damage());
            } else {
                setBlockDamage(world, info.pos(), info.damage());
            }
        }
    }

    public void tick(ServerWorld world) {
        if (server == null)
            server = world.getServer();
        if (instance == null) {
            instance = getServerState(server);
            load(world);
        }

        Map<BlockPos, BlockBreakingInfo> updatedInfos = Maps.newHashMap();
        for (Map.Entry<BlockPos, BlockBreakingInfo> entry : blockBreakingInfos.entrySet()) {
            BlockBreakingInfo info = entry.getValue();
            if (info.cooldown() == -1) {
                updatedInfos.put(entry.getKey(), entry.getValue());
            } else {
                if (info.cooldown() == 1) // remove any that have run out
                    continue;
                updatedInfos.put(entry.getKey(), new BlockBreakingInfo(info.pos(), info.entityId(), info.damage(), info.cooldown() - 1));
            }
        }
        blockBreakingInfos = updatedInfos;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound compound = new NbtCompound();
        NbtList list = new NbtList();
        for (BlockBreakingInfo info : blockBreakingInfos.values()) {
            list.add(NbtString.of(info.pos().getX() + "," + info.pos().getY() + "," + info.pos().getZ() + "," + info.entityId() + "," + info.damage() + "," + info.cooldown()));
        }
        compound.put("infos", list);
        return compound;
    }

    private static BlockBreakingManager createFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        BlockBreakingManager manager = new BlockBreakingManager();
        NbtList list = nbt.getList("infos", NbtElement.STRING_TYPE);
        list.forEach(nbtElement -> {
            if (nbtElement.getType() == NbtElement.STRING_TYPE) {
                NbtString nbtString = (NbtString) nbtElement;
                String[] data = nbtString.asString().split(",");
                BlockPos pos = new BlockPos(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                manager.blockBreakingInfos.put(pos, new BlockBreakingInfo(pos, Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
            }
        });
        return manager;
    }

    private static BlockBreakingManager getServerState(MinecraftServer server) {
        BlockBreakingManager manager = server.getWorld(World.OVERWORLD).getPersistentStateManager().getOrCreate(STATE_TYPE, "gbw_block_breaking");
        manager.markDirty();
        return manager;
    }

    public record BlockBreakingInfo(BlockPos pos, int entityId, int damage, int cooldown) implements CustomPayload {
        public static final AtomicInteger NEXT_BREAKER_ID = new AtomicInteger();
        private static final LoadingCache<BlockPos, Integer> RESERVED_BREAKER_IDS = CacheBuilder.newBuilder()
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .build(new CacheLoader<>() {
                    @Override
                    public Integer load(@NotNull BlockPos key) { return null; }
                });
        public static final CustomPayload.Id<BlockBreakingInfo> PACKET_ID = new CustomPayload.Id<>(Identifier.of(GreatBigWorld.NAMESPACE, "block_breaking_info"));
        public static final PacketCodec<RegistryByteBuf, BlockBreakingInfo> PACKET_CODEC = PacketCodec.of(BlockBreakingInfo::write, BlockBreakingInfo::new);

        public BlockBreakingInfo(BlockPos pos, int damage, int cooldown) {
            this(pos, createBreakerId(pos), damage, cooldown);
        }

        public BlockBreakingInfo(RegistryByteBuf buf) {
            this(buf.readBlockPos(), buf.readVarInt(), buf.readVarInt(), buf.readVarInt());
        }

        public static int createBreakerId(BlockPos pos) {
            Integer id = RESERVED_BREAKER_IDS.getIfPresent(pos);
            if (id == null) {
                id = (Integer.MAX_VALUE / 2) - NEXT_BREAKER_ID.incrementAndGet();
                RESERVED_BREAKER_IDS.put(pos, id);
            }
            return id;
        }

        public void write(RegistryByteBuf buf) {
            buf.writeBlockPos(pos);
            buf.writeVarInt(entityId);
            buf.writeVarInt(damage);
            buf.writeVarInt(cooldown);
        }

        @Override
        public Id<? extends CustomPayload> getId() {
            return PACKET_ID;
        }
    }
}
