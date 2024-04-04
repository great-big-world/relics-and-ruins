package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;

import java.util.List;

public interface ExtendedSmithingScreenHandler {
    List<Item> SMITHING_TEMPLATES = Registries.ITEM.stream().filter(item -> item instanceof SmithingTemplateItem).toList();

    int gbw$getSelectedRecipe();
}
