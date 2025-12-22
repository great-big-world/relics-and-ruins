package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.block.VerticalSlabBlock;
import dev.creoii.greatbigworld.block.FacingBlock;
import dev.creoii.greatbigworld.relicsandruins.block.*;
import dev.creoii.greatbigworld.util.RegistryHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class RelicsAndRuinsBlocks {
    public static Block BROWN_DECORATED_POT;
    public static Block RED_DECORATED_POT;
    public static Block ORANGE_DECORATED_POT;
    public static Block YELLOW_DECORATED_POT;
    public static Block LIME_DECORATED_POT;
    public static Block GREEN_DECORATED_POT;
    public static Block CYAN_DECORATED_POT;
    public static Block BLUE_DECORATED_POT;
    public static Block LIGHT_BLUE_DECORATED_POT;
    public static Block PINK_DECORATED_POT;
    public static Block MAGENTA_DECORATED_POT;
    public static Block PURPLE_DECORATED_POT;
    public static Block BLACK_DECORATED_POT;
    public static Block GRAY_DECORATED_POT;
    public static Block LIGHT_GRAY_DECORATED_POT;
    public static Block WHITE_DECORATED_POT;

    public static Block COBBLESTONE_BRICKS;
    public static Block COBBLESTONE_BRICK_STAIRS;
    public static Block COBBLESTONE_BRICK_SLAB;
    public static Block VERTICAL_COBBLESTONE_BRICK_SLAB;
    public static Block COBBLESTONE_BRICK_WALL;
    public static Block CHISELED_COBBLESTONE_BRICKS;
    public static Block COBBLESTONE_BRICK_PILLAR;
    public static Block MOSSY_COBBLESTONE_BRICKS;
    public static Block MOSSY_COBBLESTONE_BRICK_STAIRS;
    public static Block MOSSY_COBBLESTONE_BRICK_SLAB;
    public static Block VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB;
    public static Block MOSSY_COBBLESTONE_BRICK_WALL;
    public static Block COBBLED_DEEPSLATE_BRICKS;
    public static Block COBBLED_DEEPSLATE_BRICK_STAIRS;
    public static Block COBBLED_DEEPSLATE_BRICK_SLAB;
    public static Block VERTICAL_COBBLED_DEEPSLATE_BRICK_SLAB;
    public static Block COBBLED_DEEPSLATE_BRICK_WALL;

    public static Block ICE_BRICKS;
    public static Block ICE_BRICK_STAIRS;
    public static Block ICE_BRICK_SLAB;
    public static Block VERTICAL_ICE_BRICK_SLAB;
    public static Block ICE_BRICK_WALL;
    public static Block PACKED_ICE_BRICKS;
    public static Block PACKED_ICE_BRICK_STAIRS;
    public static Block PACKED_ICE_BRICK_SLAB;
    public static Block VERTICAL_PACKED_ICE_BRICK_SLAB;
    public static Block PACKED_ICE_BRICK_WALL;
    public static Block CHISELED_PACKED_ICE_BRICKS;
    public static Block BLUE_ICE_BRICKS;
    public static Block BLUE_ICE_BRICK_STAIRS;
    public static Block BLUE_ICE_BRICK_SLAB;
    public static Block VERTICAL_BLUE_ICE_BRICK_SLAB;
    public static Block BLUE_ICE_BRICK_WALL;

    public static Block SNOW_BRICKS;
    public static Block SNOW_BRICK_STAIRS;
    public static Block SNOW_BRICK_SLAB;
    public static Block VERTICAL_SNOW_BRICK_SLAB;
    public static Block SNOW_BRICK_WALL;
    public static Block CHISELED_SNOW_BRICKS;

    public static Block CHISELED_PRISMARINE_BRICKS;

    public static Block ENGRAVED_STONE;

    public static void register() {
        BROWN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BROWN));
        RED_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "red_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_RED));
        ORANGE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_ORANGE));
        YELLOW_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_YELLOW));
        LIME_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_GREEN));
        GREEN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "green_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GREEN));
        CYAN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_CYAN));
        BLUE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLUE));
        LIGHT_BLUE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
        PINK_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PINK));
        MAGENTA_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_MAGENTA));
        PURPLE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PURPLE));
        BLACK_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "black_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLACK));
        GRAY_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GRAY));
        LIGHT_GRAY_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        WHITE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "white_decorated_pot"), DecoratedPotBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_WHITE));

        COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));
        COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), settings -> new StairBlock(COBBLESTONE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        VERTICAL_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_cobblestone_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        CHISELED_COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_PILLAR = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), FacingBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE));
        MOSSY_COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), settings -> new StairBlock(MOSSY_COBBLESTONE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLESTONE_BRICKS));
        VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_mossy_cobblestone_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_COBBLESTONE_BRICKS));
        COBBLED_DEEPSLATE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobbled_deepslate_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE));
        COBBLED_DEEPSLATE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobbled_deepslate_brick_stairs"), settings -> new StairBlock(COBBLED_DEEPSLATE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(COBBLED_DEEPSLATE_BRICKS));
        COBBLED_DEEPSLATE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobbled_deepslate_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLED_DEEPSLATE_BRICKS));
        VERTICAL_COBBLED_DEEPSLATE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_cobbled_deepslate_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLED_DEEPSLATE_BRICKS));
        COBBLED_DEEPSLATE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobbled_deepslate_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(COBBLED_DEEPSLATE_BRICKS));

        ICE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.ICE));
        ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), settings -> new IceStairsBlock(ICE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS));
        ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_slab"), IceSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS));
        VERTICAL_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_ice_brick_slab"), IceVerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS));
        ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_wall"), IceWallBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS));
        PACKED_ICE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
        PACKED_ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), settings -> new StairBlock(PACKED_ICE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
        PACKED_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
        VERTICAL_PACKED_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_packed_ice_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
        PACKED_ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
        CHISELED_PACKED_ICE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "chiseled_packed_ice_bricks"), BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS));
        BLUE_ICE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE));
        BLUE_ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), settings -> new StairBlock(BLUE_ICE_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS));
        BLUE_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS));
        VERTICAL_BLUE_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_blue_ice_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS));
        BLUE_ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS));

        SNOW_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_bricks"), BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(.35f).sound(SoundType.SNOW));
        SNOW_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), settings -> new StairBlock(SNOW_BRICKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS));
        SNOW_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS));
        VERTICAL_SNOW_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vertical_snow_brick_slab"), VerticalSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS));
        SNOW_BRICK_WALL = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS));
        CHISELED_SNOW_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "chiseled_snow_bricks"), BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS));

        CHISELED_PRISMARINE_BRICKS = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "chiseled_prismarine_bricks"), BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS));

        ENGRAVED_STONE = RegistryHelper.registerBlock(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraved_stone"), EngravedStoneBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

        BlockEntityType.DECORATED_POT.addSupportedBlock(BROWN_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(RED_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(ORANGE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(YELLOW_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIME_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(GREEN_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(CYAN_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(BLUE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIGHT_BLUE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(PINK_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(MAGENTA_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(PURPLE_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(BLACK_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(GRAY_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(LIGHT_GRAY_DECORATED_POT);
        BlockEntityType.DECORATED_POT.addSupportedBlock(WHITE_DECORATED_POT);
    }
}
