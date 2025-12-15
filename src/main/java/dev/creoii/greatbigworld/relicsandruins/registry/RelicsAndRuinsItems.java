package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.item.SlabItem;
import dev.creoii.greatbigworld.architectsassembly.registry.ArchitectsAssemblyItems;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.relicsandruins.item.KnowledgeBookItem;
import dev.creoii.greatbigworld.thealterworld.item.RelicItem;
import dev.creoii.greatbigworld.thealterworld.registry.TheAlterworldDataComponentTypes;
import dev.creoii.greatbigworld.util.RegistryHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.PotDecorations;

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

    public static Item KNOWLEDGE_BOOK;

    public static void register() {
        BROWN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), RelicsAndRuinsBlocks.BROWN_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        RED_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "red_decorated_pot"), RelicsAndRuinsBlocks.RED_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        ORANGE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), RelicsAndRuinsBlocks.ORANGE_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        YELLOW_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), RelicsAndRuinsBlocks.YELLOW_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        LIME_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), RelicsAndRuinsBlocks.LIME_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        GREEN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "green_decorated_pot"), RelicsAndRuinsBlocks.GREEN_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        CYAN_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), RelicsAndRuinsBlocks.CYAN_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        BLUE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), RelicsAndRuinsBlocks.BLUE_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        LIGHT_BLUE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        PINK_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), RelicsAndRuinsBlocks.PINK_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        MAGENTA_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        PURPLE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), RelicsAndRuinsBlocks.PURPLE_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        BLACK_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "black_decorated_pot"), RelicsAndRuinsBlocks.BLACK_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        GRAY_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), RelicsAndRuinsBlocks.GRAY_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        LIGHT_GRAY_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));
        WHITE_DECORATED_POT = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "white_decorated_pot"), RelicsAndRuinsBlocks.WHITE_DECORATED_POT, new Item.Properties().component(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY));

        COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), RelicsAndRuinsBlocks.COBBLESTONE_BRICKS);
        COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS);
        COBBLESTONE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_COBBLESTONE_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_WALL);
        CHISELED_COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS);
        COBBLESTONE_BRICK_PILLAR = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), RelicsAndRuinsBlocks.COBBLESTONE_BRICK_PILLAR);
        MOSSY_COBBLESTONE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICKS);
        MOSSY_COBBLESTONE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS);
        MOSSY_COBBLESTONE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        MOSSY_COBBLESTONE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_WALL);

        ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_bricks"), RelicsAndRuinsBlocks.ICE_BRICKS);
        ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), RelicsAndRuinsBlocks.ICE_BRICK_STAIRS);
        ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "ice_brick_wall"), RelicsAndRuinsBlocks.ICE_BRICK_WALL);
        PACKED_ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), RelicsAndRuinsBlocks.PACKED_ICE_BRICKS);
        PACKED_ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), RelicsAndRuinsBlocks.PACKED_ICE_BRICK_STAIRS);
        PACKED_ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_PACKED_ICE_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        PACKED_ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), RelicsAndRuinsBlocks.PACKED_ICE_BRICK_WALL);
        BLUE_ICE_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), RelicsAndRuinsBlocks.BLUE_ICE_BRICKS);
        BLUE_ICE_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), RelicsAndRuinsBlocks.BLUE_ICE_BRICK_STAIRS);
        BLUE_ICE_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_BLUE_ICE_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        BLUE_ICE_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), RelicsAndRuinsBlocks.BLUE_ICE_BRICK_WALL);

        SNOW_BRICKS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_bricks"), RelicsAndRuinsBlocks.SNOW_BRICKS);
        SNOW_BRICK_STAIRS = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), RelicsAndRuinsBlocks.SNOW_BRICK_STAIRS);
        SNOW_BRICK_SLAB = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_slab"), settings -> new SlabItem(RelicsAndRuinsBlocks.SNOW_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_SNOW_BRICK_SLAB, settings.useBlockDescriptionPrefix()));
        SNOW_BRICK_WALL = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "snow_brick_wall"), RelicsAndRuinsBlocks.SNOW_BRICK_WALL);

        ENGRAVED_STONE = RegistryHelper.registerBlockItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraved_stone"), RelicsAndRuinsBlocks.ENGRAVED_STONE, new Item.Properties().rarity(Rarity.UNCOMMON));

        MENDING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "mending_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        INFINITY_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "infinity_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        TAMING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "taming_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        REACHING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "reaching_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        VISION_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "vision_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        THORNS_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "thorns_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        INSIGHT_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "insight_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        FORTUNE_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "fortune_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        PURGING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "purging_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        SILENCE_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "silence_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        RAMPAGE_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "rampage_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        NOURISHING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "nourishing_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));
        BEHEADING_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "beheading_relic"), settings -> new RelicItem(settings.durability(100).component(TheAlterworldDataComponentTypes.RELIC, Unit.INSTANCE), 1));

        DISC_FRAGMENT_RELIC = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "disc_fragment_relic"), DiscFragmentItem::new);

        KNOWLEDGE_BOOK = RegistryHelper.registerItem(Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "knowledge_book"), settings -> new KnowledgeBookItem(settings.rarity(Rarity.UNCOMMON)));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.COBBLESTONE_WALL, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL, COBBLESTONE_BRICK_PILLAR, CHISELED_COBBLESTONE_BRICKS);
            entries.addAfter(Items.MOSSY_COBBLESTONE_WALL, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
            entries.addAfter(ArchitectsAssemblyItems.CUT_RED_SANDSTONE_SLAB, ICE_BRICKS, ICE_BRICK_STAIRS, ICE_BRICK_SLAB, ICE_BRICK_WALL, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
            for (EngravedStoneBlock.Engraving engraving : EngravedStoneBlock.Engraving.values()) {
                ItemStack stack = new ItemStack(ENGRAVED_STONE);
                stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, new EngravedStoneBlock.Data(engraving, DyeColor.WHITE));
                entries.addAfter(Items.WAXED_OXIDIZED_COPPER_GOLEM_STATUE, stack);
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.PINK_BANNER, Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.getDisplayStacks().replaceAll(stack -> {
                if (stack.is(Items.DISC_FRAGMENT_5))
                    return DISC_FRAGMENT_RELIC.getDefaultInstance();
                return stack;
            });
            entries.getSearchTabStacks().replaceAll(stack -> {
                if (stack.is(Items.DISC_FRAGMENT_5))
                    return DISC_FRAGMENT_RELIC.getDefaultInstance();
                return stack;
            });
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.addAfter(Items.SADDLE, MENDING_RELIC, INFINITY_RELIC, TAMING_RELIC, REACHING_RELIC, VISION_RELIC, THORNS_RELIC, INSIGHT_RELIC, FORTUNE_RELIC, PURGING_RELIC, SILENCE_RELIC, RAMPAGE_RELIC, NOURISHING_RELIC, BEHEADING_RELIC);
        });

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ConventionalItemTags.CHESTS, 300);
        });
    }
}
