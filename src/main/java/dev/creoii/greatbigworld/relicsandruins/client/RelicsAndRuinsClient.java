package dev.creoii.greatbigworld.relicsandruins.client;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RelicsAndRuinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), RelicsAndRuinsBlocks.ICE_BRICKS, RelicsAndRuinsBlocks.ICE_BRICK_STAIRS, RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.ICE_BRICK_WALL);
    }
}
