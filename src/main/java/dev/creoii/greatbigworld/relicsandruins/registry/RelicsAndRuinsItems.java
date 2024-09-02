package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.creoapi.api.item.CreoFoodComponent;
import dev.creoii.creoapi.api.item.CreoItemSettings;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.item.EarthshakerPickaxeItem;
import dev.creoii.greatbigworld.relicsandruins.item.EchoingBladeItem;
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
    public static final Item BROWN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BROWN_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item RED_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.RED_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item ORANGE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.ORANGE_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item YELLOW_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.YELLOW_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIME_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIME_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item GREEN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GREEN_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item CYAN_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.CYAN_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIGHT_BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item BLUE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLUE_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item PINK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PINK_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item MAGENTA_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item PURPLE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.PURPLE_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item BLACK_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.BLACK_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.GRAY_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item LIGHT_GRAY_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));
    public static final Item WHITE_DECORATED_POT = new BlockItem(RelicsAndRuinsBlocks.WHITE_DECORATED_POT, new CreoItemSettings().component(DataComponentTypes.POT_DECORATIONS, Sherds.DEFAULT));

    public static final Item OAK_CHEST = new BlockItem(RelicsAndRuinsBlocks.OAK_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item SPRUCE_CHEST = new BlockItem(RelicsAndRuinsBlocks.SPRUCE_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item BIRCH_CHEST = new BlockItem(RelicsAndRuinsBlocks.BIRCH_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item JUNGLE_CHEST = new BlockItem(RelicsAndRuinsBlocks.JUNGLE_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item DARK_OAK_CHEST = new BlockItem(RelicsAndRuinsBlocks.DARK_OAK_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item ACACIA_CHEST = new BlockItem(RelicsAndRuinsBlocks.ACACIA_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item MANGROVE_CHEST = new BlockItem(RelicsAndRuinsBlocks.MANGROVE_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item CHERRY_CHEST = new BlockItem(RelicsAndRuinsBlocks.CHERRY_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item BAMBOO_CHEST = new BlockItem(RelicsAndRuinsBlocks.BAMBOO_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item CRIMSON_CHEST = new BlockItem(RelicsAndRuinsBlocks.CRIMSON_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));
    public static final Item WARPED_CHEST = new BlockItem(RelicsAndRuinsBlocks.WARPED_CHEST, new CreoItemSettings().component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));

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

        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "oak_chest"), OAK_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "spruce_chest"), SPRUCE_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "birch_chest"), BIRCH_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "jungle_chest"), JUNGLE_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "dark_oak_chest"), DARK_OAK_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "acacia_chest"), ACACIA_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mangrove_chest"), MANGROVE_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "cherry_chest"), CHERRY_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "bamboo_chest"), BAMBOO_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "crimson_chest"), CRIMSON_CHEST);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "warped_chest"), WARPED_CHEST);

        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "echoing_blade"), ECHOING_BLADE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "rogueish_hood"), ROGUEISH_HOOD);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "crystal_apple"), CRYSTAL_APPLE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "earthshaker_pickaxe"), EARTHSHAKER_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(RelicsAndRuins.NAMESPACE, "mendstone"), MENDSTONE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, BLUE_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, PINK_DECORATED_POT, MAGENTA_DECORATED_POT, PURPLE_DECORATED_POT, BLACK_DECORATED_POT, GRAY_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, WHITE_DECORATED_POT);
            entries.addAfter(Items.CHEST, OAK_CHEST, SPRUCE_CHEST, BIRCH_CHEST, JUNGLE_CHEST, DARK_OAK_CHEST, BIRCH_CHEST, MANGROVE_CHEST, CHERRY_CHEST, BAMBOO_CHEST, CRIMSON_CHEST, WARPED_CHEST);
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
