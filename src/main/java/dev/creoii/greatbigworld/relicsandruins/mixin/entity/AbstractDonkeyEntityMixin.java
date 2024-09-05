package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractDonkeyEntity.class)
public class AbstractDonkeyEntityMixin {
    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean gbw$allowVariantChestsOnDonkeys(ItemStack instance, Item item) {
        return instance.isIn(RelicsAndRuinsTags.VARIANT_CHEST_ITEMS);
    }
}
