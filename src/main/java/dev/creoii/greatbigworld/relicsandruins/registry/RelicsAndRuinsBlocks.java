package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.block.VerticalSlabBlock;
import dev.creoii.greatbigworld.relicsandruins.block.*;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsBlocks {
    public static final Block BROWN_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BROWN));
    public static final Block RED_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_RED));
    public static final Block ORANGE_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static final Block YELLOW_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final Block LIME_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIME));
    public static final Block GREEN_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GREEN));
    public static final Block CYAN_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_CYAN));
    public static final Block BLUE_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLUE));
    public static final Block LIGHT_BLUE_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block PINK_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PINK));
    public static final Block MAGENTA_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_MAGENTA));
    public static final Block PURPLE_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PURPLE));
    public static final Block BLACK_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLACK));
    public static final Block GRAY_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block WHITE_DECORATED_POT = new DecoratedPotBlock(AbstractBlock.Settings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_WHITE));

    public static final Block OAK_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.OAK_TAN), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.OAK);
    public static final Block SPRUCE_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.SPRUCE_BROWN), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.SPRUCE);
    public static final Block BIRCH_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.PALE_YELLOW), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.BIRCH);
    public static final Block JUNGLE_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DIRT_BROWN), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.JUNGLE);
    public static final Block DARK_OAK_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.BROWN), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.DARK_OAK);
    public static final Block ACACIA_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.ORANGE), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.ACACIA);
    public static final Block MANGROVE_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.RED), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.MANGROVE);
    public static final Block CHERRY_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.TERRACOTTA_WHITE), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.CHERRY);
    public static final Block BAMBOO_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.YELLOW), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.BAMBOO);
    public static final Block CRIMSON_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DULL_PINK), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.CRIMSON);
    public static final Block WARPED_CHEST = new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST).mapColor(MapColor.DARK_AQUA), () -> {
        return BlockEntityType.CHEST;
    }, WoodType.WARPED);

    public static final Block BRAZIER = new BrazierBlock(true, 1, AbstractBlock.Settings.create().requiresTool().strength(5f, 4f).nonOpaque().luminance(state -> state.get(Properties.LIT) ? 15 : 0));
    public static final Block SOUL_BRAZIER = new BrazierBlock(false, 2, AbstractBlock.Settings.create().requiresTool().strength(5f, 4f).nonOpaque().luminance(state -> state.get(Properties.LIT) ? 10 : 0));

    public static final Block COBBLESTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_BRICK_STAIRS = new StairsBlock(COBBLESTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block COBBLESTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block VERTICAL_COBBLESTONE_BRICK_SLAB = new VerticalSlabBlock(AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block COBBLESTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block CHISELED_COBBLESTONE_BRICKS = new Block(AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block COBBLESTONE_BRICK_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(COBBLESTONE_BRICKS));
    public static final Block MOSSY_COBBLESTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE));
    public static final Block MOSSY_COBBLESTONE_BRICK_STAIRS = new StairsBlock(MOSSY_COBBLESTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
    public static final Block MOSSY_COBBLESTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
    public static final Block VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB = new VerticalSlabBlock(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));
    public static final Block MOSSY_COBBLESTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_BRICKS));

    public static final Block ICE_BRICKS = new IceBlock(AbstractBlock.Settings.copy(Blocks.ICE));
    public static final Block ICE_BRICK_STAIRS = new IceStairsBlock(ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ICE_BRICKS));
    public static final Block ICE_BRICK_SLAB = new IceSlabBlock(AbstractBlock.Settings.copy(ICE_BRICKS));
    public static final Block VERTICAL_ICE_BRICK_SLAB = new IceVerticalSlabBlock(AbstractBlock.Settings.copy(ICE_BRICKS));
    public static final Block ICE_BRICK_WALL = new IceWallBlock(AbstractBlock.Settings.copy(ICE_BRICKS));
    public static final Block PACKED_ICE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.PACKED_ICE));
    public static final Block PACKED_ICE_BRICK_STAIRS = new StairsBlock(PACKED_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
    public static final Block PACKED_ICE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
    public static final Block VERTICAL_PACKED_ICE_BRICK_SLAB = new VerticalSlabBlock(AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
    public static final Block PACKED_ICE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(PACKED_ICE_BRICKS));
    public static final Block BLUE_ICE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.BLUE_ICE));
    public static final Block BLUE_ICE_BRICK_STAIRS = new StairsBlock(BLUE_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
    public static final Block BLUE_ICE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
    public static final Block VERTICAL_BLUE_ICE_BRICK_SLAB = new VerticalSlabBlock(AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));
    public static final Block BLUE_ICE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BLUE_ICE_BRICKS));

    public static final Block SNOW_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK));
    public static final Block SNOW_BRICK_STAIRS = new StairsBlock(SNOW_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block VERTICAL_SNOW_BRICK_SLAB = new VerticalSlabBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));

    public static void register() {
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), BROWN_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "red_decorated_pot"), RED_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), ORANGE_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), YELLOW_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), LIME_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "green_decorated_pot"), GREEN_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), CYAN_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), BLUE_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), LIGHT_BLUE_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), PINK_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), MAGENTA_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), PURPLE_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "black_decorated_pot"), BLACK_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), GRAY_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), LIGHT_GRAY_DECORATED_POT);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "white_decorated_pot"), WHITE_DECORATED_POT);

        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "oak_chest"), OAK_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "spruce_chest"), SPRUCE_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "birch_chest"), BIRCH_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "jungle_chest"), JUNGLE_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "dark_oak_chest"), DARK_OAK_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "acacia_chest"), ACACIA_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "mangrove_chest"), MANGROVE_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cherry_chest"), CHERRY_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "bamboo_chest"), BAMBOO_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "crimson_chest"), CRIMSON_CHEST);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "warped_chest"), WARPED_CHEST);

        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "brazier"), BRAZIER);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "soul_brazier"), SOUL_BRAZIER);

        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_cobblestone_brick_slab"), VERTICAL_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), COBBLESTONE_BRICK_WALL);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), CHISELED_COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), COBBLESTONE_BRICK_PILLAR);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), MOSSY_COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), MOSSY_COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), MOSSY_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_mossy_cobblestone_brick_slab"), VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), MOSSY_COBBLESTONE_BRICK_WALL);

        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "ice_bricks"), ICE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), ICE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_slab"), ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_ice_brick_slab"), VERTICAL_ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_wall"), ICE_BRICK_WALL);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), PACKED_ICE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), PACKED_ICE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), PACKED_ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_packed_ice_brick_slab"), VERTICAL_PACKED_ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), PACKED_ICE_BRICK_WALL);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), BLUE_ICE_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), BLUE_ICE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), BLUE_ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_blue_ice_brick_slab"), VERTICAL_BLUE_ICE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), BLUE_ICE_BRICK_WALL);

        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "snow_bricks"), SNOW_BRICKS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), SNOW_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_slab"), SNOW_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "vertical_snow_brick_slab"), VERTICAL_SNOW_BRICK_SLAB);
        Registry.register(Registries.BLOCK, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_wall"), SNOW_BRICK_WALL);

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
