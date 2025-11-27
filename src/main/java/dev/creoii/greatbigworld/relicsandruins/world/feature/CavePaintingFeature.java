package dev.creoii.greatbigworld.relicsandruins.world.feature;

import com.mojang.serialization.Codec;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CavePaintingFeature extends Feature<DefaultFeatureConfig> {
    public CavePaintingFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        if (world.getBlockState(pos).isOf(Blocks.STONE)) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            boolean exposed = false;
            for (Direction direction : Direction.values()) {
                mutable.set(pos, direction);
                if (world.getBlockState(mutable).isAir()) {
                    exposed = true;
                    break;
                }
            }

            if (exposed) {
                Random random = context.getRandom();

                int engravings = EngravedStoneBlock.Engraving.values().length;
                int colors = DyeColor.values().length;

                world.setBlockState(pos, RelicsAndRuinsBlocks.ENGRAVED_STONE.getDefaultState().with(EngravedStoneBlock.ENGRAVING, EngravedStoneBlock.Engraving.values()[random.nextInt(engravings)]).with(EngravedStoneBlock.COLOR, DyeColor.values()[random.nextInt(colors)]), 3);

                System.out.println(context.getOrigin());
                return true;
            }
        }

        return false;
    }
}
