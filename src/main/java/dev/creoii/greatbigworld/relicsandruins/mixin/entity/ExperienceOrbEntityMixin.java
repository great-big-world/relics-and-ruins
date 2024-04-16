package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsItems;
import net.minecraft.enchantment.Enchantment;
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
import java.util.function.Predicate;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    @Redirect(method = "repairPlayerGears", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;chooseEquipmentWith(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/entity/LivingEntity;Ljava/util/function/Predicate;)Ljava/util/Map$Entry;"))
    private Map.Entry<EquipmentSlot, ItemStack> gbw$repairAnyItem(Enchantment enchantment, LivingEntity entity, Predicate<ItemStack> condition) {
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
                    return entry;
                }
            }
        }
        return null;
    }
}
