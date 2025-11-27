package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.item.SlabItem;
import dev.creoii.greatbigworld.architectsassembly.registry.ArchitectsAssemblyItems;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
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

    public static Item ENGRAVED_STONE;
    public static Item ENGRAVED_STONE_ANGLER;
    public static Item ENGRAVED_STONE_ARCHER;
    public static Item ENGRAVED_STONE_ARMS_UP;
    public static Item ENGRAVED_STONE_BLADE;
    public static Item ENGRAVED_STONE_BREWER;
    public static Item ENGRAVED_STONE_BURN;
    public static Item ENGRAVED_STONE_DANGER;
    public static Item ENGRAVED_STONE_EXPLORER;
    public static Item ENGRAVED_STONE_FLOW;
    public static Item ENGRAVED_STONE_FRIEND;
    public static Item ENGRAVED_STONE_GUSTER;
    public static Item ENGRAVED_STONE_HEART;
    public static Item ENGRAVED_STONE_HEARTBREAK;
    public static Item ENGRAVED_STONE_HOWL;
    public static Item ENGRAVED_STONE_MINER;
    public static Item ENGRAVED_STONE_MOURNER;
    public static Item ENGRAVED_STONE_PLENTY;
    public static Item ENGRAVED_STONE_PRIZE;
    public static Item ENGRAVED_STONE_SCRAPE;
    public static Item ENGRAVED_STONE_SHEAF;
    public static Item ENGRAVED_STONE_SHELTER;
    public static Item ENGRAVED_STONE_SKULL;
    public static Item ENGRAVED_STONE_SNORT;

    public static Item MENDING_RELIC;
    public static Item INFINITY_RELIC;
    public static Item TAMING_RELIC;
    public static Item REACHING_RELIC;
    public static Item VISION_RELIC;
    public static Item THORNS_RELIC;
    public static Item INSIGHT_RELIC;
    public static Item FORTUNE_RELIC;
    public static Item PURGING_RELIC;
    public static Item SILENCE_RELIC;
    public static Item RAMPAGE_RELIC;
    public static Item NOURISHING_RELIC;
    public static Item BEHEADING_RELIC;

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

        ENGRAVED_STONE = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone"), RelicsAndRuinsBlocks.ENGRAVED_STONE);
        ENGRAVED_STONE_ANGLER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_angler"), RelicsAndRuinsBlocks.ENGRAVED_STONE_ANGLER);
        ENGRAVED_STONE_ARCHER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_archer"), RelicsAndRuinsBlocks.ENGRAVED_STONE_ARCHER);
        ENGRAVED_STONE_ARMS_UP = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_arms_up"), RelicsAndRuinsBlocks.ENGRAVED_STONE_ARMS_UP);
        ENGRAVED_STONE_BLADE = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_blade"), RelicsAndRuinsBlocks.ENGRAVED_STONE_BLADE);
        ENGRAVED_STONE_BREWER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_brewer"), RelicsAndRuinsBlocks.ENGRAVED_STONE_BREWER);
        ENGRAVED_STONE_BURN = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_burn"), RelicsAndRuinsBlocks.ENGRAVED_STONE_BURN);
        ENGRAVED_STONE_DANGER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_danger"), RelicsAndRuinsBlocks.ENGRAVED_STONE_DANGER);
        ENGRAVED_STONE_EXPLORER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_explorer"), RelicsAndRuinsBlocks.ENGRAVED_STONE_EXPLORER);
        ENGRAVED_STONE_FLOW = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_flow"), RelicsAndRuinsBlocks.ENGRAVED_STONE_FLOW);
        ENGRAVED_STONE_FRIEND = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_friend"), RelicsAndRuinsBlocks.ENGRAVED_STONE_FRIEND);
        ENGRAVED_STONE_GUSTER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_guster"), RelicsAndRuinsBlocks.ENGRAVED_STONE_GUSTER);
        ENGRAVED_STONE_HEART = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_heart"), RelicsAndRuinsBlocks.ENGRAVED_STONE_HEART);
        ENGRAVED_STONE_HEARTBREAK = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_heartbreak"), RelicsAndRuinsBlocks.ENGRAVED_STONE_HEARTBREAK);
        ENGRAVED_STONE_HOWL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_howl"), RelicsAndRuinsBlocks.ENGRAVED_STONE_HOWL);
        ENGRAVED_STONE_MINER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_miner"), RelicsAndRuinsBlocks.ENGRAVED_STONE_MINER);
        ENGRAVED_STONE_MOURNER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_mourner"), RelicsAndRuinsBlocks.ENGRAVED_STONE_MOURNER);
        ENGRAVED_STONE_PLENTY = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_plenty"), RelicsAndRuinsBlocks.ENGRAVED_STONE_PLENTY);
        ENGRAVED_STONE_PRIZE = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_prize"), RelicsAndRuinsBlocks.ENGRAVED_STONE_PRIZE);
        ENGRAVED_STONE_SCRAPE = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_scrape"), RelicsAndRuinsBlocks.ENGRAVED_STONE_SCRAPE);
        ENGRAVED_STONE_SHEAF = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_sheaf"), RelicsAndRuinsBlocks.ENGRAVED_STONE_SHEAF);
        ENGRAVED_STONE_SHELTER = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_shelter"), RelicsAndRuinsBlocks.ENGRAVED_STONE_SHELTER);
        ENGRAVED_STONE_SKULL = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_skull"), RelicsAndRuinsBlocks.ENGRAVED_STONE_SKULL);
        ENGRAVED_STONE_SNORT = RegistryHelper.registerBlockItem(Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone_snort"), RelicsAndRuinsBlocks.ENGRAVED_STONE_SNORT);

        MENDING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "mending_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        INFINITY_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "infinity_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        TAMING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "taming_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        REACHING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "reaching_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        VISION_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "vision_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        THORNS_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "thorns_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        INSIGHT_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "insight_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        FORTUNE_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "fortune_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        PURGING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "purging_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        SILENCE_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "silence_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        RAMPAGE_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "rampage_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        NOURISHING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "nourishing_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        BEHEADING_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "beheading_relic"), settings -> new RelicItem(settings.maxDamage(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));

        DISC_FRAGMENT_RELIC = RegistryHelper.registerItem(Identifier.of(GreatBigWorld.NAMESPACE, "disc_fragment_relic"), DiscFragmentItem::new);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.COBBLESTONE_WALL, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL, COBBLESTONE_BRICK_PILLAR, CHISELED_COBBLESTONE_BRICKS);
            entries.addAfter(Items.MOSSY_COBBLESTONE_WALL, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
            entries.addAfter(ArchitectsAssemblyItems.CUT_RED_SANDSTONE_SLAB, ICE_BRICKS, ICE_BRICK_STAIRS, ICE_BRICK_SLAB, ICE_BRICK_WALL, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
            for (EngravedStoneBlock.Engraving engraving : EngravedStoneBlock.Engraving.values()) {
                ItemStack stack = new ItemStack(ENGRAVED_STONE);
                stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, engraving);
                entries.addAfter(Items.WAXED_OXIDIZED_COPPER_GOLEM_STATUE, stack);
            }
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
            entries.addAfter(Items.SADDLE, MENDING_RELIC, INFINITY_RELIC, TAMING_RELIC, REACHING_RELIC, VISION_RELIC, THORNS_RELIC, INSIGHT_RELIC, FORTUNE_RELIC, PURGING_RELIC, SILENCE_RELIC, RAMPAGE_RELIC, NOURISHING_RELIC, BEHEADING_RELIC);
        });

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ConventionalItemTags.CHESTS, 300);
        });
    }
}
