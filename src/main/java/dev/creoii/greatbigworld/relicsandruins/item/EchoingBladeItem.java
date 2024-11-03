package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.item.UseThroughBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponents;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EchoingBladeItem extends SwordItem implements UseThroughBlock {
    public EchoingBladeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();
        RelicComponent.resetCharge(stack);
        return stack;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (RelicComponent.isCharged(stack)) {
            double distance = 24d;
            Vec3d vec3d = user.getCameraPosVec(1f);
            Vec3d vec3d2 = user.getRotationVec(1f);
            Box box = user.getBoundingBox().stretch(vec3d2.multiply(distance)).expand(1d, 1d, 1d);
            HitResult hitResult = ProjectileUtil.raycast(user, vec3d, vec3d.add(vec3d2.x * distance, vec3d2.y * distance, vec3d2.z * distance), box, (entity) -> {
                return !entity.isSpectator() && entity.canHit();
            }, MathHelper.square(distance));
            if (hitResult != null) {
                if (!world.isClient) {
                    Vec3d vec3d4 = user.getPos().add(0d, 1.600000023841858d, 0d);
                    Vec3d vec3d6 = hitResult.getPos().subtract(vec3d4);
                    for (int i = 0; i < MathHelper.floor(vec3d6.length()); ++i) {
                        Vec3d vec3d5 = vec3d4.add(vec3d6.normalize().multiply(i));
                        ((ServerWorld) world).spawnParticles(ParticleTypes.SONIC_BOOM, vec3d5.x, vec3d5.y, vec3d5.z, 1, 0d, 0d, 0d, 0d);
                    }
                }

                user.playSound(SoundEvents.ENTITY_WARDEN_SONIC_BOOM, 1.5f, 1f);
                world.getOtherEntities(user, Box.of(hitResult.getPos(), 1.2d, 1.2d, 1.2d)).forEach(target -> {
                    for (int i = 0; i < user.getRandom().nextBetween(1, 3); ++i) {
                        target.getWorld().spawnEntity(new ExperienceOrbEntity(target.getWorld(), target.getX(), target.getRandomBodyY(), target.getZ(), 6));
                    }
                    target.damage(target.getDamageSources().sonicBoom(user), 12f);
                });

                RelicComponent.resetCharge(stack);
                if (user instanceof PlayerEntity player) {
                    player.getItemCooldownManager().set(stack.getItem(), 220);
                }
            }
        }
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        RelicComponent relicComponent = stack.get(RelicsAndRuinsDataComponents.RELIC);
        if (relicComponent != null && relicComponent.charge() > 0) {
            return 72000;
        }
        return 0;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        RelicComponent relicComponent = stack.get(RelicsAndRuinsDataComponents.RELIC);
        if (relicComponent != null && relicComponent.charge() > 0) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(stack);
        }
        return TypedActionResult.fail(stack);
    }

    @Override
    public boolean canAttackThroughBlock(PlayerEntity player, ItemStack stack, Entity entity) {
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
         if (!RelicComponent.isCharged(stack)) {
             RelicComponent.incrementCharge(stack);
             attacker.playSound(SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, 1.5f, 1f);
             target.getWorld().spawnEntity(new ExperienceOrbEntity(target.getWorld(), target.getX(), target.getRandomBodyY(), target.getZ(), 2));
        }
        return super.postHit(stack, target, attacker);
    }
}
