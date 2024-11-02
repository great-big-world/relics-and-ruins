package dev.creoii.greatbigworld.relicsandruins;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponents;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsPotions;
import net.fabricmc.api.ModInitializer;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsDataComponents.register();
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsPotions.register();
    }
}
