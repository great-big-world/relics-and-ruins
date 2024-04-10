package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.relicsandruins.util.XrayAttack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EchoingBladeItem extends SwordItem implements XrayAttack {
    public EchoingBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onAttackThroughBlock(MinecraftClient client, ItemStack stack, Entity entity) {
        Vec3d vec3d = client.player.getPos().add(0d, 1.600000023841858d, 0d);
        Vec3d vec3d2 = entity.getEyePos().subtract(vec3d);
        for (int i = 0; i < MathHelper.floor(vec3d2.length()); ++i) {
            Vec3d vec3d4 = vec3d.add(vec3d2.normalize().multiply(i));
            client.world.addParticle(ParticleTypes.SONIC_BOOM, vec3d4.x, vec3d4.y, vec3d4.z, 0d, 0d, 0d);
        }
    }
}
