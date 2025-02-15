package dev.creoii.greatbigworld.relicsandruins;

import dev.creoii.greatbigworld.relicsandruins.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        PayloadTypeRegistry.playS2C().register(BlockBreakingManager.BlockBreakingInfo.PACKET_ID, BlockBreakingManager.BlockBreakingInfo.PACKET_CODEC);

        RelicsAndRuinsComponentTypes.register();
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();

        ServerWorldEvents.LOAD.register((server, world) -> {
            BlockBreakingManager.getInstance(server).load(world);
        });
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof ServerPlayerEntity serverPlayer) {
                BlockBreakingManager manager = BlockBreakingManager.getInstance(world.getServer());
                for (BlockBreakingManager.BlockBreakingInfo info : manager.getBlockBreakingInfos().values()) {
                    ServerPlayNetworking.send(serverPlayer, info);
                }
            }
        });
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            BlockBreakingManager.getInstance(world.getServer()).tick(world);
        });
    }
}
