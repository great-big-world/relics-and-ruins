package dev.creoii.greatbigworld.relicsandruins.mixin.block;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin implements DyedDecoratedPot {
    @Unique private MapColor color;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gbw$setColor(AbstractBlock.Settings settings, CallbackInfo ci) {
        if ((DecoratedPotBlock) (Object) this != Blocks.DECORATED_POT)
            color = ((DecoratedPotBlock) (Object) this).getDefaultMapColor();
    }

    @Inject(method = "getPickStack", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private void gbw$fixPotPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData, CallbackInfoReturnable<ItemStack> cir, @Local DecoratedPotBlockEntity decoratedPotBlockEntity) {
        ItemStack stack = decoratedPotBlockEntity.getCachedState().getBlock().asItem().getDefaultStack();
        BlockItem.setBlockEntityData(stack, BlockEntityType.DECORATED_POT, decoratedPotBlockEntity.getSherds().toNbt(new NbtCompound()));
        cir.setReturnValue(stack);
    }

    @ModifyReturnValue(method = "createBlockEntity", at = @At("RETURN"))
    private BlockEntity gbw$dyeCreateBlockEntity(BlockEntity original, @Local(argsOnly = true) BlockState state) {
        if (!state.isOf(Blocks.DECORATED_POT))
            ((DyedDecoratedPot) original).gbw$setColor(color);
        else ((DyedDecoratedPot) original).gbw$setColor(null);
        return original;
    }

    @Override
    @Nullable
    public MapColor gbw$getColor() {
        return color;
    }

    @Override
    public void gbw$setColor(MapColor color) {
        this.color = color;
    }
}
