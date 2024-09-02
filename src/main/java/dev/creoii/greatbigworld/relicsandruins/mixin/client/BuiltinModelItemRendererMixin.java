package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinModelItemRendererMixin {
    @Shadow @Final private DecoratedPotBlockEntity renderDecoratedPot;
    @Shadow @Final private ChestBlockEntity renderChestNormal;
    @Unique private static final ChestBlockEntity RENDER_CHEST_OAK = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.OAK_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_SPRUCE = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.SPRUCE_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_BIRCH = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.BIRCH_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_JUNGLE = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.JUNGLE_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_DARK_OAK = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.DARK_OAK_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_ACACIA = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.ACACIA_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_MANGROVE = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.MANGROVE_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_CHERRY = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.CHERRY_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_BAMBOO = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.BAMBOO_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_CRIMSON = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.CRIMSON_CHEST.getDefaultState());
    @Unique private static final ChestBlockEntity RENDER_CHEST_WARPED = new ChestBlockEntity(BlockPos.ORIGIN, RelicsAndRuinsBlocks.WARPED_CHEST.getDefaultState());
    @Unique
    private static final Map<WoodType, ChestBlockEntity> CHEST_ITEM_ENTITY_RENDERERS = ImmutableMap.<WoodType, ChestBlockEntity>builder()
            .put(WoodType.OAK, RENDER_CHEST_OAK)
            .put(WoodType.SPRUCE, RENDER_CHEST_SPRUCE)
            .put(WoodType.BIRCH, RENDER_CHEST_BIRCH)
            .put(WoodType.JUNGLE, RENDER_CHEST_JUNGLE)
            .put(WoodType.DARK_OAK, RENDER_CHEST_DARK_OAK)
            .put(WoodType.ACACIA, RENDER_CHEST_ACACIA)
            .put(WoodType.MANGROVE, RENDER_CHEST_MANGROVE)
            .put(WoodType.CHERRY, RENDER_CHEST_CHERRY)
            .put(WoodType.BAMBOO, RENDER_CHEST_BAMBOO)
            .put(WoodType.CRIMSON, RENDER_CHEST_CRIMSON)
            .put(WoodType.WARPED, RENDER_CHEST_WARPED)
            .build();

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 4))
    private boolean gbw$renderDecoratedPotItemModels(boolean original, @Local BlockState blockState) {
        return original || blockState.getBlock() instanceof DecoratedPotBlock;
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/DecoratedPotBlockEntity;readFrom(Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.AFTER))
    private void gbw$modifyDecoratedPotRender(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci, @Local BlockState blockState) {
        if (blockState.getBlock() instanceof DecoratedPotBlock decoratedPotBlock && decoratedPotBlock instanceof DyedDecoratedPot dyedDecoratedPot) {
            if (blockState.isOf(Blocks.DECORATED_POT)) {
                ((DyedDecoratedPot) renderDecoratedPot).gbw$setColor(null);
            } else ((DyedDecoratedPot) renderDecoratedPot).gbw$setColor(dyedDecoratedPot.gbw$getColor());
        }
    }

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", ordinal = 1))
    private boolean gbw$allowRenderVariantChestItems(boolean original, @Local BlockState blockState) {
        return original || blockState.isIn(RelicsAndRuinsTags.BLOCKS_VARIANT_CHESTS);
    }

    @WrapOperation(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/item/BuiltinModelItemRenderer;renderChestNormal:Lnet/minecraft/block/entity/ChestBlockEntity;"))
    private ChestBlockEntity gbw$renderVariantChestItems(BuiltinModelItemRenderer instance, Operation<ChestBlockEntity> original, @Local BlockState blockState) {
        if (blockState.getBlock() instanceof ChestBlock chestBlock) {
            return CHEST_ITEM_ENTITY_RENDERERS.get(chestBlock.getWoodType());
        }
        return renderChestNormal;
    }
}
