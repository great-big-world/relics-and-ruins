package dev.creoii.greatbigworld.relicsandruins.util;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsTags {
    public static final TagKey<Block> VARIANT_CHEST_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier(GreatBigWorld.NAMESPACE, "variant_chests"));

    public static final TagKey<Item> VARIANT_CHEST_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier(GreatBigWorld.NAMESPACE, "variant_chests"));
}
