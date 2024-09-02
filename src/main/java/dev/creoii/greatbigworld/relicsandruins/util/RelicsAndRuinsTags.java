package dev.creoii.greatbigworld.relicsandruins.util;

import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsTags {
    public static final TagKey<Block> BLOCKS_VARIANT_CHESTS = TagKey.of(RegistryKeys.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "variant_chests"));

    public static final TagKey<Item> ITEMS_VARIANT_CHESTS = TagKey.of(RegistryKeys.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "variant_chests"));
}
