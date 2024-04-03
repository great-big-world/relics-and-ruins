package dev.creoii.greatbigworld.relicsandruins.mixin.client.screen;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedSmithingScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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
    }

    @ModifyReturnValue(method = "getForgingSlotsManager", at = @At("RETURN"))
    private ForgingSlotsManager gbw$fixSmithingSlotsHeight(ForgingSlotsManager original) {
        return ForgingSlotsManager.create().input(0, 8, 14, (stack) -> {
            return recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testBase(stack);
            });
        }).input(1, 26, 14, (stack) -> {
            return recipes.stream().anyMatch((recipe) -> {
                return (recipe.value()).testAddition(stack);
            });
        }).output(3, 17, 52).build();
    }

    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            //this.populateResult();
        }

        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < 16;
    }

    public int gbw$getSelectedRecipe() {
        return this.selectedRecipe.get();
    }
}
