package dev.creoii.greatbigworld.relicsandruins.client.render;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedDecoratedPotRender;
import dev.creoii.greatbigworld.util.ColorHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.render.block.entity.DecoratedPotBlockEntityRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Objects;
import java.util.Set;

@Environment(EnvType.CLIENT)
public record DyedDecoratedPotModelRenderer(DecoratedPotBlockEntityRenderer blockEntityRenderer, DyeColor color) implements SpecialModelRenderer<Sherds> {
    @Nullable
    public Sherds getData(ItemStack itemStack) {
        return itemStack.get(DataComponentTypes.POT_DECORATIONS);
    }

    @Override
    public void render(@Nullable Sherds data, ItemDisplayContext displayContext, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, boolean glint, int i) {
        if (blockEntityRenderer instanceof ExtendedDecoratedPotRender extendedDecoratedPotRender) {
            extendedDecoratedPotRender.gbw$renderDyed(matrices, queue, light, overlay, Objects.requireNonNullElse(data, Sherds.DEFAULT), color == null ? null : ColorHelper.getTerracottaColor(color), 0);
        }
    }

    @Override
    public void collectVertices(Set<Vector3f> vertices) {
        blockEntityRenderer.collectVertices(vertices);
    }

    @Environment(EnvType.CLIENT)
    public record Unbaked(@Nullable DyeColor color) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<Unbaked> CODEC = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(DyeColor.CODEC.fieldOf("color").orElse(null).forGetter(unbaked -> unbaked.color)).apply(instance, Unbaked::new);
        });

        public MapCodec<Unbaked> getCodec() {
            return CODEC;
        }

        @Override
        public @Nullable SpecialModelRenderer<?> bake(BakeContext context) {
            return new DyedDecoratedPotModelRenderer(new DecoratedPotBlockEntityRenderer(context), color);
        }
    }
}