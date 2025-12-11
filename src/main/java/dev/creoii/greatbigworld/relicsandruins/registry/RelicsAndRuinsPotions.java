package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public final class RelicsAndRuinsPotions {
    public static Holder<Potion> STRONG_NIGHT_VISION;

    public static void register() {
        STRONG_NIGHT_VISION = Registry.registerForHolder(BuiltInRegistries.POTION, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "strong_night_vision"), new Potion("night_vision", new MobEffectInstance(MobEffects.NIGHT_VISION, 1800, 1)));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.NIGHT_VISION, Ingredient.of(Items.GLOWSTONE_DUST), STRONG_NIGHT_VISION);
            builder.registerPotionRecipe(STRONG_NIGHT_VISION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), Potions.INVISIBILITY);
        });
    }
}
