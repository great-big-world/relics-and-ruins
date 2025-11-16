package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapOperation(method = "travelMidAir", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getVelocityAffectingPos()Lnet/minecraft/util/math/BlockPos;"))
    private BlockPos gbw$fixSlipperinessForSlabs(LivingEntity instance, Operation<BlockPos> original) {
        if (instance.getEntityPos().y % 1 == .5d) {
            return new BlockPos(getVelocityAffectingPos().getX(), MathHelper.floor(getEntityPos().y), getVelocityAffectingPos().getZ());
        } else return original.call(instance);
    }
}
