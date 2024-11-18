package dev.creoii.greatbigworld.relicsandruins.block;

import dev.creoii.greatbigworld.relicsandruins.item.TreasureItem;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import dev.creoii.greatbigworld.relicsandruins.util.TreasureType;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BrazierBlock extends Block implements Waterloggable {
    public static final VoxelShape BASE = Block.createCuboidShape(1d, 0d, 1d, 15d, 4d, 15d);
    public static final VoxelShape BARS_EAST = Block.createCuboidShape(1d, 4d, 1d, 15d, 10d, 1.5d);
    public static final VoxelShape BARS_WEST = Block.createCuboidShape(14.5d, 4d, 1d, 15d, 10d, 15d);
    public static final VoxelShape BARS_NORTH = Block.createCuboidShape(1d, 4d, 14.5d, 15d, 10d, 15d);
    public static final VoxelShape BARS_SOUTH = Block.createCuboidShape(1d, 4d, 1d, 1.5d, 10d, 15d);
    public static final VoxelShape SHAPE = VoxelShapes.union(BASE, BARS_EAST, BARS_WEST, BARS_NORTH, BARS_SOUTH);
    public static final BooleanProperty LIT = Properties.LIT;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<TreasureType> TREASURE = EnumProperty.of("treasure", TreasureType.class);
    private final boolean emitsParticles;
    private final int fireDamage;

    public BrazierBlock(boolean emitsParticles, int fireDamage, Settings settings) {
        super(settings);
        this.emitsParticles = emitsParticles;
        this.fireDamage = fireDamage;
        setDefaultState(getStateManager().getDefaultState().with(LIT, false).with(WATERLOGGED, false).with(TREASURE, TreasureType.EMPTY));
    }

    public static boolean canBeLit(BlockState state) {
        return state.isIn(RelicsAndRuinsTags.BRAZIERS, statex -> {
            return statex.contains(WATERLOGGED) && statex.contains(LIT);
        }) && !state.get(WATERLOGGED) && !state.get(LIT);
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (state.get(LIT) && entity instanceof LivingEntity) {
            entity.damage(world.getDamageSources().campfire(), (float)fireDamage);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldAccess world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        return getDefaultState().with(WATERLOGGED, world.getFluidState(pos).getFluid() == Fluids.WATER);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            if (random.nextInt(10) == 0) {
                world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
            }

            if (emitsParticles && random.nextInt(5) == 0) {
                for(int i = 0; i < random.nextInt(1) + 1; ++i) {
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, (double)(random.nextFloat() / 2.0F), 5.0E-5, (double)(random.nextFloat() / 2.0F));
                }
            }

        }
    }

    public static void extinguish(@Nullable Entity entity, WorldAccess world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            for(int i = 0; i < 20; ++i) {
                spawnSmokeParticle((World)world, pos, true);
            }
        }

        world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
    }

    public static void spawnSmokeParticle(World world, BlockPos pos, boolean lotsOfSmoke) {
        Random random = world.getRandom();
        SimpleParticleType simpleParticleType = ParticleTypes.CAMPFIRE_COSY_SMOKE;
        world.addImportantParticle(simpleParticleType, true, (double)pos.getX() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1), 0.0, 0.07, 0.0);
        if (lotsOfSmoke) {
            world.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4, (double)pos.getZ() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1), 0.0, 0.005, 0.0);
        }
    }

    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.get(Properties.WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
            boolean bl = state.get(LIT);
            if (bl) {
                if (!world.isClient()) {
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                extinguish(null, world, pos, state);
            }

            world.setBlockState(pos, state.with(WATERLOGGED, true).with(LIT, false), 3);
            world.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
            return true;
        } else {
            return false;
        }
    }

    protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        BlockPos blockPos = hit.getBlockPos();
        if (!world.isClient && projectile.isOnFire() && projectile.canModifyAt(world, blockPos) && !state.get(LIT) && !state.get(WATERLOGGED)) {
            world.setBlockState(blockPos, state.with(Properties.LIT, true), 11);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(WATERLOGGED))
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        if (stack.getItem() instanceof TreasureItem treasureItem && state.get(LIT) && state.get(TREASURE) == TreasureType.EMPTY) {
            if (!world.isClient) {
                stack.decrementUnlessCreative(1, player);
                world.setBlockState(pos, state.with(TREASURE, treasureItem.getType()));
            }
            return ItemActionResult.success(world.isClient);
        } else if (stack.isOf(Items.FLINT_AND_STEEL) && canBeLit(state)) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1f, world.getRandom().nextFloat() * .4f + .8f);
            world.setBlockState(pos, state.with(Properties.LIT, true), 11);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (player != null) {
                stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            }
            return ItemActionResult.success(world.isClient);
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    protected FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, WATERLOGGED);
    }
}
