package dev.creoii.greatbigworld.relicsandruins.mixin.block;

import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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

    @Inject(method = "saveAdditional", at = @At("TAIL"))
    private void gbw$writeTrimNbt(ValueOutput valueOutput, CallbackInfo ci) {
        valueOutput.putInt(TRIM_KEY, trim);
    }

    @Inject(method = "loadAdditional", at = @At("TAIL"))
    private void gbw$readTrimNbt(ValueInput valueInput, CallbackInfo ci) {
        trim = valueInput.getIntOr(TRIM_KEY, 0);
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
