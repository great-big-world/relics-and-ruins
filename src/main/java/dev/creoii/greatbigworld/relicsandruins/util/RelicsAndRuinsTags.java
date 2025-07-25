package dev.creoii.greatbigworld.relicsandruins.util;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public final class RelicsAndRuinsTags {
    public static final TagKey<Biome> FOSSIL_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(GreatBigWorld.NAMESPACE, "fossil_biomes"));
}
