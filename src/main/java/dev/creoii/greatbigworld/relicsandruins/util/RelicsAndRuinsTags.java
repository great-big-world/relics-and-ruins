package dev.creoii.greatbigworld.relicsandruins.util;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public final class RelicsAndRuinsTags {
    public static final TagKey<Biome> FOSSIL_BIOMES = TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "fossil_biomes"));
    public static final TagKey<Item> ENGRAVED_STONE_ITEMS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraved_stones"));
    public static final TagKey<Block> ENGRAVED_STONE_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraved_stones"));
}
