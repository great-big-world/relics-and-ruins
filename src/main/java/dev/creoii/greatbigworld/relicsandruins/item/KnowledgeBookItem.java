package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeComponent;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.registry.GBWDataComponentTypes;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;

public class KnowledgeBookItem extends Item {
    public KnowledgeBookItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);

        if (!level.isClientSide() && stack.has(GBWDataComponentTypes.KNOWLEDGE)) {
            KnowledgeManager manager = KnowledgeManager.getServerState(level.getServer());
            KnowledgeComponent knowledgeComponent = stack.get(GBWDataComponentTypes.KNOWLEDGE);

            Map<Knowledge.Type, Set<Knowledge>> toSync = new HashMap<>();

            for (Knowledge knowledge : knowledgeComponent.knowledge()) {
                if (manager.learn(player, knowledge)) {
                    if (toSync.containsKey(knowledge.type())) {
                        toSync.get(knowledge.type()).add(knowledge);
                    } else {
                        Set<Knowledge> knowledgeSet = new HashSet<>();
                        knowledgeSet.add(knowledge);
                        toSync.put(knowledge.type(), knowledgeSet);
                    }
                }
            }

            for (Knowledge.Type type : toSync.keySet()) {
                ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(type, toSync.get(type)));
            }
            return toSync.isEmpty() ? InteractionResult.TRY_WITH_EMPTY_HAND : InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, interactionHand);
    }
}
