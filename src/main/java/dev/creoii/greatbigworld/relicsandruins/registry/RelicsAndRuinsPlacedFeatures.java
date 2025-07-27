package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public final class RelicsAndRuinsPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FOSSIL_UPPER_COMMON = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(GreatBigWorld.NAMESPACE, "fossil_upper_common"));
    public static final RegistryKey<PlacedFeature> FOSSIL_LOWER_COMMON = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(GreatBigWorld.NAMESPACE, "fossil_lower_common"));
}
