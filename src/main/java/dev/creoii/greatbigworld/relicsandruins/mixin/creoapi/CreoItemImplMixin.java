package dev.creoii.greatbigworld.relicsandruins.mixin.creoapi;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.creoapi.impl.item.CreoItemImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreoItemImpl.class)
public class CreoItemImplMixin {
    @Inject(method = "applyAttackThroughBlockClient", at = @At(value = "INVOKE", target = "Ldev/creoii/creoapi/api/item/CreoItem;onAttackThroughBlock(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/Entity;)V"))
    private static void gbw$updateTargetedEntity(MinecraftClient client, CallbackInfo ci, @Local EntityHitResult xrayResult) {
        client.targetedEntity = xrayResult.getEntity();
    }
}
