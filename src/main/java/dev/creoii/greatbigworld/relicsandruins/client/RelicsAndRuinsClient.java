package dev.creoii.greatbigworld.relicsandruins.client;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Identifier id = Identifier.of(GreatBigWorld.NAMESPACE, "relic_charged");
        ModelPredicateProviderRegistry.register(id, (stack, world, entity, seed) -> {
            if (RelicComponent.isCharged(stack)) {
                return 1f;
            }
            return 0f;
        });

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), RelicsAndRuinsBlocks.BRAZIER, RelicsAndRuinsBlocks.SOUL_BRAZIER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), RelicsAndRuinsBlocks.ICE_BRICKS, RelicsAndRuinsBlocks.ICE_BRICK_STAIRS, RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.ICE_BRICK_WALL);
    }
}
