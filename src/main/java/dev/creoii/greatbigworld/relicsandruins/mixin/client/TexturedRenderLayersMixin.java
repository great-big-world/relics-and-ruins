package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.relicsandruins.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayersMixin {
    @Redirect(method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TexturedRenderLayers;getChestTextureId(Lnet/minecraft/block/enums/ChestType;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;Lnet/minecraft/client/util/SpriteIdentifier;)Lnet/minecraft/client/util/SpriteIdentifier;", ordinal = 2))
    private static SpriteIdentifier gbw$renderChestVariants(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right, @Local(argsOnly = true) BlockEntity blockEntity) {
        if (blockEntity.getCachedState().getBlock() instanceof ChestBlock chestBlock) {
            return ChestBlock.getChestSprites().get(chestBlock.getWoodType())[type == ChestType.SINGLE ? 0 : type == ChestType.LEFT ? 1 : 2];
        }
        return single;
    }
}
