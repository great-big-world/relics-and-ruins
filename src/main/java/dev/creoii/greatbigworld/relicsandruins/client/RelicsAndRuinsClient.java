package dev.creoii.greatbigworld.relicsandruins.client;

import dev.creoii.greatbigworld.relicsandruins.client.render.AncientTotemBlockEntityRenderer;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlockEntityTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class RelicsAndRuinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(RelicsAndRuinsBlockEntityTypes.ANCIENT_TOTEM, AncientTotemBlockEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), RelicsAndRuinsBlocks.ICE_BRICKS, RelicsAndRuinsBlocks.ICE_BRICK_STAIRS, RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.ICE_BRICK_WALL);
    }
}
