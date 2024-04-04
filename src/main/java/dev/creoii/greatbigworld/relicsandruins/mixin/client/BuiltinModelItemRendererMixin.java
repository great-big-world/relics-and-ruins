package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinModelItemRendererMixin {
    @Shadow @Final private DecoratedPotBlockEntity renderDecoratedPot;

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 4))
    private boolean gbw$renderDecoratedPotItemModels(boolean original, @Local BlockState blockState) {
        return original || blockState.getBlock() instanceof DecoratedPotBlock;
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/DecoratedPotBlockEntity;readNbtFromStack(Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.AFTER))
    private void gbw$modifyDecoratedPotRender(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci, @Local BlockState blockState) {
        if (blockState.getBlock() instanceof DecoratedPotBlock decoratedPotBlock && decoratedPotBlock instanceof DyedDecoratedPot dyedDecoratedPot) {
            if (blockState.isOf(Blocks.DECORATED_POT))
                ((DyedDecoratedPot) renderDecoratedPot).gbw$setColor(null);
            else ((DyedDecoratedPot) renderDecoratedPot).gbw$setColor(dyedDecoratedPot.gbw$getColor());
        }
    }
}
