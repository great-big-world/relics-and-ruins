package dev.creoii.greatbigworld.relicsandruins.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.creoapi.api.modification.BlockModification;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
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
        color = BlockModification.INSTANCE.getMapColor((DecoratedPotBlock) (Object) this);
    }

    @Inject(method = "getPickStack", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private void gbw$fixPotPickStack(WorldView world, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir, @Local DecoratedPotBlockEntity decoratedPotBlockEntity) {
        ItemStack stack = decoratedPotBlockEntity.getCachedState().getBlock().asItem().getDefaultStack();
        BlockItem.setBlockEntityNbt(stack, BlockEntityType.DECORATED_POT, decoratedPotBlockEntity.getSherds().toNbt(new NbtCompound()));
        cir.setReturnValue(stack);
    }

    @Override
    public MapColor gbw$getColor() {
        return color;
    }

    @Override
    public void gbw$setColor(MapColor color) {
        this.color = color;
    }
}
