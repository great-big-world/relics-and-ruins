package dev.creoii.greatbigworld.relicsandruins.util;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

public interface ExtendedDecoratedPotRender {
    void gbw$submitDyed(PoseStack matrices, SubmitNodeCollector queue, int light, int overlay, PotDecorations sherds, @Nullable MapColor color, int trim);
}
