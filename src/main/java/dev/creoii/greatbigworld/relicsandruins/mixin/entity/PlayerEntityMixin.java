package dev.creoii.greatbigworld.relicsandruins.mixin.entity;

import com.mojang.authlib.GameProfile;
import dev.creoii.greatbigworld.relicsandruins.util.TemplateUnlockerPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements TemplateUnlockerPlayer {
    @Unique Set<Item> unlockedTemplates;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gbw$initUnlockedTemplates(World world, BlockPos pos, float yaw, GameProfile gameProfile, CallbackInfo ci) {
        unlockedTemplates = new HashSet<>();
    }

    @Override
    public Set<Item> gbw$getUnlockedTemplates() {
        return unlockedTemplates;
    }

    @Override
    public void gbw$unlockTemplate(Item item) {
        unlockedTemplates.add(item);
    }
}
