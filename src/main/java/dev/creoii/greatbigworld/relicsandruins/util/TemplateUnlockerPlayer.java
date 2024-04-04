package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.item.Item;

import java.util.Set;

public interface TemplateUnlockerPlayer {
    Set<Item> gbw$getUnlockedTemplates();

    void gbw$unlockTemplate(Item item);
}
