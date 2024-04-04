package dev.creoii.greatbigworld.relicsandruins.mixin.client.screen;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedSmithingScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SmithingScreenHandler.class)
public abstract class SmithingScreenHandlerMixin extends ForgingScreenHandler implements ExtendedSmithingScreenHandler {
    @Shadow @Final private List<RecipeEntry<SmithingRecipe>> recipes;
    @Unique private Property selectedRecipe;

    public SmithingScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject(method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V", at = @At("TAIL"))
    private void gbw$initSelectedRecipeProperty(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, CallbackInfo ci) {
        this.selectedRecipe = Property.create();
        this.addProperty(this.selectedRecipe);
        selectedRecipe.set(-1);
    }

    @ModifyReturnValue(method = "getForgingSlotsManager", at = @At("RETURN"))
    private ForgingSlotsManager gbw$fixSmithingSlotsHeight(ForgingSlotsManager original) {
        return ForgingSlotsManager.create().input(0, 60, 14, stack -> false).input(1, 8, 14, (stack) -> {
            return recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testBase(stack);
            });
        }).input(2, 26, 14, (stack) -> {
            return recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testAddition(stack);
            });
        }).output(3, 17, 52).build();
    }

    @ModifyReturnValue(method = "getInputStacks", at = @At("RETURN"))
    private List<ItemStack> gbw$fixInputSlots(List<ItemStack> original) {
        return List.of(input.getStack(1), input.getStack(2));
    }

    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            if (selectedRecipe.get() == id) {
                selectedRecipe.set(-1);
                this.input.setStack(0, ItemStack.EMPTY);
            } else {
                this.selectedRecipe.set(id);
                this.input.setStack(0, SMITHING_TEMPLATES.get(id).getDefaultStack());
            }
        }
        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < SMITHING_TEMPLATES.size();
    }

    public int gbw$getSelectedRecipe() {
        return this.selectedRecipe.get();
    }
}
