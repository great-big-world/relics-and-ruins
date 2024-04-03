package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.creoapi.api.item.CreoItemSettings;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsItems {
    public static final Item BROWN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BROWN_DECORATED_POT, new CreoItemSettings());
    public static final Item RED_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.RED_DECORATED_POT, new CreoItemSettings());
    public static final Item ORANGE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.ORANGE_DECORATED_POT, new CreoItemSettings());
    public static final Item YELLOW_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.YELLOW_DECORATED_POT, new CreoItemSettings());
    public static final Item LIME_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIME_DECORATED_POT, new CreoItemSettings());
    public static final Item GREEN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GREEN_DECORATED_POT, new CreoItemSettings());
    public static final Item CYAN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.CYAN_DECORATED_POT, new CreoItemSettings());
    public static final Item LIGHT_BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT, new CreoItemSettings());
    public static final Item BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLUE_DECORATED_POT, new CreoItemSettings());
    public static final Item PINK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PINK_DECORATED_POT, new CreoItemSettings());
    public static final Item MAGENTA_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT, new CreoItemSettings());
    public static final Item PURPLE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PURPLE_DECORATED_POT, new CreoItemSettings());
    public static final Item BLACK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLACK_DECORATED_POT, new CreoItemSettings());
    public static final Item GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GRAY_DECORATED_POT, new CreoItemSettings());
    public static final Item LIGHT_GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT, new CreoItemSettings());
    public static final Item WHITE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.WHITE_DECORATED_POT, new CreoItemSettings());

    public static final Item COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICKS, new CreoItemSettings());
    public static final Item COBBLESTONE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS, new CreoItemSettings());
    public static final Item COBBLESTONE_BRICK_SLAB = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_SLAB, new CreoItemSettings());
    public static final Item COBBLESTONE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_WALL, new CreoItemSettings());
    public static final Item CHISELED_COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS, new CreoItemSettings());
    public static final Item COBBLESTONE_BRICK_PILLAR = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_PILLAR, new CreoItemSettings());
    public static final Item MOSSY_COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICKS, new CreoItemSettings());
    public static final Item MOSSY_COBBLESTONE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS, new CreoItemSettings());
    public static final Item MOSSY_COBBLESTONE_BRICK_SLAB = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, new CreoItemSettings());
    public static final Item MOSSY_COBBLESTONE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_WALL, new CreoItemSettings());

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "brown_decorated_pot"), BROWN_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "red_decorated_pot"), RED_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "orange_decorated_pot"), ORANGE_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "yellow_decorated_pot"), YELLOW_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "lime_decorated_pot"), LIME_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "green_decorated_pot"), GREEN_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cyan_decorated_pot"), CYAN_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "blue_decorated_pot"), BLUE_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "light_blue_decorated_pot"), LIGHT_BLUE_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "pink_decorated_pot"), PINK_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "magenta_decorated_pot"), MAGENTA_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "purple_decorated_pot"), PURPLE_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "black_decorated_pot"), BLACK_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "gray_decorated_pot"), GRAY_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "light_gray_decorated_pot"), LIGHT_GRAY_DECORATED_POT);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "white_decorated_pot"), WHITE_DECORATED_POT);

        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_bricks"), COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_stairs"), COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_slab"), COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_wall"), COBBLESTONE_BRICK_WALL);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "chiseled_cobblestone_bricks"), CHISELED_COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cobblestone_brick_pillar"), COBBLESTONE_BRICK_PILLAR);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_bricks"), MOSSY_COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_stairs"), MOSSY_COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_slab"), MOSSY_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mossy_cobblestone_brick_wall"), MOSSY_COBBLESTONE_BRICK_WALL);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.COBBLESTONE_WALL, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL, CHISELED_COBBLESTONE_BRICKS, COBBLESTONE_BRICK_PILLAR, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, BLUE_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, PINK_DECORATED_POT, MAGENTA_DECORATED_POT, PURPLE_DECORATED_POT, BLACK_DECORATED_POT, GRAY_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, WHITE_DECORATED_POT);
        });
    }
}
