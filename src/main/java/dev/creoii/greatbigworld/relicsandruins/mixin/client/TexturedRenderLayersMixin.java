package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    private static final Map<WoodType, SpriteIdentifier[]> CHEST_SPRITES = ImmutableMap.<WoodType, SpriteIdentifier[]>builder()
            .put(WoodType.OAK, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("oak"), TexturedRenderLayers.createChestTextureId("oak_left"), TexturedRenderLayers.createChestTextureId("oak_right")})
            .put(WoodType.SPRUCE, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("spruce"), TexturedRenderLayers.createChestTextureId("spruce_left"), TexturedRenderLayers.createChestTextureId("spruce_right")})
            .put(WoodType.BIRCH, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("birch"), TexturedRenderLayers.createChestTextureId("birch_left"), TexturedRenderLayers.createChestTextureId("birch_right")})
            .put(WoodType.JUNGLE, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("jungle"), TexturedRenderLayers.createChestTextureId("jungle_left"), TexturedRenderLayers.createChestTextureId("jungle_right")})
            .put(WoodType.DARK_OAK, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("dark_oak"), TexturedRenderLayers.createChestTextureId("dark_oak_left"), TexturedRenderLayers.createChestTextureId("dark_oak_right")})
            .put(WoodType.ACACIA, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("acacia"), TexturedRenderLayers.createChestTextureId("acacia_left"), TexturedRenderLayers.createChestTextureId("acacia_right")})
            .put(WoodType.MANGROVE, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("mangrove"), TexturedRenderLayers.createChestTextureId("mangrove_left"), TexturedRenderLayers.createChestTextureId("mangrove_right")})
            .put(WoodType.CHERRY, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("cherry"), TexturedRenderLayers.createChestTextureId("cherry_left"), TexturedRenderLayers.createChestTextureId("cherry_right")})
            .put(WoodType.BAMBOO, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("bamboo"), TexturedRenderLayers.createChestTextureId("bamboo_left"), TexturedRenderLayers.createChestTextureId("bamboo_right")})
            .put(WoodType.CRIMSON, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("crimson"), TexturedRenderLayers.createChestTextureId("crimson_left"), TexturedRenderLayers.createChestTextureId("crimson_right")})
            .put(WoodType.WARPED, new SpriteIdentifier[]{TexturedRenderLayers.createChestTextureId("warped"), TexturedRenderLayers.createChestTextureId("warped_left"), TexturedRenderLayers.createChestTextureId("warped_right")})
            .build();

    @Redirect(method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TexturedRenderLayers;getChestTextureId(Lnet/minecraft/block/enums/ChestType;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/util/SpriteIdentifier;", ordinal = 2))
    private static SpriteIdentifier gbw$renderChestVariants(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right, @Local(argsOnly = true) BlockEntity blockEntity) {
        if (blockEntity.getCachedState().getBlock() instanceof ChestBlock chestBlock) {
            return CHEST_SPRITES.get(chestBlock.getWoodType())[type == ChestType.SINGLE ? 0 : type == ChestType.LEFT ? 1 : 2];
        }
        return single;
    }
}
