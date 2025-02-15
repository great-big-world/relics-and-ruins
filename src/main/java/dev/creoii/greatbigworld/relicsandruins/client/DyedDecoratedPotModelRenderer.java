package dev.creoii.greatbigworld.relicsandruins.client;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedDecoratedPotRender;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class DyedDecoratedPotModelRenderer implements SpecialModelRenderer<Sherds> {
    private final DecoratedPotBlockEntityRenderer blockEntityRenderer;
    private final DyeColor color;

    public DyedDecoratedPotModelRenderer(DecoratedPotBlockEntityRenderer blockEntityRenderer, DyeColor color) {
        this.blockEntityRenderer = blockEntityRenderer;
        this.color = color;
    }

    @Nullable
    public Sherds getData(ItemStack itemStack) {
        return itemStack.get(DataComponentTypes.POT_DECORATIONS);
    }

    public void render(@Nullable Sherds sherds, ModelTransformationMode modelTransformationMode, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, boolean bl) {
        if (blockEntityRenderer instanceof ExtendedDecoratedPotRender extendedDecoratedPotRender) {
            extendedDecoratedPotRender.gbw$renderDyed(matrixStack, vertexConsumerProvider, i, j, Objects.requireNonNullElse(sherds, Sherds.DEFAULT), color.getMapColor(), 0);
        }
    }

    @Environment(EnvType.CLIENT)
    public record Unbaked(DyeColor color) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<DyedDecoratedPotModelRenderer.Unbaked> CODEC = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(DyeColor.CODEC.fieldOf("color").forGetter(unbaked -> unbaked.color)).apply(instance, Unbaked::new);
        });

        public MapCodec<DyedDecoratedPotModelRenderer.Unbaked> getCodec() {
            return CODEC;
        }

        public SpecialModelRenderer<?> bake(LoadedEntityModels entityModels) {
            return new DyedDecoratedPotModelRenderer(new DecoratedPotBlockEntityRenderer(entityModels), color);
        }
    }
}