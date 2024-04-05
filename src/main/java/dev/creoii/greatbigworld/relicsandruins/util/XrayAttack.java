package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public interface XrayAttack {
    default void onXrayAttack(MinecraftClient client, ItemStack stack, Entity entity) {}
}
