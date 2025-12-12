package dev.creoii.greatbigworld.relicsandruins.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.DecoratedPotRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotRecipe.class)
public class CraftingDecoratedPotRecipeMixin {
    @Inject(method = "matches(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/world/level/Level;)Z", at = @At("HEAD"), cancellable = true)
    private void gbw$allowDyedDecoratedPotRecipes(CraftingInput craftingInput, Level level, CallbackInfoReturnable<Boolean> cir) {
        if (craftingInput.width() == 3 && craftingInput.height() == 3 && craftingInput.ingredientCount() == 5)
            cir.setReturnValue(true);
    }

    @Inject(method = "assemble(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/core/HolderLookup$Provider;)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    private void gbw$makeDecoratedPotsDyeable(CraftingInput craftingInput, HolderLookup.Provider provider, CallbackInfoReturnable<ItemStack> cir, @Local PotDecorations sherds) {
        if (craftingInput.getItem(1, 1).getItem() instanceof DyeItem dyeItem) {
            cir.setReturnValue(switch (dyeItem.getDyeColor()) {
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

    @Unique
    private static ItemStack getStackWith(Item item, PotDecorations sherds) {
        ItemStack stack = item.getDefaultInstance();
        stack.set(DataComponents.POT_DECORATIONS, sherds);
        return stack;
    }
}
