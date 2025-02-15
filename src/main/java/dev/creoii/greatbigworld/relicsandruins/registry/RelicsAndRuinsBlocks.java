package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.block.VerticalSlabBlock;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import dev.creoii.greatbigworld.util.RegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

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

    public static Block OAK_CHEST;
    public static Block SPRUCE_CHEST;
    public static Block BIRCH_CHEST;
    public static Block JUNGLE_CHEST;
    public static Block DARK_OAK_CHEST;
    public static Block ACACIA_CHEST;
    public static Block MANGROVE_CHEST;
    public static Block CHERRY_CHEST;
    public static Block PALE_OAK_CHEST;
    public static Block BAMBOO_CHEST;
    public static Block CRIMSON_CHEST;
    public static Block WARPED_CHEST;

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

    public static void register() {
        BROWN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BROWN));
        RED_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "red_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_RED));
        ORANGE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_ORANGE));
        YELLOW_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_YELLOW));
        LIME_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIME));
        GREEN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "green_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GREEN));
        CYAN_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_CYAN));
        BLUE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLUE));
        LIGHT_BLUE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
        PINK_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PINK));
        MAGENTA_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_MAGENTA));
        PURPLE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PURPLE));
        BLACK_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "black_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLACK));
        GRAY_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GRAY));
        LIGHT_GRAY_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
        WHITE_DECORATED_POT = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "white_decorated_pot"), DecoratedPotBlock::new, AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BROWN));

        OAK_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "oak_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.OAK), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.OAK_TAN));
        SPRUCE_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "spruce_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.SPRUCE), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.SPRUCE_BROWN));
        BIRCH_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "birch_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.BIRCH), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.PALE_YELLOW));
        JUNGLE_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "jungle_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.JUNGLE), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DIRT_BROWN));
        DARK_OAK_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "dark_oak_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.DARK_OAK), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.BROWN));
        ACACIA_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "acacia_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.ACACIA), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.ORANGE));
        MANGROVE_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "mangrove_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.MANGROVE), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.RED));
        CHERRY_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cherry_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.CHERRY), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.TERRACOTTA_WHITE));
        PALE_OAK_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "pale_oak_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.PALE_OAK), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.OFF_WHITE));
        BAMBOO_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "bamboo_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.BAMBOO), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.YELLOW));
        CRIMSON_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "crimson_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.CRIMSON), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DULL_PINK));
        WARPED_CHEST = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "warped_chest"), settings -> new ChestBlock(settings, () -> {
            return BlockEntityType.CHEST;
        }, WoodType.WARPED), AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DARK_AQUA));

        COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
        COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), settings -> new StairsBlock(COBBLESTONE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        VERTICAL_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_cobblestone_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        CHISELED_COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        COBBLESTONE_BRICK_PILLAR = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), PillarBlock::new, AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE));
        MOSSY_COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), settings -> new StairsBlock(MOSSY_COBBLESTONE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
        VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_mossy_cobblestone_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
        MOSSY_COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));

        ICE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "ice_bricks"), AbstractBlock.Settings.copy(Blocks.ICE));
        ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), settings -> new StairsBlock(ICE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(ICE_BRICKS));
        ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(ICE_BRICKS));
        VERTICAL_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_ice_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(ICE_BRICKS));
        ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(ICE_BRICKS));
        PACKED_ICE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), AbstractBlock.Settings.copy(Blocks.PACKED_ICE));
        PACKED_ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), settings -> new StairsBlock(PACKED_ICE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
        PACKED_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
        VERTICAL_PACKED_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_packed_ice_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
        PACKED_ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
        BLUE_ICE_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), AbstractBlock.Settings.copy(Blocks.BLUE_ICE));
        BLUE_ICE_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), settings -> new StairsBlock(BLUE_ICE_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
        BLUE_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
        VERTICAL_BLUE_ICE_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_blue_ice_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
        BLUE_ICE_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));

        SNOW_BRICKS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "snow_bricks"), AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK).strength(.3f));
        SNOW_BRICK_STAIRS = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), settings -> new StairsBlock(SNOW_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(SNOW_BRICKS));
        SNOW_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_slab"), SlabBlock::new, AbstractBlock.Settings.copy(SNOW_BRICKS));
        VERTICAL_SNOW_BRICK_SLAB = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "vertical_snow_brick_slab"), VerticalSlabBlock::new, AbstractBlock.Settings.copy(SNOW_BRICKS));
        SNOW_BRICK_WALL = RegistryHelper.registerBlock(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_wall"), WallBlock::new, AbstractBlock.Settings.copy(SNOW_BRICKS));

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

        BlockEntityType.CHEST.addSupportedBlock(OAK_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(SPRUCE_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(BIRCH_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(JUNGLE_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(DARK_OAK_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(ACACIA_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(MANGROVE_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(CHERRY_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(BAMBOO_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(WARPED_CHEST);
        BlockEntityType.CHEST.addSupportedBlock(CRIMSON_CHEST);
    }
}
