package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import dev.creoii.greatbigworld.relicsandruins.util.XrayAttack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow @Nullable public abstract Entity getCameraEntity();
    @Shadow @Nullable public ClientPlayerInteractionManager interactionManager;
    @Shadow @Nullable public ClientPlayerEntity player;
    @Unique private HitResult xrayResult;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;updateTargetedEntity(F)V"))
    private void gbw$updateXrayHitResult(CallbackInfo ci) {
        if (interactionManager != null && getCameraEntity() != null) {
            double d = interactionManager.getReachDistance() * 2.5d;
            Vec3d vec3d = getCameraEntity().getCameraPosVec(1f);
            Vec3d vec3d2 = getCameraEntity().getRotationVec(1f);
            Vec3d vec3d3 = vec3d.add(vec3d2.x * d, vec3d2.y * d, vec3d2.z * d);
            Box box = getCameraEntity().getBoundingBox().stretch(vec3d2.multiply(d)).expand(1d, 1d, 1d);
            xrayResult = ProjectileUtil.raycast(getCameraEntity(), vec3d, vec3d3, box, (entityx) -> {
                return !entityx.isSpectator() && entityx.canHit();
            }, d);
        }
    }

    @Inject(method = "doAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/hit/HitResult;getType()Lnet/minecraft/util/hit/HitResult$Type;"))
    private void gbw$doItemClicks(CallbackInfoReturnable<Boolean> cir) {
        if (player != null && interactionManager != null) {
            ItemStack stack = player.getStackInHand(player.getActiveHand());
            if (stack.getItem() instanceof XrayAttack xrayAttack && xrayResult != null && xrayResult.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) xrayResult;
                interactionManager.attackEntity(player, entityHitResult.getEntity());
                xrayAttack.onXrayAttack((MinecraftClient) (Object) this, stack, entityHitResult.getEntity());
            }
        }
    }
}
