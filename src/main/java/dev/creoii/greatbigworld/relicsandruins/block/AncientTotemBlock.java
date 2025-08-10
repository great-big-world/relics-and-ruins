package dev.creoii.greatbigworld.relicsandruins.block;

import com.mojang.serialization.MapCodec;
import dev.creoii.greatbigworld.relicsandruins.block.entity.AncientTotemBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AncientTotemBlock extends Block implements BlockEntityProvider {
    public static final MapCodec<AncientTotemBlock> CODEC = createCodec(AncientTotemBlock::new);
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public MapCodec<? extends AncientTotemBlock> getCodec() {
        return CODEC;
    }

    public AncientTotemBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AncientTotemBlockEntity(pos, state);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (hit.getSide() != state.get(FACING))
            return ActionResult.PASS;

        Vec3d hitPos = hit.getPos().subtract(pos.getX(), pos.getY(), pos.getZ());
        boolean center = hitPos.x > .25f && hitPos.x < .75f && hitPos.z > .25f && hitPos.z < .75f;

        if (center) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AncientTotemBlockEntity ancientTotemBlockEntity && !ancientTotemBlockEntity.getStack().isEmpty()) {
                if (!world.isClient) {
                    if (!player.giveItemStack(ancientTotemBlockEntity.getStack())) {
                        player.dropStack((ServerWorld) world, ancientTotemBlockEntity.getStack());
                    }
                }
                ancientTotemBlockEntity.setStack(ItemStack.EMPTY);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }
}
