package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.CatSitOnBlockGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CatSitOnBlockGoal.class)
public class CatSitOnBlockGoalMixin {
    @ModifyExpressionValue(method = "isTargetPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 0))
    private boolean gbw$catSitOnVariantChests(boolean original, @Local BlockState blockState) {
        return original || blockState.isIn(RelicsAndRuinsTags.VARIANT_CHEST_BLOCKS);
    }
}
