package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.world.feature.CavePaintingFeature;
import dev.creoii.greatbigworld.relicsandruins.world.feature.CavePaintingFeatureConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;

public final class RelicsAndRuinsFeatures {
    public static Feature<CavePaintingFeatureConfig> CAVE_PAINTING;

    public static void register() {
        CAVE_PAINTING = Registry.register(BuiltInRegistries.FEATURE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cave_painting"), new CavePaintingFeature(CavePaintingFeatureConfig.CODEC));
    }
}
