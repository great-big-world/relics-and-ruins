package dev.creoii.greatbigworld.relicsandruins.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.recipe.CraftingDecoratedPotRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftingDecoratedPotRecipe.class)
public class CraftingDecoratedPotRecipeMixin {
    @Inject(method = "craft(Lnet/minecraft/recipe/input/CraftingRecipeInput;Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;)Lnet/minecraft/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    private void gbw$makeDecoratedPotsDyeable(CraftingRecipeInput craftingRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup, CallbackInfoReturnable<ItemStack> cir, @Local Sherds sherds) {
        if (craftingRecipeInput.getStackInSlot(4).getItem() instanceof DyeItem dyeItem) {
            cir.setReturnValue(switch (dyeItem.getColor()) {
                case BROWN -> getStackWith(RelicsAndRuinsItems.BROWN_DECORATED_POT, sherds);
                case RED -> getStackWith(RelicsAndRuinsItems.RED_DECORATED_POT, sherds);
                case ORANGE -> getStackWith(RelicsAndRuinsItems.ORANGE_DECORATED_POT, sherds);
                case YELLOW -> getStackWith(RelicsAndRuinsItems.YELLOW_DECORATED_POT, sherds);
                case LIME -> getStackWith(RelicsAndRuinsItems.LIME_DECORATED_POT, sherds);
                case GREEN -> getStackWith(RelicsAndRuinsItems.GREEN_DECORATED_POT, sherds);
                case CYAN -> getStackWith(RelicsAndRuinsItems.CYAN_DECORATED_POT, sherds);
                case BLUE -> getStackWith(RelicsAndRuinsItems.BLUE_DECORATED_POT, sherds);
                case LIGHT_BLUE -> getStackWith(RelicsAndRuinsItems.LIGHT_BLUE_DECORATED_POT, sherds);
                case PINK -> getStackWith(RelicsAndRuinsItems.PINK_DECORATED_POT, sherds);
                case MAGENTA -> getStackWith(RelicsAndRuinsItems.MAGENTA_DECORATED_POT, sherds);
                case PURPLE -> getStackWith(RelicsAndRuinsItems.PURPLE_DECORATED_POT, sherds);
                case BLACK -> getStackWith(RelicsAndRuinsItems.BLACK_DECORATED_POT, sherds);
                case GRAY -> getStackWith(RelicsAndRuinsItems.GRAY_DECORATED_POT, sherds);
                case LIGHT_GRAY -> getStackWith(RelicsAndRuinsItems.LIGHT_GRAY_DECORATED_POT, sherds);
                case WHITE -> getStackWith(RelicsAndRuinsItems.WHITE_DECORATED_POT, sherds);
            });
        }
    }

    @ModifyExpressionValue(method = "matches(Lnet/minecraft/recipe/input/CraftingRecipeInput;Lnet/minecraft/world/World;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean gbw$matchDyeItem(boolean original, @Local int i, @Local ItemStack itemStack) {
        return original || (i == 4 && itemStack.getItem() instanceof DyeItem);
    }

    @Unique
    private static ItemStack getStackWith(Item item, Sherds sherds) {
        ItemStack stack = item.getDefaultStack();
        stack.set(DataComponentTypes.POT_DECORATIONS, sherds);
        return stack;
    }
}
