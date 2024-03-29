package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.state.property.IntProperty;

public final class DecoratedPotHelper {
    public static final IntProperty TRIM = IntProperty.of("trim", 0, 21);

    public static DecoratedPotBlock withColor(DecoratedPotBlock block, MapColor color) {
        ((DyedDecoratedPot) block).gbw$setColor(color);
        return block;
    }

    public static int getTrim(DecoratedPotBlockEntity blockEntity) {
        return ((TrimmedDecoratedPot) blockEntity).gbw$getTrim();
    }
}
