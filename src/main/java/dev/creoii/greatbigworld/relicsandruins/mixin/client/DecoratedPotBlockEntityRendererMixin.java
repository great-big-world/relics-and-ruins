package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedDecoratedPotRender;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.renderer.blockentity.state.DecoratedPotRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.EnumSet;
import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(DecoratedPotRenderer.class)
public abstract class DecoratedPotBlockEntityRendererMixin implements ExtendedDecoratedPotRender {
    @Shadow @Final private ModelPart neck;
    @Shadow @Final private ModelPart top;
    @Shadow @Final private ModelPart bottom;
    @Shadow @Final private ModelPart frontSide;
    @Shadow @Final private ModelPart backSide;
    @Shadow @Final private ModelPart leftSide;
    @Shadow @Final private ModelPart rightSide;
    @Shadow @Final private MaterialSet materials;
    @Unique private static final int BASE_COLOR = 10443081;
    @Unique private static final Material SIDES_SPRITE_ID = new Material(Sheets.DECORATED_POT_SHEET, Identifier.withDefaultNamespace("entity/decorated_pot/decorated_pot_side"));
    @Unique private static final Material BASE_SPRITE_ID = new Material(Sheets.DECORATED_POT_SHEET, Identifier.withDefaultNamespace("entity/decorated_pot/decorated_pot_base"));
    @Unique private ModelPart frontTrim;
    @Unique private ModelPart backTrim;
    @Unique private ModelPart leftTrim;
    @Unique private ModelPart rightTrim;
    @Unique private ModelPart frontPattern;
    @Unique private ModelPart backPattern;
    @Unique private ModelPart leftPattern;
    @Unique private ModelPart rightPattern;

    @Inject(method = "extractRenderState(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;Lnet/minecraft/client/renderer/blockentity/state/DecoratedPotRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V", at = @At("TAIL"))
    private void gbw$updateRenderStateForDyed(DecoratedPotBlockEntity decoratedPotBlockEntity, DecoratedPotRenderState decoratedPotRenderState, float f, Vec3 vec3, ModelFeatureRenderer.CrumblingOverlay crumblingOverlay, CallbackInfo ci) {
        if (decoratedPotBlockEntity instanceof DyedDecoratedPot dyedDecoratedPot && decoratedPotRenderState instanceof DyedDecoratedPot dyedDecoratedPot1) {
            dyedDecoratedPot1.gbw$setColor(dyedDecoratedPot.gbw$getColor());
        }

        if (decoratedPotBlockEntity instanceof TrimmedDecoratedPot trimmedDecoratedPot && decoratedPotRenderState instanceof TrimmedDecoratedPot trimmedDecoratedPot1) {
            trimmedDecoratedPot1.gbw$setTrim(trimmedDecoratedPot.gbw$getTrim());
        }
    }

    @Override
    public void gbw$submitDyed(PoseStack matrices, SubmitNodeCollector queue, int light, int overlay, PotDecorations sherds, @Nullable MapColor color, int trim) {
        float[] rgb;
        if (color != null) {
            rgb = new float[]{red(color.col), green(color.col), blue(color.col)};
        } else rgb = new float[]{red(BASE_COLOR), green(BASE_COLOR), blue(BASE_COLOR)};

        RenderType renderLayer = BASE_SPRITE_ID.renderType(RenderTypes::entitySolid);
        TextureAtlasSprite baseSprite = materials.get(BASE_SPRITE_ID);
        queue.submitModelPart(neck, matrices, renderLayer, light, overlay, baseSprite, false, false, ARGB.colorFromFloat(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        queue.submitModelPart(top, matrices, renderLayer, light, overlay, baseSprite, false, false, ARGB.colorFromFloat(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        queue.submitModelPart(bottom, matrices, renderLayer, light, overlay, baseSprite, false, false, ARGB.colorFromFloat(1f, rgb[0], rgb[1], rgb[2]), null, 0);
        renderSide(frontSide, matrices, queue, light, overlay, rgb);
        renderSide(backSide, matrices, queue, light, overlay, rgb);
        renderSide(leftSide, matrices, queue, light, overlay, rgb);
        renderSide(rightSide, matrices, queue, light, overlay, rgb);

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

        if (isSherdNotBrick(sherds.front())) {
            renderTrimmedSide(frontTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
        }
        if (isSherdNotBrick(sherds.back())) {
            renderTrimmedSide(backTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
        }
        if (isSherdNotBrick(sherds.left())) {
            renderTrimmedSide(leftTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
        }
        if (isSherdNotBrick(sherds.right())) {
            renderTrimmedSide(rightTrim, matrices, queue, light, overlay, getTextureIdFromTrim(trim));
        }
    }

    @Inject(method = "<init>(Lnet/minecraft/client/model/geom/EntityModelSet;Lnet/minecraft/client/resources/model/MaterialSet;)V", at = @At("TAIL"))
    private void gbw$initDecalParts(EntityModelSet entityModelSet, MaterialSet materialSet, CallbackInfo ci, @Local(ordinal = 1) ModelPart modelPart2) {
        this.frontTrim = modelPart2.getChild("front_trim");
        this.backTrim = modelPart2.getChild("back_trim");
        this.leftTrim = modelPart2.getChild("left_trim");
        this.rightTrim = modelPart2.getChild("right_trim");
        this.frontPattern = modelPart2.getChild("front_pattern");
        this.backPattern = modelPart2.getChild("back_pattern");
        this.leftPattern = modelPart2.getChild("left_pattern");
        this.rightPattern = modelPart2.getChild("right_pattern");
    }

    @Inject(method = "submit(Lnet/minecraft/client/renderer/blockentity/state/DecoratedPotRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/CameraRenderState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/DecoratedPotRenderer;submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;IILnet/minecraft/world/level/block/entity/PotDecorations;I)V"), cancellable = true)
    private void gbw$renderPotDecals(DecoratedPotRenderState decoratedPotRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState, CallbackInfo ci) {
        if (decoratedPotRenderState instanceof DyedDecoratedPot dyedDecoratedPot) {
            int trim = ((TrimmedDecoratedPot) decoratedPotRenderState).gbw$getTrim();
            gbw$submitDyed(poseStack, submitNodeCollector, decoratedPotRenderState.lightCoords, OverlayTexture.NO_OVERLAY, decoratedPotRenderState.decorations, dyedDecoratedPot.gbw$getColor(), trim);
            poseStack.popPose();
            ci.cancel();
        }
    }

    @Inject(method = "createSidesLayer", at = @At("RETURN"))
    private static void gbw$addDecalSidesTexturedModelData(CallbackInfoReturnable<LayerDefinition> cir, @Local PartDefinition partDefinition) {
        CubeListBuilder decalBuilder = CubeListBuilder.create().texOffs(1, 0).addBox(-.01f, 0f, -.01f, 14.01f, 16f, .01f, EnumSet.of(Direction.NORTH));
        partDefinition.addOrReplaceChild("back_trim", decalBuilder, PartPose.offsetAndRotation(15f, 16f, 1f, 0f, 0f, (float) Math.PI));
        partDefinition.addOrReplaceChild("left_trim", decalBuilder, PartPose.offsetAndRotation(1f, 16f, 1f, 0f, -1.5707964f, (float) Math.PI));
        partDefinition.addOrReplaceChild("right_trim", decalBuilder, PartPose.offsetAndRotation(15f, 16f, 15f, 0f, 1.5707964f, (float) Math.PI));
        partDefinition.addOrReplaceChild("front_trim", decalBuilder, PartPose.offsetAndRotation(1f, 16f, 15f, (float) Math.PI, 0f, 0f));
        partDefinition.addOrReplaceChild("back_pattern", decalBuilder, PartPose.offsetAndRotation(15f, 16f, 1f, 0f, 0f, (float) Math.PI));
        partDefinition.addOrReplaceChild("left_pattern", decalBuilder, PartPose.offsetAndRotation(1f, 16f, 1f, 0f, -1.5707964f, (float) Math.PI));
        partDefinition.addOrReplaceChild("right_pattern", decalBuilder, PartPose.offsetAndRotation(15f, 16f, 15f, 0f, 1.5707964f, (float) Math.PI));
        partDefinition.addOrReplaceChild("front_pattern", decalBuilder, PartPose.offsetAndRotation(1f, 16f, 15f, (float) Math.PI, 0f, 0f));
    }

    @Unique
    private void renderTrimmedSide(ModelPart part, PoseStack matrices, SubmitNodeCollector queue, int light, int overlay, Material textureId) {
        TextureAtlasSprite sprite = materials.get(textureId);
        queue.submitModelPart(part, matrices, textureId.renderType(RenderTypes::entityTranslucent), light, overlay, sprite, false, false);
    }

    @Unique
    private static Material getTextureIdFromTrim(int trim) {
        return new Material(Sheets.DECORATED_POT_SHEET, Identifier.withDefaultNamespace("entity/decorated_pot/trim/trim" + Mth.clamp(trim, 0, 19)));
    }

    @Unique
    @Nullable
    private static Material getPatternIdFromSherd(Item item) {
        if (item == Items.BRICK)
            return null;
        Material id = Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(item));
        return id == null ? null : new Material(id.atlasLocation(), Identifier.fromNamespaceAndPath(id.texture().getNamespace(), id.texture().getPath().replace("decorated_pot/", "decorated_pot/pattern/").replace("_pottery_pattern", "")));
    }

    @Unique
    private void renderSide(ModelPart part, PoseStack matrices, SubmitNodeCollector queue, int light, int overlay, float[] color) {
        TextureAtlasSprite sprite = materials.get(SIDES_SPRITE_ID);
        queue.submitModelPart(part, matrices, SIDES_SPRITE_ID.renderType(RenderTypes::entitySolid), light, overlay, sprite, false, false, ARGB.colorFromFloat(1f, color[0], color[1], color[2]), null, 0);
    }

    @Unique
    private void renderPatternedSide(ModelPart part, PoseStack matrices, SubmitNodeCollector queue, int light, int overlay, @Nullable Item item, float[] color) {
        Material textureId = getPatternIdFromSherd(item);
        if (textureId != null) {
            TextureAtlasSprite sprite = materials.get(textureId);
            queue.submitModelPart(part, matrices, textureId.renderType(RenderTypes::entityTranslucent), light, overlay, sprite, false, false, ARGB.colorFromFloat(1f, color[0], color[1], color[2]), null, 0);
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
