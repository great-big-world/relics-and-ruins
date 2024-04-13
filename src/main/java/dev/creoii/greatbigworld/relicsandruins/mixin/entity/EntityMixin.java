package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow protected abstract Text getDefaultName();

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void gbw$obfuscateNameForRogueishHood(CallbackInfoReturnable<Text> cir) {
        if ((Entity) (Object) this instanceof LivingEntity living && living.getEquippedStack(EquipmentSlot.HEAD).isOf(RelicsAndRuinsItems.ROGUEISH_HOOD)) {
            cir.setReturnValue(MutableText.of(getDefaultName().getContent()).formatted(Formatting.OBFUSCATED));
        }
    }
}
