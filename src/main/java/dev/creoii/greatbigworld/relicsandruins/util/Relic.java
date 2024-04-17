package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public interface Relic {
    String CHARGE_KEY = "charge";
    String ORIGIN_KEY = "origin";

    int getMaxCharge();

    default void setOrigin(ItemStack stack, BlockPos pos) {
        NbtCompound nbt = stack.getOrCreateNbt();
        NbtCompound origin = NbtHelper.fromBlockPos(pos);;
        nbt.put(ORIGIN_KEY, origin);
    }

    @Nullable
    default BlockPos getOrigin(ItemStack stack) {
        if (stack.hasNbt()) {
            NbtCompound nbt = stack.getOrCreateNbt();
            if (nbt.contains(ORIGIN_KEY))
                return NbtHelper.toBlockPos(nbt.getCompound(ORIGIN_KEY));
        }
        return null;
    }

    default int getChargeItemBarStep(ItemStack stack) {
        return MathHelper.clamp(getCharge(stack) - getMaxCharge(), 0, getMaxCharge());
    }

    default int getCharge(ItemStack stack) {
        if (stack.hasNbt()) {
            NbtCompound nbt = stack.getOrCreateNbt();
            if (nbt.contains(CHARGE_KEY))
                return nbt.getInt(CHARGE_KEY);
        }
        return -1;
    }

    default void incrementCharge(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(CHARGE_KEY, Math.min(getMaxCharge(), nbt.getInt(CHARGE_KEY) + 1));
    }

    default void resetCharge(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(CHARGE_KEY, 0);
    }

    default boolean isCharged(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (nbt.contains(CHARGE_KEY))
            return nbt.getInt(CHARGE_KEY) >= getMaxCharge();
        return false;
    }
}
