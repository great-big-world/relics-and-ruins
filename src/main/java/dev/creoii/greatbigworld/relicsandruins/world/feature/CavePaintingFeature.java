package dev.creoii.greatbigworld.relicsandruins.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class CavePaintingFeature extends Feature<CavePaintingFeatureConfig> {
    public CavePaintingFeature(Codec<CavePaintingFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<CavePaintingFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        CavePaintingFeatureConfig config = context.getConfig();

        // Must be stone where the feature spawns
        if (!world.getBlockState(origin).isOf(Blocks.STONE))
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        // --- 1. Detect exposed face ---
        Direction exposedDir = null;
        for (Direction dir : Direction.values()) {
            mutable.set(origin, dir);
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
                        : exposedDir.rotateYClockwise(); // wall = horizontal line

        // The perpendicular offset direction for stacking bands
        Direction bandOffsetDir =
                (exposedDir.getAxis() == Direction.Axis.Y) ? Direction.UP : exposedDir;
        // If on floor/ceiling → shift vertically
        // If on wall → shift deeper/shallower along the exposed direction

        // --- 3. Generate multiple lines ---
        for (int band = 0; band < config.lineCount().get(random); band++) {

            int length = config.lineLength().get(random);

            BlockPos current = origin.offset(
                    bandOffsetDir, band * config.linePadding().get(random)
            );

            drawPaintingLine(world, current, exposedDir, lineDir, length,
                    config.searchRadius().get(random), config.provider(), random);
        }

        return true;
    }

    // ---- LINE DRAWING ---- //

    private void drawPaintingLine(
            StructureWorldAccess world,
            BlockPos start,
            Direction exposedDir,
            Direction lineDir,
            int length,
            int searchRadius,
            BlockStateProvider provider,
            Random random) {

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

            current = current.offset(lineDir);
        }
    }

    // --- Valid placement: must be STONE + exposed to air/water --- //

    private static boolean canPlacePainting(StructureWorldAccess world, BlockPos pos, Direction exposedDir) {
        return world.getBlockState(pos).isOf(Blocks.STONE)
                && isExposed(world, pos.offset(exposedDir));
    }

    /** Air OR water counts as exposed surface. */
    private static boolean isExposed(StructureWorldAccess world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.isAir() || state.getFluidState().isIn(FluidTags.WATER);
    }

    /** Search along the line direction for the next valid stone face. */
    private static BlockPos findFallback(
            StructureWorldAccess world,
            BlockPos pos,
            Direction lineDir,
            Direction exposedDir,
            int radius) {

        for (int offset = 1; offset <= radius; offset++) {
            BlockPos f = pos.offset(lineDir, offset);
            if (canPlacePainting(world, f, exposedDir))
                return f;

            BlockPos b = pos.offset(lineDir, -offset);
            if (canPlacePainting(world, b, exposedDir))
                return b;
        }
        return null;
    }

    // --- Place one painting block from provider --- //

    private static void placePainting(StructureWorldAccess world, BlockPos pos, BlockStateProvider provider, Random random) {
        world.setBlockState(pos, provider.get(random, pos), 3);
    }
}