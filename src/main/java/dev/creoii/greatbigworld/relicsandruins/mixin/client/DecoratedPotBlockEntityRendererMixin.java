package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.EnumSet;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotBlockEntityRenderer.class)
public abstract class DecoratedPotBlockEntityRendererMixin {
    @Shadow @Final private ModelPart front;
    @Shadow @Final private ModelPart back;
    @Shadow @Final private ModelPart left;
    @Shadow @Final private ModelPart right;
    @Unique private static final int BASE_COLOR = 10443081;
    @Unique private static final SpriteIdentifier BASE_SPRITE = new SpriteIdentifier(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE, new Identifier("entity/decorated_pot/decorated_pot_side"));
    @Unique private ModelPart frontTrim;
    @Unique private ModelPart backTrim;
    @Unique private ModelPart leftTrim;
    @Unique private ModelPart rightTrim;
    @Unique private ModelPart frontPattern;
    @Unique private ModelPart backPattern;
    @Unique private ModelPart leftPattern;
    @Unique private ModelPart rightPattern;

    @Inject(method = "<init>", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void gbw$initDecalParts(BlockEntityRendererFactory.Context context, CallbackInfo ci, ModelPart modelPart, ModelPart modelPart2) {
        this.frontTrim = modelPart2.getChild("front_trim");
        this.backTrim = modelPart2.getChild("back_trim");
        this.leftTrim = modelPart2.getChild("left_trim");
        this.rightTrim = modelPart2.getChild("right_trim");
        this.frontPattern = modelPart2.getChild("front_pattern");
        this.backPattern = modelPart2.getChild("back_pattern");
        this.leftPattern = modelPart2.getChild("left_pattern");
        this.rightPattern = modelPart2.getChild("right_pattern");
    }

    @Redirect(method = "render(Lnet/minecraft/block/entity/DecoratedPotBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelPart;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;II)V"))
    private void gbw$tintRenders(ModelPart instance, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, @Local(argsOnly = true) DecoratedPotBlockEntity decoratedPotBlockEntity) {
        float[] color;
        if (decoratedPotBlockEntity instanceof DyedDecoratedPot dyedDecoratedPot) {
            int mapColor = dyedDecoratedPot.gbw$getColor() != null ? dyedDecoratedPot.gbw$getColor().color : BASE_COLOR;
            color = new float[]{red(mapColor), green(mapColor), blue(mapColor)};
        } else color = new float[]{red(BASE_COLOR), green(BASE_COLOR), blue(BASE_COLOR)};
        instance.render(matrices, vertices, light, overlay, color[0], color[1], color[2], 1f);
    }

    @Inject(method = "render(Lnet/minecraft/block/entity/DecoratedPotBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/DecoratedPotBlockEntityRenderer;renderDecoratedSide(Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/util/SpriteIdentifier;)V", ordinal = 0), cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private void gbw$renderPotDecals(DecoratedPotBlockEntity decoratedPotBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci, Direction direction, DecoratedPotBlockEntity.WobbleType wobbleType, VertexConsumer vertexConsumer, DecoratedPotBlockEntity.Sherds sherds) {
        float[] color;
        if (decoratedPotBlockEntity instanceof DyedDecoratedPot dyedDecoratedPot) {
            int mapColor = dyedDecoratedPot.gbw$getColor() != null ? dyedDecoratedPot.gbw$getColor().color : BASE_COLOR;
            color = new float[]{red(mapColor), green(mapColor), blue(mapColor)};
        } else color = new float[]{red(BASE_COLOR), green(BASE_COLOR), blue(BASE_COLOR)};
        renderSide(front, matrixStack, vertexConsumerProvider, i, j, color);
        renderSide(back, matrixStack, vertexConsumerProvider, i, j, color);
        renderSide(left, matrixStack, vertexConsumerProvider, i, j, color);
        renderSide(right, matrixStack, vertexConsumerProvider, i, j, color);
        if (sherds.front() != null) {
            renderPatternedSide(frontPattern, matrixStack, vertexConsumerProvider, i, j, sherds.front(), color);
        }
        if (sherds.back() != null) {
            renderPatternedSide(backPattern, matrixStack, vertexConsumerProvider, i, j, sherds.back(), color);
        }
        if (sherds.left() != null) {
            renderPatternedSide(leftPattern, matrixStack, vertexConsumerProvider, i, j, sherds.left(), color);
        }
        if (sherds.right() != null) {
            renderPatternedSide(rightPattern, matrixStack, vertexConsumerProvider, i, j, sherds.right(), color);
        }

        int trim = ((TrimmedDecoratedPot) decoratedPotBlockEntity).gbw$getTrim();
        if (sherds.front() != Items.BRICK || sherds.back() != Items.BRICK || sherds.left() != Items.BRICK || sherds.right() != Items.BRICK) {
            renderTrimmedSide(frontTrim, matrixStack, vertexConsumerProvider, i, j, getTextureIdFromTrim(trim));
            renderTrimmedSide(backTrim, matrixStack, vertexConsumerProvider, i, j, getTextureIdFromTrim(trim));
            renderTrimmedSide(leftTrim, matrixStack, vertexConsumerProvider, i, j, getTextureIdFromTrim(trim));
            renderTrimmedSide(rightTrim, matrixStack, vertexConsumerProvider, i, j, getTextureIdFromTrim(trim));
        }

        matrixStack.pop();
        ci.cancel();
    }

    @Inject(method = "getSidesTexturedModelData", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void gbw$addDecalSidesTexturedModelData(CallbackInfoReturnable<TexturedModelData> cir, ModelData modelData, ModelPartData modelPartData, ModelPartBuilder modelPartBuilder) {
        ModelPartBuilder decalBuilder = ModelPartBuilder.create().uv(1, 0).cuboid(-.01f, 0f, -.01f, 14.01f, 16f, .01f, EnumSet.of(Direction.NORTH));
        modelPartData.addChild("back_trim", decalBuilder, ModelTransform.of(15f, 16f, 1f, 0f, 0f, (float) Math.PI));
        modelPartData.addChild("left_trim", decalBuilder, ModelTransform.of(1f, 16f, 1f, 0f, -1.5707964f, (float) Math.PI));
        modelPartData.addChild("right_trim", decalBuilder, ModelTransform.of(15f, 16f, 15f, 0f, 1.5707964f, (float) Math.PI));
        modelPartData.addChild("front_trim", decalBuilder, ModelTransform.of(1f, 16f, 15f, (float) Math.PI, 0f, 0f));
        modelPartData.addChild("back_pattern", decalBuilder, ModelTransform.of(15f, 16f, 1f, 0f, 0f, (float) Math.PI));
        modelPartData.addChild("left_pattern", decalBuilder, ModelTransform.of(1f, 16f, 1f, 0f, -1.5707964f, (float) Math.PI));
        modelPartData.addChild("right_pattern", decalBuilder, ModelTransform.of(15f, 16f, 15f, 0f, 1.5707964f, (float) Math.PI));
        modelPartData.addChild("front_pattern", decalBuilder, ModelTransform.of(1f, 16f, 15f, (float) Math.PI, 0f, 0f));
    }

    @Unique
    private void renderTrimmedSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, SpriteIdentifier textureId) {
        part.render(matrices, textureId.getVertexConsumer(vertexConsumers, RenderLayer::getEntityTranslucent), light, overlay);
    }

    @Unique
    private static SpriteIdentifier getTextureIdFromTrim(int trim) {
        return new SpriteIdentifier(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE, new Identifier("entity/decorated_pot/trim/trim" + trim));
    }

    @Unique
    @Nullable
    private static SpriteIdentifier getPatternIdFromSherd(Item item) {
        if (item == Items.BRICK)
            return null;
        SpriteIdentifier id = TexturedRenderLayers.getDecoratedPotPatternTextureId(DecoratedPotPatterns.fromSherd(item));
        return id == null ? null : new SpriteIdentifier(id.getAtlasId(), new Identifier(id.getTextureId().getNamespace(), id.getTextureId().getPath().replace("pot/", "pot/pattern/").replace("_pottery_pattern", "")));
    }

    @Unique
    private void renderSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, float[] color) {
        part.render(matrices, BASE_SPRITE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid), light, overlay, color[0], color[1], color[2], 1f);
    }

    @Unique
    private void renderPatternedSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, @Nullable Item item, float[] color) {
        SpriteIdentifier textureId = getPatternIdFromSherd(item);
        if (textureId != null)
            part.render(matrices, textureId.getVertexConsumer(vertexConsumers, RenderLayer::getEntityTranslucent), light, overlay, color[0], color[1], color[2], 1f);
    }

    @Unique
    private static float red(int color) {
        return (color >> 16 & 0xff) / 255f;
    }

    @Unique
    private static float green(int color) {
        return (color >> 8 & 0xff) / 255f;
    }

    @Unique
    private static float blue(int color) {
        return (color & 0xff) / 255f;
    }
}
