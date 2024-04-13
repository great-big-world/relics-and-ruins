package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.creoapi.api.item.CreoItem;
import dev.creoii.greatbigworld.relicsandruins.util.Relic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EchoingBladeItem extends SwordItem implements CreoItem, Relic {
    public EchoingBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        resetCharge(stack);
        return stack;
    }

    @Override
    public int getMaxCharge() {
        return 7;
    }

    @Override
    public void onAttackThroughBlock(ServerPlayerEntity player, ItemStack stack, Entity target) {
        Vec3d vec3d = player.getPos().add(0d, 1.600000023841858d, 0d);
        Vec3d vec3d2 = target.getEyePos().subtract(vec3d);
        for (int i = 0; i < MathHelper.floor(vec3d2.length()); ++i) {
            Vec3d vec3d4 = vec3d.add(vec3d2.normalize().multiply(i));
            player.getServerWorld().spawnParticles(ParticleTypes.SONIC_BOOM, vec3d4.x, vec3d4.y, vec3d4.z, 1, 0d, 0d, 0d, 0d);
        }

        player.getWorld().playSoundFromEntity(target, SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 1f, 1f);
        resetCharge(stack);
    }

    @Override
    public boolean canAttackThroughBlock(ServerPlayerEntity player, ItemStack stack, Entity entity) {
        return isCharged(stack);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        incrementCharge(stack);
        attacker.getWorld().playSoundFromEntity(attacker, SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.PLAYERS, 1f, 1f);
        return super.postHit(stack, target, attacker);
    }
}
