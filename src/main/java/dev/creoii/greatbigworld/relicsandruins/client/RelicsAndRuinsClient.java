package dev.creoii.greatbigworld.relicsandruins.client;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Identifier id = new Identifier(GreatBigWorld.NAMESPACE, "relic_charged");
        ModelPredicateProviderRegistry.register(id, (stack, world, entity, seed) -> {
            if (RelicComponent.isCharged(stack)) {
                return 1f;
            }
            return 0f;
        });
    }
}
