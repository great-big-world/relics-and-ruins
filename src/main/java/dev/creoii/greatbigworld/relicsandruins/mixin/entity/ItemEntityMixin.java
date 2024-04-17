package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import dev.creoii.greatbigworld.relicsandruins.util.Relic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity implements Ownable {
    @Shadow public abstract ItemStack getStack();
    @Shadow public abstract void onPlayerCollision(PlayerEntity player);
    @Shadow private int pickupDelay;

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (getStack().getItem() instanceof Relic && pickupDelay == 0) {
            onPlayerCollision(player);
            return ActionResult.success(player.getWorld().isClient);
        }
        return ActionResult.PASS;
    }
}
