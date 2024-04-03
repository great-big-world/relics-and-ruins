package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.creoapi.api.blockinjection.BlockEntityTypeInjection;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsBlocks {
    public static final Block BROWN_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BROWN));
    public static final Block RED_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_RED));
    public static final Block ORANGE_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_ORANGE));
    public static final Block YELLOW_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final Block LIME_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIME));
    public static final Block GREEN_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GREEN));
    public static final Block CYAN_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_CYAN));
    public static final Block BLUE_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLUE));
    public static final Block LIGHT_BLUE_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
    public static final Block PINK_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PINK));
    public static final Block MAGENTA_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_MAGENTA));
    public static final Block PURPLE_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_PURPLE));
    public static final Block BLACK_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_BLACK));
    public static final Block GRAY_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block LIGHT_GRAY_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block WHITE_DECORATED_POT = new DecoratedPotBlock(FabricBlockSettings.copy(Blocks.DECORATED_POT).mapColor(MapColor.TERRACOTTA_WHITE));

    public static final Block COBBLESTONE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_BRICK_STAIRS = new StairsBlock(COBBLESTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(Blocks.COBBLESTONE_STAIRS));
    public static final Block COBBLESTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_SLAB));
    public static final Block COBBLESTONE_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL).solid());
    public static final Block CHISELED_COBBLESTONE_BRICKS = new Block(FabricBlockSettings.copy(COBBLESTONE_BRICKS));
    public static final Block COBBLESTONE_BRICK_PILLAR = new PillarBlock(FabricBlockSettings.copy(COBBLESTONE_BRICKS));
    public static final Block MOSSY_COBBLESTONE_BRICKS = new Block(FabricBlockSettings.copy(Blocks.MOSSY_COBBLESTONE));
    public static final Block MOSSY_COBBLESTONE_BRICK_STAIRS = new StairsBlock(MOSSY_COBBLESTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(Blocks.MOSSY_COBBLESTONE_STAIRS));
    public static final Block MOSSY_COBBLESTONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.MOSSY_COBBLESTONE_SLAB));
    public static final Block MOSSY_COBBLESTONE_BRICK_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.MOSSY_COBBLESTONE_WALL).solid());

    public static void register() {
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "brown_decorated_pot"), BROWN_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "red_decorated_pot"), RED_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "orange_decorated_pot"), ORANGE_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "yellow_decorated_pot"), YELLOW_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "lime_decorated_pot"), LIME_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "green_decorated_pot"), GREEN_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cyan_decorated_pot"), CYAN_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "blue_decorated_pot"), BLUE_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "light_blue_decorated_pot"), LIGHT_BLUE_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "pink_decorated_pot"), PINK_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "magenta_decorated_pot"), MAGENTA_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "purple_decorated_pot"), PURPLE_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "black_decorated_pot"), BLACK_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "gray_decorated_pot"), GRAY_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "light_gray_decorated_pot"), LIGHT_GRAY_DECORATED_POT);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "white_decorated_pot"), WHITE_DECORATED_POT);

        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_bricks"), COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_stairs"), COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_slab"), COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_wall"), COBBLESTONE_BRICK_WALL);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "chiseled_cobblestone_bricks"), CHISELED_COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_pillar"), COBBLESTONE_BRICK_PILLAR);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_bricks"), MOSSY_COBBLESTONE_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_stairs"), MOSSY_COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_slab"), MOSSY_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_wall"), MOSSY_COBBLESTONE_BRICK_WALL);

        BlockEntityTypeInjection.inject(BlockEntityType.DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, BLUE_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, PINK_DECORATED_POT, MAGENTA_DECORATED_POT, PURPLE_DECORATED_POT, BLACK_DECORATED_POT, GRAY_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, WHITE_DECORATED_POT);
    }
}
