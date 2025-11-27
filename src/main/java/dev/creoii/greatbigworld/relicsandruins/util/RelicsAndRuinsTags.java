package dev.creoii.greatbigworld.relicsandruins.util;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public final class RelicsAndRuinsTags {
    public static final TagKey<Biome> FOSSIL_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(GreatBigWorld.NAMESPACE, "fossil_biomes"));
    public static final TagKey<Item> ENGRAVED_STONE_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stones"));
    public static final TagKey<Block> ENGRAVED_STONE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stones"));
}
