package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EarthshakerPickaxeItem extends PickaxeItem {
    public EarthshakerPickaxeItem(Settings settings) {
        super(ToolMaterials.NETHERITE, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        RelicComponent.resetCharge(stack);
        return stack;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        RelicComponent.incrementCharge(stack);
        if (RelicComponent.isCharged(stack)) {
            for (BlockPos pos1: earthquake(pos, 8, 5)) {
                world.breakBlock(pos1, true, miner);
            }
            RelicComponent.resetCharge(stack);
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    public List<BlockPos> earthquake(BlockPos center, int count, int distance) {
        List<BlockPos> list = new ArrayList<>();
        Random random = Random.create();
        List<Vec3d> directions = getDirections(count);
        for (Vec3d dir : directions) {
            BlockPos.Mutable current = new BlockPos(center).mutableCopy();
            for (int i = 0; i < distance + random.nextInt(5) - 2; ++i) {
                int x = center.getX() + (int) Math.round(dir.x * (i + 1)) + random.nextInt(3) - 1;
                int y = center.getY() + (int) Math.round(dir.y * (i + 1)) + random.nextInt(3) - 1;
                int z = center.getZ() + (int) Math.round(dir.z * (i + 1)) + random.nextInt(3) - 1;
                list.add(current.set(x, y, z));
            }
        }
        return list;
    }

    private List<Vec3d> getDirections(int count) {
        List<Vec3d> directions = new ArrayList<>();
        double angleIncrement = 2 * Math.PI / count;
        for (int i = 0; i < count; i++) {
            double angle = i * angleIncrement;
            directions.add(new Vec3d(Math.cos(angle), Math.sin(angle), 0));
        }
        return directions;
    }
}
