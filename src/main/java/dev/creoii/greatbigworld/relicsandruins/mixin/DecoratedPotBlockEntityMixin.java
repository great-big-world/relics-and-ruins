package dev.creoii.greatbigworld.relicsandruins.mixin;

import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DecoratedPotBlockEntity.class)
public class DecoratedPotBlockEntityMixin implements DyedDecoratedPot, TrimmedDecoratedPot {
    @Unique private final String TRIM_KEY = "trim";
    @Unique private MapColor color = null;
    @Unique private int trim;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gbw$initDefaultTrim(BlockPos pos, BlockState state, CallbackInfo ci) {
        trim = 0;
    }

    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void gbw$writeTrimNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt(TRIM_KEY, trim);
    }

    @Inject(method = "readNbt", at = @At("TAIL"))
    private void gbw$readTrimNbt(NbtCompound nbt, CallbackInfo ci) {
        trim = nbt.getInt(TRIM_KEY);
    }

    @Override
    public int gbw$getTrim() {
        return trim;
    }

    @Override
    public void gbw$setTrim(int trim) {
        this.trim = trim;
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
