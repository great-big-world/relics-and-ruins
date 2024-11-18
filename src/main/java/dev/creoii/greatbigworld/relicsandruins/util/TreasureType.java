package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.util.Formatting;
import net.minecraft.util.StringIdentifiable;

public enum TreasureType implements StringIdentifiable {
    EMPTY(Formatting.GRAY),
    DESERT(Formatting.GOLD),
    JUNGLE(Formatting.GREEN),
    SWAMP(Formatting.DARK_GREEN);

    private final Formatting formatting;

    TreasureType(Formatting formatting) {
        this.formatting = formatting;
    }

    public Formatting getFormatting() {
        return formatting;
    }

    @Override
    public String asString() {
        return name().toLowerCase();
    }
}