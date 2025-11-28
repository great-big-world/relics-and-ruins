package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.world.feature.CavePaintingFeature;
import dev.creoii.greatbigworld.relicsandruins.world.feature.CavePaintingFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;

public final class RelicsAndRuinsFeatures {
    public static Feature<CavePaintingFeatureConfig> CAVE_PAINTING;

    public static void register() {
        CAVE_PAINTING = Registry.register(Registries.FEATURE, Identifier.of(GreatBigWorld.NAMESPACE, "cave_painting"), new CavePaintingFeature(CavePaintingFeatureConfig.CODEC));
    }
}
