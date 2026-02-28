package dev.creoii.greatbigworld.relicsandruins;

import dev.creoii.greatbigworld.registry.GBWBlockEntityTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.*;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import dev.creoii.greatbigworld.thealterworld.TheAlterworld;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.ComponentTooltipAppenderRegistry;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();
        RelicsAndRuinsFeatures.register();
        RelicsAndRuinsDataComponentTypes.register();
        RelicsAndRuinsBlockStateProviderTypes.register();
        RelicsAndRuinsLootFunctionTypes.register();
        RelicsAndRuinsEvents.register();

        if (GBWBlockEntityTypes.KNOWLEDGE_BLOCK != null)
            ((BlockEntityTypeAccessor) GBWBlockEntityTypes.KNOWLEDGE_BLOCK).getBlocks().add(RelicsAndRuinsBlocks.ENGRAVED_STONE);

        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_UPPER_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_LOWER_COMMON);

        BiomeModifications.addFeature(TheAlterworld.foundInOverworldLike(), GenerationStep.Decoration.UNDERGROUND_ORES, RelicsAndRuinsPlacedFeatures.CAVE_PAINTING);

        ComponentTooltipAppenderRegistry.addBefore(DataComponents.MAP_ID, RelicsAndRuinsDataComponentTypes.ENGRAVING);
    }
}
