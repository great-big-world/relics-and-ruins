package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.creoapi.api.blockinjection.BlockEntityTypeInjection;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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

        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "oak_chest"), OAK_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "spruce_chest"), SPRUCE_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "birch_chest"), BIRCH_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "jungle_chest"), JUNGLE_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "dark_oak_chest"), DARK_OAK_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "acacia_chest"), ACACIA_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "mangrove_chest"), MANGROVE_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "cherry_chest"), CHERRY_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "bamboo_chest"), BAMBOO_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "crimson_chest"), CRIMSON_CHEST);
        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "warped_chest"), WARPED_CHEST);

        Registry.register(Registries.BLOCK, new Identifier(RelicsAndRuins.NAMESPACE, "jungle_chest"), JUNGLE_CHEST);

        BlockEntityTypeInjection.inject(BlockEntityType.DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, BLUE_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, PINK_DECORATED_POT, MAGENTA_DECORATED_POT, PURPLE_DECORATED_POT, BLACK_DECORATED_POT, GRAY_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, WHITE_DECORATED_POT);
        BlockEntityTypeInjection.inject(BlockEntityType.CHEST, OAK_CHEST, SPRUCE_CHEST, BIRCH_CHEST, JUNGLE_CHEST, DARK_OAK_CHEST, ACACIA_CHEST, MANGROVE_CHEST, CHERRY_CHEST, BAMBOO_CHEST, CRIMSON_CHEST, WARPED_CHEST);
    }
}
