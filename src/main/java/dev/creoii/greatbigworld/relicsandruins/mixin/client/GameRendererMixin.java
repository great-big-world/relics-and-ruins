package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final
    MinecraftClient client;

    @Inject(method = "updateCrosshairTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiler/Profiler;pop()V"))
    private void gbw$debug(float tickDelta, CallbackInfo ci) {
        if (client.targetedEntity != null)
            System.out.println(client.targetedEntity.getType().getTranslationKey());
    }
}
