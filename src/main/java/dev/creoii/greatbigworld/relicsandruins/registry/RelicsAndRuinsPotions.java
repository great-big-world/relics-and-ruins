package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsPotions {
    public static RegistryEntry<Potion> STRONG_NIGHT_VISION;

    public static void register() {
        STRONG_NIGHT_VISION = Registry.registerReference(Registries.POTION, new Identifier(GreatBigWorld.NAMESPACE, "strong_night_vision"), new Potion("night_vision", new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1800, 1)));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.NIGHT_VISION, Items.GLOWSTONE_DUST, STRONG_NIGHT_VISION);
            builder.registerPotionRecipe(STRONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, Potions.INVISIBILITY);
        });
    }
}
