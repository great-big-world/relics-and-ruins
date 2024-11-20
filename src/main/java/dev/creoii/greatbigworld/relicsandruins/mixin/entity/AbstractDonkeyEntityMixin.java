package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractDonkeyEntity.class)
public class AbstractDonkeyEntityMixin {
    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean gbw$allowVariantChestsOnDonkeys(boolean original, @Local ItemStack itemStack) {
        return original || itemStack.isIn(RelicsAndRuinsTags.VARIANT_CHEST_ITEMS);
    }
}
