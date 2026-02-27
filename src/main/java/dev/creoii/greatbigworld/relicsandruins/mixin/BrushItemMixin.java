package dev.creoii.greatbigworld.relicsandruins.mixin;

import com.google.common.collect.Sets;
import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.block.KnowledgeBlock;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.block.entity.KnowledgeBlockEntity;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.Set;

@Mixin(BrushItem.class)
public class BrushItemMixin {
    @Inject(method = "onUseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;)V", shift = At.Shift.AFTER))
    private void gbw$brushCavePaintings(Level level, LivingEntity livingEntity, ItemStack itemStack, int i, CallbackInfo ci, @Local Player player, @Local(ordinal = 1) int j, @Local BlockState blockState, @Local BlockPos blockPos) {
        if (!level.isClientSide() && j > 40 && blockState.hasProperty(KnowledgeBlock.NATURAL) && blockState.getValue(KnowledgeBlock.NATURAL)) {
            Block block = blockState.getBlock();
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (block instanceof EngravedStoneBlock engravedStoneBlock && blockEntity instanceof KnowledgeBlockEntity knowledgeBlockEntity) {
                if (knowledgeBlockEntity.hasPlayerLearned(player))
                    return;

                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(level.getServer());
                Optional<Knowledge> knowledge = knowledgeBlockEntity.getKnowledge() != null ? Optional.of(knowledgeBlockEntity.getKnowledge()) : engravedStoneBlock.getKnowledgePool(blockState).getRandom(level.random);
                if (knowledge.isPresent()) {
                    if (knowledgeManager.learn(player, knowledge.get())) {
                        ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(knowledge.get().type(), Sets.newHashSet(knowledge.get())));

                        EquipmentSlot equipmentSlot = itemStack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                        itemStack.hurtAndBreak(1, player, equipmentSlot);

                        knowledgeBlockEntity.setKnowledge(knowledge.get());
                        knowledgeBlockEntity.setPlayerLearned(player);
                    } else {
                        Set<Knowledge> knowledges = knowledgeManager.getPlayerKnowledge(player, knowledge.get().type());
                        if (knowledges != null && knowledges.contains(knowledge.get())) {
                            knowledgeBlockEntity.setPlayerLearned(player);
                        }
                    }
                }
            }
        }
    }
}