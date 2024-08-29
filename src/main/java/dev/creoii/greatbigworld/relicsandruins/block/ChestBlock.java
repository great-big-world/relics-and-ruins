package dev.creoii.greatbigworld.relicsandruins.block;

import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public class ChestBlock extends net.minecraft.block.ChestBlock {
    private final WoodType woodType;

    public ChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier, WoodType woodType) {
        super(settings, supplier);
        this.woodType = woodType;
    }

    public WoodType getWoodType() {
        return woodType;
    }
}
