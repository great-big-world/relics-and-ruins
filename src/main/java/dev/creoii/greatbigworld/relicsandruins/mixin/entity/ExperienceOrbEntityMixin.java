package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    @Redirect(method = "repairPlayerGears", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;chooseEquipmentWith(Lnet/minecraft/component/ComponentType;Lnet/minecraft/entity/LivingEntity;Ljava/util/function/Predicate;)Ljava/util/Optional;"))
    private Optional<EnchantmentEffectContext> gbw$repairAnyItem(ComponentType<?> componentType, LivingEntity entity, Predicate<ItemStack> stackPredicate) {
        boolean canMend = entity instanceof PlayerEntity player && player.getInventory().containsAny(stack -> stack.isOf(RelicsAndRuinsItems.MENDSTONE));
        Map<EquipmentSlot, ItemStack> stacks = new HashMap<>();
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            ItemStack stack = entity.getEquippedStack(equipmentSlot);
            if (stack.isOf(RelicsAndRuinsItems.MENDSTONE))
                canMend = true;
            stacks.put(equipmentSlot, stack);
        }
        if (canMend) {
            for (Map.Entry<EquipmentSlot, ItemStack> entry : stacks.entrySet()) {
                if (!entry.getValue().isEmpty() && entry.getValue().isDamaged()) {
                    return Optional.of(new EnchantmentEffectContext(entry.getValue(), entry.getKey(), entity));
                }
            }
        }
        return null;
    }
}
