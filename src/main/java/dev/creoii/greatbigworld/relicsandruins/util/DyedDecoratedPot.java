package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.block.MapColor;
import org.jetbrains.annotations.Nullable;

public interface DyedDecoratedPot {
    @Nullable
    MapColor gbw$getColor();

    void gbw$setColor(@Nullable MapColor color);
}
