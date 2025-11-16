package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedDecoratedPotRender;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.DecoratedPotBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteHolder;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.EnumSet;
import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotBlockEntityRenderer.class)
public abstract class DecoratedPotBlockEntityRendererMixin implements ExtendedDecoratedPotRender {
    @Shadow @Final private ModelPart front;
    @Shadow @Final private ModelPart back;
    @Shadow @Final private ModelPart left;
    @Shadow @Final private ModelPart right;
    @Shadow @Final private ModelPart neck;
    @Shadow @Final private ModelPart top;
    @Shadow @Final private ModelPart bottom;
    @Shadow @Final private SpriteHolder materials;
    @Unique private static final int BASE_COLOR = 10443081;
    @Unique private static final SpriteIdentifier BASE_SPRITE_ID = new SpriteIdentifier(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE, Identifier.of("entity/decorated_pot/decorated_pot_side"));
    @Unique private ModelPart frontTrim;
    @Unique private ModelPart backTrim;
    @Unique private ModelPart leftTrim;
    @Unique private ModelPart rightTrim;
    @Unique private ModelPart frontPattern;
    @Unique private ModelPart backPattern;
    @Unique private ModelPart leftPattern;
    @Unique private ModelPart rightPattern;

    @Inject(method = "updateRenderState(Lnet/minecraft/block/entity/DecoratedPotBlockEntity;Lnet/minecraft/client/render/block/entity/state/DecoratedPotBlockEntityRenderState;FLnet/minecraft/util/math/Vec3d;Lnet/minecraft/client/render/command/ModelCommandRenderer$CrumblingOverlayCommand;)V", at = @At("TAIL"))
    private void gbw$updateRenderStateForDyed(DecoratedPotBlockEntity decoratedPotBlockEntity, DecoratedPotBlockEntityRenderState decoratedPotBlockEntityRenderState, float f, Vec3d vec3d, ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand, CallbackInfo ci) {
        if (decoratedPotBlockEntity instanceof DyedDecoratedPot dyedDecoratedPot && decoratedPotBlockEntityRenderState instanceof DyedDecoratedPot dyedDecoratedPot1) {
            dyedDecoratedPot1.gbw$setColor(dyedDecoratedPot.gbw$getColor());
        }

        if (decoratedPotBlockEntity instanceof TrimmedDecoratedPot trimmedDecoratedPot && decoratedPotBlockEntityRenderState instanceof TrimmedDecoratedPot trimmedDecoratedPot1) {
            trimmedDecoratedPot1.gbw$setTrim(trimmedDecoratedPot.gbw$getTrim());
        }
    }

    @Override
    public void gbw$renderDyed(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, Sherds sherds, @Nullable MapColor color, int trim) {
        float[] rgb;
        if (color != null) {
            rgb = new float[]{red(color.color), green(color.color), blue(color.color)};
        } else rgb = new float[]{red(BASE_COLOR), green(BASE_COLOR), blue(BASE_COLOR)};

        Sprite sprite = materials.getSprite(BASE_SPRITE_ID);
        queue.submitModelPart(neck, matrices, BASE_SPRITE_ID.getRenderLayer(RenderLayer::getEntitySolid), light, overlay, sprite, false, false, ColorHelper.fromFloats(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        queue.submitModelPart(top, matrices, BASE_SPRITE_ID.getRenderLayer(RenderLayer::getEntitySolid), light, overlay, sprite, false, false, ColorHelper.fromFloats(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        queue.submitModelPart(bottom, matrices, BASE_SPRITE_ID.getRenderLayer(RenderLayer::getEntitySolid), light, overlay, sprite, false, false, ColorHelper.fromFloats(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        renderSide(front, matrices, queue, light, overlay, rgb);
        renderSide(back, matrices, queue, light, overlay, rgb);
        renderSide(left, matrices, queue, light, overlay, rgb);
        renderSide(right, matrices, queue, light, overlay, rgb);

        if (sherds.front().isPresent()) {
            renderPatternedSide(frontPattern, matrices, queue, light, overlay, sherds.front().get(), rgb);
        }
        if (sherds.back().isPresent()) {
            renderPatternedSide(backPattern, matrices, queue, light, overlay, sherds.back().get(), rgb);
        }
        if (sherds.left().isPresent()) {
            renderPatternedSide(leftPattern, matrices, queue, light, overlay, sherds.left().get(), rgb);
        }
        if (sherds.right().isPresent()) {
            renderPatternedSide(rightPattern, matrices, queue, light, overlay, sherds.right().get(), rgb);
        }

        if (isSherdNotBrick(sherds.front()) || isSherdNotBrick(sherds.back()) || isSherdNotBrick(sherds.left()) || isSherdNotBrick(sherds.right())) {
            renderTrimmedSide(frontTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(backTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(leftTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
            renderTrimmedSide(rightTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
        }
    }

    @Inject(method = "<init>(Lnet/minecraft/client/render/entity/model/LoadedEntityModels;Lnet/minecraft/client/texture/SpriteHolder;)V", at = @At("TAIL"))
    private void gbw$initDecalParts(LoadedEntityModels entityModelSet, SpriteHolder materials, CallbackInfo ci, @Local(ordinal = 1) ModelPart modelPart2) {
        this.frontTrim = modelPart2.getChild("front_trim");
        this.backTrim = modelPart2.getChild("back_trim");
        this.leftTrim = modelPart2.getChild("left_trim");
        this.rightTrim = modelPart2.getChild("right_trim");
        this.frontPattern = modelPart2.getChild("front_pattern");
        this.backPattern = modelPart2.getChild("back_pattern");
        this.leftPattern = modelPart2.getChild("left_pattern");
        this.rightPattern = modelPart2.getChild("right_pattern");
    }

    @Inject(method = "render(Lnet/minecraft/client/render/block/entity/state/DecoratedPotBlockEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/DecoratedPotBlockEntityRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;IILnet/minecraft/block/entity/Sherds;I)V"), cancellable = true)
    private void gbw$renderPotDecals(DecoratedPotBlockEntityRenderState decoratedPotBlockEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState, CallbackInfo ci) {
        if (decoratedPotBlockEntityRenderState instanceof DyedDecoratedPot dyedDecoratedPot) {
            int trim = ((TrimmedDecoratedPot) decoratedPotBlockEntityRenderState).gbw$getTrim();
            gbw$renderDyed(matrixStack, orderedRenderCommandQueue, decoratedPotBlockEntityRenderState.lightmapCoordinates, OverlayTexture.DEFAULT_UV, decoratedPotBlockEntityRenderState.sherds, dyedDecoratedPot.gbw$getColor(), trim);
            matrixStack.pop();
            ci.cancel();
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
    private void renderTrimmedSide(ModelPart part, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, SpriteIdentifier textureId) {
        Sprite sprite = materials.getSprite(BASE_SPRITE_ID);
        queue.submitModelPart(part, matrices, textureId.getRenderLayer(RenderLayer::getEntityTranslucent), light, overlay, sprite, false, false);
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
        return id == null ? null : new SpriteIdentifier(id.getAtlasId(), Identifier.of(id.getTextureId().getNamespace(), id.getTextureId().getPath().replace("decorated_pot/", "decorated_pot/pattern/").replace("_pottery_pattern", "")));
    }

    @Unique
    private void renderSide(ModelPart part, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, float[] color) {
        Sprite sprite = materials.getSprite(BASE_SPRITE_ID);
        queue.submitModelPart(part, matrices, BASE_SPRITE_ID.getRenderLayer(RenderLayer::getEntitySolid), light, overlay, sprite, false, false, ColorHelper.fromFloats(1f, color[0], color[1], color[2]), null, 0);
    }

    @Unique
    private void renderPatternedSide(ModelPart part, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, @Nullable Item item, float[] color) {
        SpriteIdentifier textureId = getPatternIdFromSherd(item);
        if (textureId != null) {
            Sprite sprite = materials.getSprite(textureId);
            queue.submitModelPart(part, matrices, textureId.getRenderLayer(RenderLayer::getEntityTranslucent), light, overlay, sprite, false, false, ColorHelper.fromFloats(1f, color[0], color[1], color[2]), null, 0);
        }
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
