package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class RelicsAndRuinsPlacedFeatures {
    public static final ResourceKey<PlacedFeature> FOSSIL_UPPER_COMMON = ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "fossil_upper_common"));
    public static final ResourceKey<PlacedFeature> FOSSIL_LOWER_COMMON = ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "fossil_lower_common"));
    public static final ResourceKey<PlacedFeature> CAVE_PAINTING = ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cave_painting"));
}
