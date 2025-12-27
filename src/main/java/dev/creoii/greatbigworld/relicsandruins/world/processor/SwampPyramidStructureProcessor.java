package dev.creoii.greatbigworld.relicsandruins.world.processor;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsStructureProcessors;
import dev.creoii.greatbigworld.thealterworld.registry.TheAlterworldBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class SwampPyramidStructureProcessor extends StructureProcessor {
    public static final SwampPyramidStructureProcessor INSTANCE = new SwampPyramidStructureProcessor();
    public static final MapCodec<SwampPyramidStructureProcessor> CODEC = MapCodec.unit(() -> INSTANCE);
    private static final HolderSet<Block> STAIRS = HolderSet.direct(Holder::direct, Blocks.COBBLESTONE_STAIRS, RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS);
    private static final Map<Block, BlockStateProvider> REPLACEMENT_MAP = Util.make(Maps.newHashMap(), replacements -> {
        replacements.put(RelicsAndRuinsBlocks.COBBLESTONE_BRICKS, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.COBBLESTONE.defaultBlockState(), 2).add(Blocks.MOSSY_COBBLESTONE.defaultBlockState(), 5).add(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICKS.defaultBlockState(), 9).add(RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS.defaultBlockState(), 1).build()));
        replacements.put(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_SLAB, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.COBBLESTONE_SLAB.defaultBlockState(), 1).add(Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState(), 3).add(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB.defaultBlockState(), 5).build()));
        replacements.put(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.COBBLESTONE_STAIRS.defaultBlockState(), 1).add(Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState(), 3).add(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS.defaultBlockState(), 5).build()));
        replacements.put(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_WALL, new WeightedStateProvider(WeightedList.<BlockState>builder().add(Blocks.COBBLESTONE_WALL.defaultBlockState(), 1).add(Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState(), 3).add(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_WALL.defaultBlockState(), 5).build()));
    });

    @Override
    public StructureTemplate.@Nullable StructureBlockInfo processBlock(LevelReader levelReader, BlockPos blockPos, BlockPos blockPos2, StructureTemplate.StructureBlockInfo structureBlockInfo, StructureTemplate.StructureBlockInfo structureBlockInfo2, StructurePlaceSettings structurePlaceSettings) {
        RandomSource random = structurePlaceSettings.getRandom(structureBlockInfo.pos().above());

        if ((structureBlockInfo.state().is(TheAlterworldBlocks.REINFORCED_DEEPSLATE) || structureBlockInfo.state().is(Blocks.REINFORCED_DEEPSLATE)) && !levelReader.registryAccess().lookupOrThrow(Registries.DIMENSION_TYPE).getResourceKey(levelReader.dimensionType()).get().equals(BuiltinDimensionTypes.OVERWORLD)) {
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo.pos(), RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS.defaultBlockState(), structureBlockInfo.nbt());
        }

        if (random.nextFloat() < .95f && levelReader.getBlockState(structureBlockInfo2.pos().above()).is(STAIRS) && structureBlockInfo.state().is(RelicsAndRuinsBlocks.COBBLESTONE_BRICKS)) {
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo.pos(), RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS.defaultBlockState(), structureBlockInfo.nbt());
        }

        random = structurePlaceSettings.getRandom(structureBlockInfo2.pos());
        BlockState current = structureBlockInfo2.state();
        Block block = current.getBlock();
        if (random.nextFloat() < .6f && REPLACEMENT_MAP.containsKey(block)) {
            if (random.nextFloat() < .08f)
                return structureBlockInfo;
            BlockState state = REPLACEMENT_MAP.get(block).getState(random, structureBlockInfo.pos());
            if (current.hasProperty(StairBlock.FACING)) {
                state = state.setValue(StairBlock.FACING, current.getValue(StairBlock.FACING));
            }

            if (current.hasProperty(StairBlock.HALF)) {
                state = state.setValue(StairBlock.HALF, current.getValue(StairBlock.HALF));
            }

            if (current.hasProperty(StairBlock.SHAPE)) {
                state = state.setValue(StairBlock.SHAPE, current.getValue(StairBlock.SHAPE));
            }

            if (current.hasProperty(SlabBlock.TYPE)) {
                state = state.setValue(SlabBlock.TYPE, current.getValue(SlabBlock.TYPE));
            }

            if (current.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, current.getValue(BlockStateProperties.WATERLOGGED));
            }

            return new StructureTemplate.StructureBlockInfo(structureBlockInfo2.pos(), state, structureBlockInfo2.nbt());
        }
        return structureBlockInfo2;
    }

    protected StructureProcessorType<?> getType() {
        return RelicsAndRuinsStructureProcessors.SWAMP_PYRAMID_PROCESSOR;
    }
}