package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.architectsassembly.item.SlabItem;
import dev.creoii.greatbigworld.architectsassembly.registry.ArchitectsAssemblyItems;
import dev.creoii.greatbigworld.relicsandruins.util.TreasureType;
import dev.creoii.greatbigworld.relicsandruins.item.EarthshakerPickaxeItem;
import dev.creoii.greatbigworld.relicsandruins.item.EchoingBladeItem;
import dev.creoii.greatbigworld.relicsandruins.item.TreasureItem;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsRarities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;
import java.util.Optional;

public final class RelicsAndRuinsItems {
    public static final Item BROWN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BROWN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item RED_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.RED_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item ORANGE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.ORANGE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item YELLOW_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.YELLOW_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIME_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIME_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item GREEN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GREEN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item CYAN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.CYAN_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIGHT_BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLUE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item PINK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PINK_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item MAGENTA_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item PURPLE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PURPLE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item BLACK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLACK_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GRAY_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIGHT_GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item WHITE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.WHITE_DECORATED_POT, new Item.Settings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));

    public static final Item OAK_CHEST = new BlockItem(RelicsAndRuinsBlocks.OAK_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item SPRUCE_CHEST = new BlockItem(RelicsAndRuinsBlocks.SPRUCE_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item BIRCH_CHEST = new BlockItem(RelicsAndRuinsBlocks.BIRCH_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item JUNGLE_CHEST = new BlockItem(RelicsAndRuinsBlocks.JUNGLE_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item DARK_OAK_CHEST = new BlockItem(RelicsAndRuinsBlocks.DARK_OAK_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item ACACIA_CHEST = new BlockItem(RelicsAndRuinsBlocks.ACACIA_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item MANGROVE_CHEST = new BlockItem(RelicsAndRuinsBlocks.MANGROVE_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item CHERRY_CHEST = new BlockItem(RelicsAndRuinsBlocks.CHERRY_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item BAMBOO_CHEST = new BlockItem(RelicsAndRuinsBlocks.BAMBOO_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item CRIMSON_CHEST = new BlockItem(RelicsAndRuinsBlocks.CRIMSON_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item WARPED_CHEST = new BlockItem(RelicsAndRuinsBlocks.WARPED_CHEST, new Item.Settings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));

    public static final Item BRAZIER = new BlockItem(RelicsAndRuinsBlocks.BRAZIER, new Item.Settings());
    public static final Item SOUL_BRAZIER = new BlockItem(RelicsAndRuinsBlocks.SOUL_BRAZIER, new Item.Settings());

    public static final Item COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICKS, new Item.Settings());
    public static final Item COBBLESTONE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_STAIRS, new Item.Settings());
    public static final Item COBBLESTONE_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_COBBLESTONE_BRICK_SLAB, new Item.Settings());
    public static final Item COBBLESTONE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_WALL, new Item.Settings());
    public static final Item CHISELED_COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.CHISELED_COBBLESTONE_BRICKS, new Item.Settings());
    public static final Item COBBLESTONE_BRICK_PILLAR = new BlockItem(RelicsAndRuinsBlocks.COBBLESTONE_BRICK_PILLAR, new Item.Settings());
    public static final Item MOSSY_COBBLESTONE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICKS, new Item.Settings());
    public static final Item MOSSY_COBBLESTONE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS, new Item.Settings());
    public static final Item MOSSY_COBBLESTONE_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_MOSSY_COBBLESTONE_BRICK_SLAB, new Item.Settings());
    public static final Item MOSSY_COBBLESTONE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.MOSSY_COBBLESTONE_BRICK_WALL, new Item.Settings());

    public static final Item ICE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.ICE_BRICKS, new Item.Settings());
    public static final Item ICE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.ICE_BRICK_STAIRS, new Item.Settings());
    public static final Item ICE_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_ICE_BRICK_SLAB, new Item.Settings());
    public static final Item ICE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.ICE_BRICK_WALL, new Item.Settings());
    public static final Item PACKED_ICE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICKS, new Item.Settings());
    public static final Item PACKED_ICE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICK_STAIRS, new Item.Settings());
    public static final Item PACKED_ICE_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_PACKED_ICE_BRICK_SLAB, new Item.Settings());
    public static final Item PACKED_ICE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.PACKED_ICE_BRICK_WALL, new Item.Settings());
    public static final Item BLUE_ICE_BRICKS = new BlockItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICKS, new Item.Settings());
    public static final Item BLUE_ICE_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICK_STAIRS, new Item.Settings());
    public static final Item BLUE_ICE_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_BLUE_ICE_BRICK_SLAB, new Item.Settings());
    public static final Item BLUE_ICE_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.BLUE_ICE_BRICK_WALL, new Item.Settings());

    public static final Item SNOW_BRICKS = new BlockItem(RelicsAndRuinsBlocks.SNOW_BRICKS, new Item.Settings());
    public static final Item SNOW_BRICK_STAIRS = new BlockItem(RelicsAndRuinsBlocks.SNOW_BRICK_STAIRS, new Item.Settings());
    public static final Item SNOW_BRICK_SLAB = new SlabItem(RelicsAndRuinsBlocks.SNOW_BRICK_SLAB, RelicsAndRuinsBlocks.VERTICAL_SNOW_BRICK_SLAB, new Item.Settings());
    public static final Item SNOW_BRICK_WALL = new BlockItem(RelicsAndRuinsBlocks.SNOW_BRICK_WALL, new Item.Settings());

    public static final Item ECHOING_BLADE = new EchoingBladeItem(ToolMaterials.STONE, new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 5, -2.2f)).component(RelicsAndRuinsComponentTypes.RELIC, new RelicComponent(0, 6, Optional.empty())));
    public static final Item ROGUEISH_HOOD = new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC));
    public static final Item CRYSTAL_APPLE = new Item(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).food(new FoodComponent(3, 0f, false, 20, Optional.empty(), List.of())));
    public static final Item EARTHSHAKER_PICKAXE = new EarthshakerPickaxeItem(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1f, -2.8f)).component(RelicsAndRuinsComponentTypes.RELIC, new RelicComponent(0, 27, Optional.empty())));
    public static final Item MENDSTONE = new Item(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC));

    /*  OLD RELIC DEFINITIONS FOR REFERENCE
    public static final Item ECHOING_BLADE = new EchoingBladeItem(ToolMaterials.STONE, new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 5, -2.2f)).component(RelicsAndRuinsDataComponents.RELIC, new RelicComponent(0, 6, Optional.empty())));
    public static final Item ROGUEISH_HOOD = new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn());
    public static final Item CRYSTAL_APPLE = new Item(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().food(new CreoFoodComponent(3, 0f, true, false, 20, true, List.of())));
    public static final Item EARTHSHAKER_PICKAXE = new EarthshakerPickaxeItem(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1f, -2.8f)).component(RelicsAndRuinsDataComponents.RELIC, new RelicComponent(0, 27, Optional.empty())));
    public static final Item MENDSTONE = new Item(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn());
    */
    public static final Item DESERT_TREASURE = new TreasureItem(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC), TreasureType.DESERT);
    public static final Item JUNGLE_TREASURE = new TreasureItem(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC), TreasureType.JUNGLE);
    public static final Item SWAMP_TREASURE = new TreasureItem(new Item.Settings().rarity(RelicsAndRuinsRarities.RELIC), TreasureType.SWAMP);

    public static final Item DISC_FRAGMENT_RELIC = new DiscFragmentItem(new Item.Settings());

    public static void register() {
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "brown_decorated_pot"), BROWN_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "red_decorated_pot"), RED_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "orange_decorated_pot"), ORANGE_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "yellow_decorated_pot"), YELLOW_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "lime_decorated_pot"), LIME_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "green_decorated_pot"), GREEN_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cyan_decorated_pot"), CYAN_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "blue_decorated_pot"), BLUE_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "light_blue_decorated_pot"), LIGHT_BLUE_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "pink_decorated_pot"), PINK_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "magenta_decorated_pot"), MAGENTA_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "purple_decorated_pot"), PURPLE_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "black_decorated_pot"), BLACK_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "gray_decorated_pot"), GRAY_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "light_gray_decorated_pot"), LIGHT_GRAY_DECORATED_POT);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "white_decorated_pot"), WHITE_DECORATED_POT);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "oak_chest"), OAK_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "spruce_chest"), SPRUCE_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "birch_chest"), BIRCH_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "jungle_chest"), JUNGLE_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "dark_oak_chest"), DARK_OAK_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "acacia_chest"), ACACIA_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mangrove_chest"), MANGROVE_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cherry_chest"), CHERRY_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "bamboo_chest"), BAMBOO_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "crimson_chest"), CRIMSON_CHEST);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "warped_chest"), WARPED_CHEST);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "brazier"), BRAZIER);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "soul_brazier"), SOUL_BRAZIER);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_bricks"), COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_stairs"), COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_slab"), COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_wall"), COBBLESTONE_BRICK_WALL);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "chiseled_cobblestone_bricks"), CHISELED_COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "cobblestone_brick_pillar"), COBBLESTONE_BRICK_PILLAR);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_bricks"), MOSSY_COBBLESTONE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_stairs"), MOSSY_COBBLESTONE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_slab"), MOSSY_COBBLESTONE_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mossy_cobblestone_brick_wall"), MOSSY_COBBLESTONE_BRICK_WALL);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "ice_bricks"), ICE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_stairs"), ICE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_slab"), ICE_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "ice_brick_wall"), ICE_BRICK_WALL);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_bricks"), PACKED_ICE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_stairs"), PACKED_ICE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_slab"), PACKED_ICE_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "packed_ice_brick_wall"), PACKED_ICE_BRICK_WALL);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_bricks"), BLUE_ICE_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_stairs"), BLUE_ICE_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_slab"), BLUE_ICE_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "blue_ice_brick_wall"), BLUE_ICE_BRICK_WALL);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "snow_bricks"), SNOW_BRICKS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_stairs"), SNOW_BRICK_STAIRS);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_slab"), SNOW_BRICK_SLAB);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "snow_brick_wall"), SNOW_BRICK_WALL);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "echoing_blade"), ECHOING_BLADE);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "rogueish_hood"), ROGUEISH_HOOD);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "crystal_apple"), CRYSTAL_APPLE);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "earthshaker_pickaxe"), EARTHSHAKER_PICKAXE);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "mendstone"), MENDSTONE);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "desert_treasure"), DESERT_TREASURE);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "jungle_treasure"), JUNGLE_TREASURE);
        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "swamp_treasure"), SWAMP_TREASURE);

        Registry.register(Registries.ITEM, Identifier.of(GreatBigWorld.NAMESPACE, "disc_fragment_relic"), DISC_FRAGMENT_RELIC);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.COBBLESTONE_WALL, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL, COBBLESTONE_BRICK_PILLAR, CHISELED_COBBLESTONE_BRICKS);
            entries.addAfter(Items.MOSSY_COBBLESTONE_WALL, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
            entries.addAfter(ArchitectsAssemblyItems.CUT_RED_SANDSTONE_SLAB, ICE_BRICKS, ICE_BRICK_STAIRS, ICE_BRICK_SLAB, ICE_BRICK_WALL, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.CHEST, OAK_CHEST, SPRUCE_CHEST, BIRCH_CHEST, JUNGLE_CHEST, DARK_OAK_CHEST, BIRCH_CHEST, MANGROVE_CHEST, CHERRY_CHEST, BAMBOO_CHEST, CRIMSON_CHEST, WARPED_CHEST);
            entries.addAfter(Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
            entries.addAfter(Items.SOUL_CAMPFIRE, BRAZIER, SOUL_BRAZIER);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.PINK_BANNER, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.TOTEM_OF_UNDYING, ECHOING_BLADE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.NETHERITE_HOE, ROGUEISH_HOOD, EARTHSHAKER_PICKAXE, MENDSTONE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, CRYSTAL_APPLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.OMINOUS_TRIAL_KEY, DESERT_TREASURE, JUNGLE_TREASURE, SWAMP_TREASURE);
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

        FuelRegistry.INSTANCE.add(ConventionalItemTags.CHESTS, 300);

        final FallibleItemDispenserBehavior CHEST_DISPENSER_BEHAVIOR = new FallibleItemDispenserBehavior(){
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                BlockPos pos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                for (AbstractDonkeyEntity abstractDonkeyEntity2 : pointer.world().getEntitiesByClass(AbstractDonkeyEntity.class, new Box(pos), abstractDonkeyEntity -> abstractDonkeyEntity.isAlive() && !abstractDonkeyEntity.hasChest())) {
                    if (!abstractDonkeyEntity2.isTame() || !abstractDonkeyEntity2.getStackReference(499).set(stack))
                        continue;
                    stack.decrement(1);
                    setSuccess(true);
                    return stack;
                }
                return super.dispenseSilently(pointer, stack);
            }
        };

        DispenserBlock.registerBehavior(OAK_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(SPRUCE_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(BIRCH_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(JUNGLE_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(DARK_OAK_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(ACACIA_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(MANGROVE_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(CHERRY_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(BAMBOO_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(CRIMSON_CHEST, CHEST_DISPENSER_BEHAVIOR);
        DispenserBlock.registerBehavior(WARPED_CHEST, CHEST_DISPENSER_BEHAVIOR);
    }
}
