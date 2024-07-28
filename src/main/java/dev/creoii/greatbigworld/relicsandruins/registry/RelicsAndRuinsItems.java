package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.creoapi.api.item.CreoFoodComponent;
import dev.creoii.creoapi.api.item.CreoItemSettings;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.item.EarthshakerPickaxeItem;
import dev.creoii.greatbigworld.relicsandruins.item.EchoingBladeItem;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsRarities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Optional;

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

    public static final Item ECHOING_BLADE = new EchoingBladeItem(ToolMaterials.STONE, new CreoItemSettings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 5, -2.2f)).component(RelicsAndRuinsDataComponents.RELIC, new RelicComponent(0, 6, Optional.empty())));
    public static final Item ROGUEISH_HOOD = new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new CreoItemSettings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn());
    public static final Item CRYSTAL_APPLE = new Item(new CreoItemSettings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().food(new CreoFoodComponent(3, 0f, true, false, 20, true, List.of())));
    public static final Item EARTHSHAKER_PICKAXE = new EarthshakerPickaxeItem(new CreoItemSettings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1f, -2.8f)).component(RelicsAndRuinsDataComponents.RELIC, new RelicComponent(0, 27, Optional.empty())));
    public static final Item MENDSTONE = new Item(new CreoItemSettings().rarity(RelicsAndRuinsRarities.RELIC).rotationModifier(0f).clickPickup().cannotDespawn());

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

        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "echoing_blade"), ECHOING_BLADE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "rogueish_hood"), ROGUEISH_HOOD);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "crystal_apple"), CRYSTAL_APPLE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "earthshaker_pickaxe"), EARTHSHAKER_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mendstone"), MENDSTONE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, BLUE_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, PINK_DECORATED_POT, MAGENTA_DECORATED_POT, PURPLE_DECORATED_POT, BLACK_DECORATED_POT, GRAY_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, WHITE_DECORATED_POT);
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
    }
}
