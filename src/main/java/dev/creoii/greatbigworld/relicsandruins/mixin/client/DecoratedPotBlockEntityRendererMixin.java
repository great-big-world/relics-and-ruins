package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
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
import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotBlockEntityRenderer.class)
public abstract class DecoratedPotBlockEntityRendererMixin {
    @Shadow @Final private ModelPart front;
    @Shadow @Final private ModelPart back;
    @Shadow @Final private ModelPart left;
    @Shadow @Final private ModelPart right;
    @Shadow @Final private ModelPart neck;
    @Shadow @Final private ModelPart top;
    @Shadow @Final private ModelPart bottom;
    @Unique private static final int BASE_COLOR = 10443081;
    @Unique private static final SpriteIdentifier BASE_SPRITE = new SpriteIdentifier(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE, Identifier.of("entity/decorated_pot/decorated_pot_side"));
    @Unique private ModelPart frontTrim;
    @Unique private ModelPart backTrim;
    @Unique private ModelPart leftTrim;
    @Unique private ModelPart rightTrim;
    @Unique private ModelPart frontPattern;
    @Unique private ModelPart backPattern;
    @Unique private ModelPart leftPattern;
    @Unique private ModelPart rightPattern;

    @Inject(method = "<init>(Lnet/minecraft/client/render/entity/model/LoadedEntityModels;)V", at = @At("TAIL"))
    private void gbw$initDecalParts(LoadedEntityModels models, CallbackInfo ci, @Local(ordinal = 1) ModelPart modelPart2) {
        this.frontTrim = modelPart2.getChild("front_trim");
        this.backTrim = modelPart2.getChild("back_trim");
        this.leftTrim = modelPart2.getChild("left_trim");
        this.rightTrim = modelPart2.getChild("right_trim");
        this.frontPattern = modelPart2.getChild("front_pattern");
        this.backPattern = modelPart2.getChild("back_pattern");
        this.leftPattern = modelPart2.getChild("left_pattern");
        this.rightPattern = modelPart2.getChild("right_pattern");
    }

    @Redirect(method = "render(Lnet/minecraft/block/entity/DecoratedPotBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/DecoratedPotBlockEntityRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/block/entity/Sherds;)V"))
    private void gbw$renderPotDecals(DecoratedPotBlockEntityRenderer instance, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Sherds sherds, @Local(argsOnly = true) DecoratedPotBlockEntity decoratedPotBlockEntity) {
        VertexConsumer vertexConsumer = TexturedRenderLayers.DECORATED_POT_BASE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        float[] color;
        if (decoratedPotBlockEntity instanceof DyedDecoratedPot dyedDecoratedPot) {
            int mapColor = dyedDecoratedPot.gbw$getColor() != null ? dyedDecoratedPot.gbw$getColor().color : BASE_COLOR;
            color = new float[]{red(mapColor), green(mapColor), blue(mapColor)};
        } else color = new float[]{red(BASE_COLOR), green(BASE_COLOR), blue(BASE_COLOR)};
        neck.render(matrices, vertexConsumer, light, overlay, ColorHelper.fromFloats(1f, color[0], color[1], color[2]));
        top.render(matrices, vertexConsumer, light, overlay, ColorHelper.fromFloats(1f, color[0], color[1], color[2]));
        bottom.render(matrices, vertexConsumer, light, overlay, ColorHelper.fromFloats(1f, color[0], color[1], color[2]));
        renderSide(front, matrices, vertexConsumers, light, overlay, color);
        renderSide(back, matrices, vertexConsumers, light, overlay, color);
        renderSide(left, matrices, vertexConsumers, light, overlay, color);
        renderSide(right, matrices, vertexConsumers, light, overlay, color);
        if (sherds.front().isPresent()) {
            renderPatternedSide(frontPattern, matrices, vertexConsumers, light, overlay, sherds.front().get(), color);
        }
        if (sherds.back().isPresent()) {
            renderPatternedSide(backPattern, matrices, vertexConsumers, light, overlay, sherds.back().get(), color);
        }
        if (sherds.left().isPresent()) {
            renderPatternedSide(leftPattern, matrices, vertexConsumers, light, overlay, sherds.left().get(), color);
        }
        if (sherds.right().isPresent()) {
            renderPatternedSide(rightPattern, matrices, vertexConsumers, light, overlay, sherds.right().get(), color);
        }

        int trim = ((TrimmedDecoratedPot) decoratedPotBlockEntity).gbw$getTrim();
        if (isSherdNotBrick(sherds.front()) || isSherdNotBrick(sherds.back()) || isSherdNotBrick(sherds.left()) || isSherdNotBrick(sherds.right())) {
            renderTrimmedSide(frontTrim, matrices, vertexConsumers, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(backTrim, matrices, vertexConsumers, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(leftTrim, matrices, vertexConsumers, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(rightTrim, matrices, vertexConsumers, light, overlay, getTextureIdFromTrim(trim));
        }
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
        return new SpriteIdentifier(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE, Identifier.of("entity/decorated_pot/trim/trim" + trim));
    }

    @Unique
    @Nullable
    private static SpriteIdentifier getPatternIdFromSherd(Item item) {
        if (item == Items.BRICK)
            return null;
        SpriteIdentifier id = TexturedRenderLayers.getDecoratedPotPatternTextureId(DecoratedPotPatterns.fromSherd(item));
        return id == null ? null : new SpriteIdentifier(id.getAtlasId(), Identifier.of(id.getTextureId().getNamespace(), id.getTextureId().getPath().replace("pot/", "pot/pattern/").replace("_pottery_pattern", "")));
    }

    @Unique
    private void renderSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, float[] color) {
        part.render(matrices, BASE_SPRITE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid), light, overlay, ColorHelper.fromFloats(1f, color[0], color[1], color[2]));
    }

    @Unique
    private void renderPatternedSide(ModelPart part, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, @Nullable Item item, float[] color) {
        SpriteIdentifier textureId = getPatternIdFromSherd(item);
        if (textureId != null)
            part.render(matrices, textureId.getVertexConsumer(vertexConsumers, RenderLayer::getEntityTranslucent), light, overlay, ColorHelper.fromFloats(1f, color[0], color[1], color[2]));
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

    @Unique
    private static boolean isSherdNotBrick(Optional<Item> sherd) {
        return sherd.isPresent() && sherd.get() != Items.BRICK;
    }
}
