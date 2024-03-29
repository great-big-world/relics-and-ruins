package dev.creoii.greatbigworld.relicsandruins.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinModelItemRendererMixin {
    @Mutable @Shadow @Final private DecoratedPotBlockEntity renderDecoratedPot;
    @Unique private final DecoratedPotBlockEntity renderBrownDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.BROWN_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderRedDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.RED_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderOrangeDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.ORANGE_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderYellowDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.YELLOW_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderLimeDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.LIME_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderGreenDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.GREEN_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderCyanDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.CYAN_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderBlueDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.BLUE_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderLightBlueDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderPinkDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.PINK_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderMagentaDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderPurpleDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.PURPLE_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderBlackDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.BLACK_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderGrayDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.GRAY_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderLightGrayDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT.getDefaultState());
    @Unique private final DecoratedPotBlockEntity renderWhiteDecoratedPot = new DecoratedPotBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.WHITE_DECORATED_POT.getDefaultState());

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 4))
    private boolean gbw$renderDecoratedPotItemModels(boolean original, @Local BlockState blockState) {
        return original || blockState.getBlock() instanceof DecoratedPotBlock;
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/DecoratedPotBlockEntity;readNbtFromStack(Lnet/minecraft/item/ItemStack;)V"))
    private void gbw$modifyDecoratedPotRender(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci, @Local BlockState blockState) {
        renderDecoratedPot = getFromPot(blockState);
    }

    @Unique
    private DecoratedPotBlockEntity getFromPot(BlockState state) {
        if (state.isOf(RelicsAndRuinsBlocks.BROWN_DECORATED_POT)) {
            return renderBrownDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.RED_DECORATED_POT)) {
            return renderRedDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.ORANGE_DECORATED_POT)) {
            return renderOrangeDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.YELLOW_DECORATED_POT)) {
            return renderYellowDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.LIME_DECORATED_POT)) {
            return renderLimeDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.GREEN_DECORATED_POT)) {
            return renderGreenDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.CYAN_DECORATED_POT)) {
            return renderCyanDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.BLUE_DECORATED_POT)) {
            return renderBlueDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.LIGHT_BLUE_DECORATED_POT)) {
            return renderLightBlueDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.PINK_DECORATED_POT)) {
            return renderPinkDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.MAGENTA_DECORATED_POT)) {
            return renderMagentaDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.PURPLE_DECORATED_POT)) {
            return renderPurpleDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.BLACK_DECORATED_POT)) {
            return renderBlackDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.GRAY_DECORATED_POT)) {
            return renderGrayDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.LIGHT_GRAY_DECORATED_POT)) {
            return renderLightGrayDecoratedPot;
        } else if (state.isOf(RelicsAndRuinsBlocks.WHITE_DECORATED_POT)) {
            return renderWhiteDecoratedPot;
        }
        return renderDecoratedPot;
    }
}
