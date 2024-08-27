package dev.creoii.greatbigworld.relicsandruins.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

import java.util.Map;
import java.util.function.Supplier;

public class ChestBlock extends net.minecraft.block.ChestBlock {
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
    private final WoodType woodType;

    public ChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier, WoodType woodType) {
        super(settings, supplier);
        this.woodType = woodType;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public static Map<WoodType, SpriteIdentifier[]> getChestSprites() {
        return CHEST_SPRITES;
    }
}
