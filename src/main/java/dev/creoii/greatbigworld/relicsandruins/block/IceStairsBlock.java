package dev.creoii.greatbigworld.relicsandruins.block;

import dev.creoii.greatbigworld.block.TranslucentStairsBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class IceStairsBlock extends TranslucentStairsBlock {
    public IceStairsBlock(BlockState baseBlockState, Properties settings) {
        super(baseBlockState, settings);
    }

    public static BlockState getMeltedState() {
        return Blocks.WATER.defaultBlockState();
    }

    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (!EnchantmentHelper.hasTag(tool, EnchantmentTags.PREVENTS_ICE_MELTING)) {
            if (world.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, pos)) {
                world.removeBlock(pos, false);
                return;
            }

            BlockState blockState = world.getBlockState(pos.below());
            if (blockState.blocksMotion() || blockState.liquid()) {
                world.setBlockAndUpdate(pos, getMeltedState());
            }
        }
    }

    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (world.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightBlock()) {
            melt(state, world, pos);
        }
    }

    protected void melt(BlockState state, Level world, BlockPos pos) {
        if (world.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, pos)) {
            world.removeBlock(pos, false);
        } else {
            world.setBlock(pos, getMeltedState(), 2);
            world.neighborChanged(pos, getMeltedState().getBlock(), null);
        }
    }
}
