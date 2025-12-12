package dev.creoii.greatbigworld.relicsandruins.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.util.ExtendedDecoratedPotRender;
import dev.creoii.greatbigworld.util.ColorHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3fc;

import java.util.Objects;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public record DyedDecoratedPotModelRenderer(DecoratedPotRenderer blockEntityRenderer, DyeColor color) implements SpecialModelRenderer<PotDecorations> {
    @Override
    public void submit(@Nullable PotDecorations object, ItemDisplayContext itemDisplayContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i, int j, boolean bl, int k) {
        if (blockEntityRenderer instanceof ExtendedDecoratedPotRender extendedDecoratedPotRender) {
            extendedDecoratedPotRender.gbw$submitDyed(poseStack, submitNodeCollector, i, j, Objects.requireNonNullElse(object, PotDecorations.EMPTY), color == null ? null : ColorHelper.getTerracottaColor(color), 0);
        } else {
            blockEntityRenderer.submit(poseStack, submitNodeCollector, i, j, Objects.requireNonNullElse(object, PotDecorations.EMPTY), k);
        }
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        blockEntityRenderer.getExtents(consumer);
    }

    @Override
    public PotDecorations extractArgument(ItemStack itemStack) {
        return itemStack.get(DataComponents.POT_DECORATIONS);
    }

    @Environment(EnvType.CLIENT)
    public record Unbaked(DyeColor color) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<Unbaked> CODEC = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(DyeColor.CODEC.fieldOf("color").orElse(null).forGetter(unbaked -> unbaked.color)).apply(instance, Unbaked::new);
        });

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> type() {
            return CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(BakingContext bakingContext) {
            return new DyedDecoratedPotModelRenderer(new DecoratedPotRenderer(bakingContext), color);
        }
    }
}