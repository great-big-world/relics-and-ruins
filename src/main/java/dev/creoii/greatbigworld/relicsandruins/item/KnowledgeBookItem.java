package dev.creoii.greatbigworld.relicsandruins.item;

import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeComponent;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.registry.GBWDataComponentTypes;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.*;

public class KnowledgeBookItem extends Item {
    public KnowledgeBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient() && stack.contains(GBWDataComponentTypes.KNOWLEDGE)) {
            KnowledgeManager manager = KnowledgeManager.getServerState(world.getServer());
            KnowledgeComponent knowledgeComponent = stack.get(GBWDataComponentTypes.KNOWLEDGE);

            Map<Knowledge.Type, Set<Knowledge>> toSync = new HashMap<>();

            for (Knowledge knowledge : knowledgeComponent.knowledge()) {
                if (manager.learn(user, knowledge)) {
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
                ServerPlayNetworking.send((ServerPlayerEntity) user, new LearnKnowledgeS2C(type, toSync.get(type)));
            }
            return toSync.isEmpty() ? ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION : ActionResult.SUCCESS_SERVER;
        }

        return super.use(world, user, hand);
    }
}
