package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    @Shadow @Final public static Identifier CHEST_ATLAS_TEXTURE;
    @Unique
    private static final Map<WoodType, SpriteIdentifier[]> CHEST_SPRITES = ImmutableMap.<WoodType, SpriteIdentifier[]>builder()
            .put(WoodType.OAK, new SpriteIdentifier[]{createChestTextureId("oak"), createChestTextureId("oak_left"), createChestTextureId("oak_right")})
            .put(WoodType.SPRUCE, new SpriteIdentifier[]{createChestTextureId("spruce"), createChestTextureId("spruce_left"), createChestTextureId("spruce_right")})
            .put(WoodType.BIRCH, new SpriteIdentifier[]{createChestTextureId("birch"), createChestTextureId("birch_left"), createChestTextureId("birch_right")})
            .put(WoodType.JUNGLE, new SpriteIdentifier[]{createChestTextureId("jungle"), createChestTextureId("jungle_left"), createChestTextureId("jungle_right")})
            .put(WoodType.DARK_OAK, new SpriteIdentifier[]{createChestTextureId("dark_oak"), createChestTextureId("dark_oak_left"), createChestTextureId("dark_oak_right")})
            .put(WoodType.ACACIA, new SpriteIdentifier[]{createChestTextureId("acacia"), createChestTextureId("acacia_left"), createChestTextureId("acacia_right")})
            .put(WoodType.MANGROVE, new SpriteIdentifier[]{createChestTextureId("mangrove"), createChestTextureId("mangrove_left"), createChestTextureId("mangrove_right")})
            .put(WoodType.CHERRY, new SpriteIdentifier[]{createChestTextureId("cherry"), createChestTextureId("cherry_left"), createChestTextureId("cherry_right")})
            .put(WoodType.BAMBOO, new SpriteIdentifier[]{createChestTextureId("bamboo"), createChestTextureId("bamboo_left"), createChestTextureId("bamboo_right")})
            .put(WoodType.CRIMSON, new SpriteIdentifier[]{createChestTextureId("crimson"), createChestTextureId("crimson_left"), createChestTextureId("crimson_right")})
            .put(WoodType.WARPED, new SpriteIdentifier[]{createChestTextureId("warped"), createChestTextureId("warped_left"), createChestTextureId("warped_right")})
            .build();

    @Redirect(method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TexturedRenderLayers;getChestTextureId(Lnet/minecraft/block/enums/ChestType;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/util/SpriteIdentifier;", ordinal = 2))
    private static SpriteIdentifier gbw$renderChestVariants(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right, @Local(argsOnly = true) BlockEntity blockEntity) {
        if (blockEntity.getCachedState().getBlock() instanceof ChestBlock chestBlock) {
            return CHEST_SPRITES.get(chestBlock.getWoodType())[type == ChestType.SINGLE ? 0 : type == ChestType.LEFT ? 1 : 2];
        }
        return single;
    }

    @Unique
    private static SpriteIdentifier createChestTextureId(String variant) {
        return new SpriteIdentifier(CHEST_ATLAS_TEXTURE, new Identifier(GreatBigWorld.NAMESPACE, "entity/chest/" + variant));
    }
}
