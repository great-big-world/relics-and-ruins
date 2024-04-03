package dev.creoii.greatbigworld.relicsandruins.mixin.client.screen;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.SmithingScreenHandler;
import net.minecraft.screen.slot.ForgingSlotsManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(SmithingScreenHandler.class)
public class SmithingScreenHandlerMixin {
    @Shadow @Final private List<RecipeEntry<SmithingRecipe>> recipes;

    @ModifyReturnValue(method = "getForgingSlotsManager", at = @At("RETURN"))
    private ForgingSlotsManager gbw$fixSmithingSlotsHeight(ForgingSlotsManager original) {
        return ForgingSlotsManager.create().input(0, 8, 14, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testTemplate(stack);
            });
        }).input(1, 26, 14, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testBase(stack);
            });
        }).input(2, 44, 14, (stack) -> {
            return this.recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testAddition(stack);
            });
        }).output(3, 26, 55).build();
    }
}
