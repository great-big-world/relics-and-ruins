package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import dev.creoii.greatbigworld.relicsandruins.util.Relic;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin {
    @Shadow public abstract void fill(RenderLayer layer, int x1, int y1, int x2, int y2, int color);

    @Inject(method = "drawItemInSlot(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isItemBarVisible()Z"))
    private void gbw$renderRelicCharge(TextRenderer textRenderer, ItemStack stack, int x, int y, String countOverride, CallbackInfo ci) {
        if (stack.getItem() instanceof Relic relic && relic.getCharge(stack) > 0) {
            int i = relic.getChargeItemBarStep(stack);
            int k = x + 2;
            int l = y + 14;
            fill(RenderLayer.getGuiOverlay(), k, l, k + 13, l + 2, Colors.BLACK);
            fill(RenderLayer.getGuiOverlay(), k, l, k + i, l + 1, 0xff2fbf3e | Colors.BLACK);
        }
    }
}
