package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.item.SlabItem;
import dev.creoii.greatbigworld.architectsassembly.registry.ArchitectsAssemblyItems;
import dev.creoii.greatbigworld.thealterworld.item.RelicItem;
import dev.creoii.greatbigworld.thealterworld.registry.TheAlterworldDataComponentTypes;
import dev.creoii.greatbigworld.util.RegistryHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

public final class RelicsAndRuinsItems {
    public static Item BROWN_DECORATED_POT;
    public static Item RED_DECORATED_POT;
    public static Item ORANGE_DECORATED_POT;
    public static Item YELLOW_DECORATED_POT;
    public static Item LIME_DECORATED_POT;
    public static Item GREEN_DECORATED_POT;
    public static Item CYAN_DECORATED_POT;
    public static Item LIGHT_BLUE_DECORATED_POT;
    public static Item BLUE_DECORATED_POT;
    public static Item PINK_DECORATED_POT;
    public static Item MAGENTA_DECORATED_POT;
    public static Item PURPLE_DECORATED_POT;
    public static Item BLACK_DECORATED_POT;
    public static Item GRAY_DECORATED_POT;
    public static Item LIGHT_GRAY_DECORATED_POT;
    public static Item WHITE_DECORATED_POT;

    public static Item COBBLESTONE_BRICKS;
    public static Item COBBLESTONE_BRICK_STAIRS;
    public static Item COBBLESTONE_BRICK_SLAB;
    public static Item COBBLESTONE_BRICK_WALL;
    public static Item CHISELED_COBBLESTONE_BRICKS;
    public static Item COBBLESTONE_BRICK_PILLAR;
    public static Item MOSSY_COBBLESTONE_BRICKS;
    public static Item MOSSY_COBBLESTONE_BRICK_STAIRS;
    public static Item MOSSY_COBBLESTONE_BRICK_SLAB;
    public static Item MOSSY_COBBLESTONE_BRICK_WALL;

    public static Item ICE_BRICKS;
    public static Item ICE_BRICK_STAIRS;
    public static Item ICE_BRICK_SLAB;
    public static Item ICE_BRICK_WALL;
    public static Item PACKED_ICE_BRICKS;
    public static Item PACKED_ICE_BRICK_STAIRS;
    public static Item PACKED_ICE_BRICK_SLAB;
    public static Item PACKED_ICE_BRICK_WALL;
    public static Item BLUE_ICE_BRICKS;
    public static Item BLUE_ICE_BRICK_STAIRS;
    public static Item BLUE_ICE_BRICK_SLAB;
    public static Item BLUE_ICE_BRICK_WALL;

    public static Item SNOW_BRICKS;
    public static Item SNOW_BRICK_STAIRS;
    public static Item SNOW_BRICK_SLAB;
    public static Item SNOW_BRICK_WALL;

    public static Item TEST_RELIC;

    public static Item DISC_FRAGMENT_RELIC;

    public static void register() {
        BROWN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), RelicsAndRuinsBlocks.BROWN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        RED_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "red_decorated_pot"), RelicsAndRuinsBlocks.RED_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        ORANGE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), RelicsAndRuinsBlocks.ORANGE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        YELLOW_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), RelicsAndRuinsBlocks.YELLOW_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        LIME_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), RelicsAndRuinsBlocks.LIME_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        GREEN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "green_decorated_pot"), RelicsAndRuinsBlocks.GREEN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        CYAN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), RelicsAndRuinsBlocks.CYAN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        BLUE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), RelicsAndRuinsBlocks.BLUE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        LIGHT_BLUE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        PINK_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), RelicsAndRuinsBlocks.PINK_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        MAGENTA_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        PURPLE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), RelicsAndRuinsBlocks.PURPLE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        BLACK_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "black_decorated_pot"), RelicsAndRuinsBlocks.BLACK_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        GRAY_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), RelicsAndRuinsBlocks.GRAY_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        LIGHT_GRAY_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
        WHITE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "white_decorated_pot"), RelicsAndRuinsBlocks.WHITE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));

        COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), RelicsAndRuinsBlocks.COBBLESTONE_BRICKS);
        COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS);
        COBBLESTONE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_COBBLESTONE_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_WALL);
        CHISELED_COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS);
        COBBLESTONE_BRICK_PILLAR = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_PILLAR);
        MOSSY_COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICKS);
        MOSSY_COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS);
        MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        MOSSY_COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_WALL);

        ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "ice_bricks"), RelicsAndRuinsBlocks.ICE_BRICKS);
        ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), RelicsAndRuinsBlocks.ICE_BRICK_STAIRS);
        ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_wall"), RelicsAndRuinsBlocks.ICE_BRICK_WALL);
        PACKED_ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), RelicsAndRuinsBlocks.PACKED_ICE_BRICKS);
        PACKED_ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), RelicsAndRuinsBlocks.PACKED_ICE_BRICK_STAIRS);
        PACKED_ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_PACKED_ICE_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        PACKED_ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), RelicsAndRuinsBlocks.PACKED_ICE_BRICK_WALL);
        BLUE_ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), RelicsAndRuinsBlocks.BLUE_ICE_BRICKS);
        BLUE_ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), RelicsAndRuinsBlocks.BLUE_ICE_BRICK_STAIRS);
        BLUE_ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_BLUE_ICE_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        BLUE_ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), RelicsAndRuinsBlocks.BLUE_ICE_BRICK_WALL);

        SNOW_BRICKS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "snow_bricks"), RelicsAndRuinsBlocks.SNOW_BRICKS);
        SNOW_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), RelicsAndRuinsBlocks.SNOW_BRICK_STAIRS);
        SNOW_BRICK_SLAB = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.SNOW_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_SNOW_BRICK_SLAB, settings.useBlockPrefixedTranslationKey()));
        SNOW_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_wall"), RelicsAndRuinsBlocks.SNOW_BRICK_WALL);

        TEST_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "test_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE)));

        DISC_FRAGMENT_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "disc_fragment_relic"), DiscFragmentItem::new);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.COBBLESTONE_WALL, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL, COBBLESTONE_BRICK_PILLAR, CHISELED_COBBLESTONE_BRICKS);
            entries.addAfter(Items.MOSSY_COBBLESTONE_WALL, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
            entries.addAfter(ArchitectsAssemblyItems.CUT_RED_SANDSTONE_SLAB, ICE_BRICKS, ICE_BRICK_STAIRS, ICE_BRICK_SLAB, ICE_BRICK_WALL, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.PINK_BANNER, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.getDisplayStacks().replaceAll(stack -> {
                if (stack.isOf(Items.DISC_FRAGMENT_5))
                    return DISC_FRAGMENT_RELIC.getDefaultStack();
                return stack;
            });
            entries.getSearchTabStacks().replaceAll(stack -> {
                if (stack.isOf(Items.DISC_FRAGMENT_5))
                    return DISC_FRAGMENT_RELIC.getDefaultStack();
                return stack;
            });
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(TEST_RELIC);
        });

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ConventionalItemTags.CHESTS, 300);
        });
    }
}
