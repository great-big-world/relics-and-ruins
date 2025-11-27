package dev.creoii.greatbigworld.relicsandruins.block;

import com.mojang.serialization.Codec;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponentTypes;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.List;

public class EngravedStoneBlock extends KnowledgeBlock {
    public static final EnumProperty<Engraving> ENGRAVING = EnumProperty.of("engraving", Engraving.class);

    public EngravedStoneBlock(Settings settings, Pool<Knowledge> knowledgePool) {
        super(settings, knowledgePool);
        setDefaultState(getDefaultState().with(NATURAL, true).with(ENGRAVING, Engraving.ANGLER));
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack stack = super.getPickStack(world, pos, state, includeData);
        stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, state.get(ENGRAVING));
        return stack;
    }

    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootWorldContext.Builder builder) {
        List<ItemStack> stacks = super.getDroppedStacks(state, builder);
        stacks.forEach(stack -> {
            if (stack.isIn(RelicsAndRuinsTags.ENGRAVED_STONE_ITEMS)) {
                stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, state.get(ENGRAVING));
            }
        });
        return stacks;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = getDefaultState();
        if (ctx.getStack().contains(RelicsAndRuinsDataComponentTypes.ENGRAVING)) {
            Engraving engraving = ctx.getStack().get(RelicsAndRuinsDataComponentTypes.ENGRAVING);
            state = state.with(ENGRAVING, engraving);
        }
        return state.with(NATURAL, false);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ENGRAVING);
    }

    public enum Engraving implements StringIdentifiable {
        ANGLER,
        ARCHER,
        ARMS_UP,
        BLADE,
        BREWER,
        BURN,
        DANGER,
        EXPLORER,
        FLOW,
        FRIEND,
        GUSTER,
        HEART,
        HEARTBREAK,
        HOWL,
        MINER,
        MOURNER,
        PLENTY,
        PRIZE,
        SCRAPE,
        SHEAF,
        SHELTER,
        SKULL,
        SNORT;

        public static final Codec<Engraving> CODEC = StringIdentifiable.createCodec(Engraving::values);
        public static final PacketCodec<RegistryByteBuf, Engraving> PACKET_CODEC = PacketCodec.of(Engraving::write, Engraving::read);

        public void write(RegistryByteBuf buf) {
            buf.writeInt(ordinal());
        }

        public static Engraving read(RegistryByteBuf buf) {
            return Engraving.values()[buf.readInt()];
        }

        @Override
        public String asString() {
            return name().toLowerCase();
        }
    }
}
