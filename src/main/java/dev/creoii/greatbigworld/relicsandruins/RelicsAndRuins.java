package dev.creoii.greatbigworld.relicsandruins;

import dev.creoii.greatbigworld.relicsandruins.registry.*;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsBlockEntityTypes.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();

        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.FOSSIL_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.FOSSIL_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_UPPER_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_LOWER_COMMON);
    }
}
