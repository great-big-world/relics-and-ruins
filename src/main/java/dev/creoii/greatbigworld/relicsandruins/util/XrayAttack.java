package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

@FunctionalInterface
public interface XrayAttack {
    /**
     * Assume that {@link MinecraftClient#player} and {@link MinecraftClient#interactionManager} are nonnull.
     */
    void onAttackThroughBlock(MinecraftClient client, ItemStack stack, Entity entity);
}
