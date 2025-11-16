package dev.creoii.greatbigworld.relicsandruins.util;

import net.minecraft.block.MapColor;
import net.minecraft.block.entity.Sherds;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.Nullable;

public interface ExtendedDecoratedPotRender {
    void gbw$renderDyed(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, Sherds sherds, @Nullable MapColor color, int trim);
}
