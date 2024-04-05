package dev.creoii.greatbigworld.relicsandruins.mixin;

import dev.creoii.greatbigworld.relicsandruins.item.EchoingBladeItem;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsShapeTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
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
    @Shadow @Nullable public ClientWorld world;
    @Unique private HitResult xrayResult;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;updateTargetedEntity(F)V"))
    private void gbw$updateXrayHitResult(CallbackInfo ci) {
        if (interactionManager != null && getCameraEntity() != null) {
            double d = interactionManager.getReachDistance();
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
        if (player != null && player.getStackInHand(player.getActiveHand()).getItem() instanceof EchoingBladeItem && xrayResult != null && xrayResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult) xrayResult;
            this.interactionManager.attackEntity(this.player, entityHitResult.getEntity());
        }
    }

    @Unique
    public HitResult raycast(Entity entity, double maxDistance, float tickDelta) {
        Vec3d vec3d = entity.getCameraPosVec(tickDelta);
        Vec3d vec3d2 = entity.getRotationVec(tickDelta);
        Vec3d vec3d3 = vec3d.add(vec3d2.x * maxDistance, vec3d2.y * maxDistance, vec3d2.z * maxDistance);
        RaycastContext context = new RaycastContext(vec3d, vec3d3, RelicsAndRuinsShapeTypes.EMPTY, RaycastContext.FluidHandling.NONE, entity);
        return entity.getWorld().raycast(context);
    }
}
