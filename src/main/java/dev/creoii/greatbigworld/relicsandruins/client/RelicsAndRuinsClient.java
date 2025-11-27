package dev.creoii.greatbigworld.relicsandruins.client;

import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import dev.creoii.greatbigworld.util.ColorHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.BlockRenderLayer;

public class RelicsAndRuinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.TRANSLUCENT, RelicsAndRuinsBlocks.ICE_BRICKS, RelicsAndRuinsBlocks.ICE_BRICK_STAIRS, RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.ICE_BRICK_WALL);
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, RelicsAndRuinsBlocks.ENGRAVED_STONE);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            return tintIndex == 0 && state != null ? ColorHelper.multiply(6250335, state.get(EngravedStoneBlock.COLOR).getSignColor(), .33334d) : -1;
        }, RelicsAndRuinsBlocks.ENGRAVED_STONE);
    }
}
