package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.relicsandruins.util.TreasureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class TreasureItem extends Item {
    private final TreasureType type;

    public TreasureItem(Settings settings, TreasureType type) {
        super(settings);
        this.type = type;
    }

    public TreasureType getType() {
        return type;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.tooltip.treasure").formatted(getType().getFormatting()));
    }
}
