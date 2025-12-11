package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @WrapOperation(method = "travelInAir", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getBlockPosBelowThatAffectsMyMovement()Lnet/minecraft/core/BlockPos;"))
    private BlockPos gbw$fixSlipperinessForSlabs(LivingEntity instance, Operation<BlockPos> original) {
        if (instance.position().y % 1 == .5d) {
            return new BlockPos(getBlockPosBelowThatAffectsMyMovement() .getX(), Mth.floor(position().y), getBlockPosBelowThatAffectsMyMovement().getZ());
        } else return original.call(instance);
    }
}
