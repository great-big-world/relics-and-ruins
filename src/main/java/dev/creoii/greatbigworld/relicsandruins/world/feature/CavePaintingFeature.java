package dev.creoii.greatbigworld.relicsandruins.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CavePaintingFeature extends Feature<CavePaintingFeatureConfig> {
    public CavePaintingFeature(Codec<CavePaintingFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CavePaintingFeatureConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        CavePaintingFeatureConfig config = context.config();

        // Must be stone where the feature spawns
        if (!world.getBlockState(origin).is(Blocks.STONE))
            return false;

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        // --- 1. Detect exposed face ---
        Direction exposedDir = null;
        for (Direction dir : Direction.values()) {
            mutable.setWithOffset(origin, dir);
            if (isExposed(world, mutable)) {  // water OR air counts
                exposedDir = dir;
                break;
            }
        }

        if (exposedDir == null)
            return false;

        // --- 2. Determine primary line direction ---
        Direction lineDir =
                (exposedDir.getAxis() == Direction.Axis.Y)
                        ? Direction.NORTH     // ceiling/floor = north/south
                        : exposedDir.getCounterClockWise(); // wall = horizontal line

        // The perpendicular offset direction for stacking bands
        Direction bandOffsetDir =
                (exposedDir.getAxis() == Direction.Axis.Y) ? Direction.UP : exposedDir;
        // If on floor/ceiling → shift vertically
        // If on wall → shift deeper/shallower along the exposed direction

        // --- 3. Generate multiple lines ---
        for (int band = 0; band < config.lineCount().sample(random); band++) {

            int length = config.lineLength().sample(random);

            BlockPos current = origin.relative(
                    bandOffsetDir, band * config.linePadding().sample(random)
            );

            drawPaintingLine(world, current, exposedDir, lineDir, length,
                    config.searchRadius().sample(random), config.provider(), random);
        }

        return true;
    }

    // ---- LINE DRAWING ---- //

    private void drawPaintingLine(
            WorldGenLevel world,
            BlockPos start,
            Direction exposedDir,
            Direction lineDir,
            int length,
            int searchRadius,
            BlockStateProvider provider,
            RandomSource random) {

        BlockPos current = start;

        for (int i = 0; i < length; i++) {

            if (canPlacePainting(world, current, exposedDir)) {
                placePainting(world, current, provider, random);
            } else {
                BlockPos fallback = findFallback(world, current, lineDir, exposedDir, searchRadius);
                if (fallback == null)
                    break;

                current = fallback;
                placePainting(world, current, provider, random);
            }

            current = current.relative(lineDir);
        }
    }

    // --- Valid placement: must be STONE + exposed to air/water --- //

    private static boolean canPlacePainting(WorldGenLevel world, BlockPos pos, Direction exposedDir) {
        return world.getBlockState(pos).is(Blocks.STONE)
                && isExposed(world, pos.relative(exposedDir));
    }

    /** Air OR water counts as exposed surface. */
    private static boolean isExposed(WorldGenLevel world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.isAir() || state.getFluidState().is(FluidTags.WATER);
    }

    /** Search along the line direction for the next valid stone face. */
    private static BlockPos findFallback(
            WorldGenLevel world,
            BlockPos pos,
            Direction lineDir,
            Direction exposedDir,
            int radius) {

        for (int offset = 1; offset <= radius; offset++) {
            BlockPos f = pos.relative(lineDir, offset);
            if (canPlacePainting(world, f, exposedDir))
                return f;

            BlockPos b = pos.relative(lineDir, -offset);
            if (canPlacePainting(world, b, exposedDir))
                return b;
        }
        return null;
    }

    // --- Place one painting block from provider --- //

    private static void placePainting(WorldGenLevel world, BlockPos pos, BlockStateProvider provider, RandomSource random) {
        world.setBlock(pos, provider.getState(random, pos), 3);
    }
}