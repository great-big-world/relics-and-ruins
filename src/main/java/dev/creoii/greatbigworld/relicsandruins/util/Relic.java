package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public interface Relic {
    String CHARGE_KEY = "charge";

    int getMaxCharge();

    default void incrementCharge(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(CHARGE_KEY, Math.min(getMaxCharge(), nbt.getInt(CHARGE_KEY) + 1));
    }

    default void resetCharge(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(CHARGE_KEY, 0);
    }

    default boolean isAtMaxCharge(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        return nbt.getInt(CHARGE_KEY) >= getMaxCharge();
    }
}
