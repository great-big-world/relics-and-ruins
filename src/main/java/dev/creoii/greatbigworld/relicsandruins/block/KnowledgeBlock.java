package dev.creoii.greatbigworld.relicsandruins.block;

import com.google.common.collect.Sets;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class KnowledgeBlock extends Block {
    public static final BooleanProperty NATURAL = BooleanProperty.of("natural");

    public KnowledgeBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(NATURAL, true));
    }

    public abstract Pool<Knowledge> getKnowledgePool(BlockState state);

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient() && state.get(NATURAL) && player.getStackInHand(player.getActiveHand()).isEmpty()) {
            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Knowledge knowledge = getKnowledgePool(state).get(world.random);
            if (knowledgeManager.learn(player, knowledge)) {
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(knowledge.type(), Sets.newHashSet(knowledge)));
                return ActionResult.SUCCESS_SERVER;
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NATURAL);
    }
}
