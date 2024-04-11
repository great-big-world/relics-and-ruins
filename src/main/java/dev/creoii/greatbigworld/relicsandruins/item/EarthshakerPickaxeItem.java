package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.relicsandruins.util.Relic;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EarthshakerPickaxeItem extends PickaxeItem implements Relic {
    public EarthshakerPickaxeItem(Settings settings) {
        super(ToolMaterials.NETHERITE, 4, 1f, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        resetCharge(stack);
        return stack;
    }

    @Override
    public int getMaxCharge() {
        return 27;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        incrementCharge(stack);
        if (isAtMaxCharge(stack)) {
            resetCharge(stack);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
