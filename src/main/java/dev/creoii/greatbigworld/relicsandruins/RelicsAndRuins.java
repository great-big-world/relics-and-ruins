package dev.creoii.greatbigworld.relicsandruins;

import dev.creoii.greatbigworld.relicsandruins.registry.*;
import net.fabricmc.api.ModInitializer;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();
    }
}
