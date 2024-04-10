package dev.creoii.greatbigworld.relicsandruins.mixin;

import dev.creoii.greatbigworld.relicsandruins.util.TemplateUnlockerPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SmithingTemplateItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Shadow @Final public PlayerEntity player;

    @Inject(method = "setStack", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/collection/DefaultedList;set(ILjava/lang/Object;)Ljava/lang/Object;"))
    private void gbw$unlockSmithingTemplates(int slot, ItemStack stack, CallbackInfo ci) {
        if (stack.getItem() instanceof SmithingTemplateItem && player instanceof TemplateUnlockerPlayer templateUnlockerPlayer && !templateUnlockerPlayer.gbw$isUnlocked(stack.getItem())) {
            templateUnlockerPlayer.gbw$unlockTemplate(stack.getItem());
        }
    }
}
