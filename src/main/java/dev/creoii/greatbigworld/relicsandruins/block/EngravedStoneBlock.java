package dev.creoii.greatbigworld.relicsandruins.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponentTypes;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public class EngravedStoneBlock extends KnowledgeBlock {
    public static final EnumProperty<Engraving> ENGRAVING = EnumProperty.of("engraving", Engraving.class);
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.of("color", DyeColor.class);

    public EngravedStoneBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(NATURAL, true).with(ENGRAVING, Engraving.ANGLER).with(COLOR, DyeColor.WHITE));
    }

    @Override
    public Pool<Knowledge> getKnowledgePool(BlockState state) {
        return state.get(ENGRAVING).pool;
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack stack = super.getPickStack(world, pos, state, includeData);
        stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, new Data(state.get(ENGRAVING), state.get(COLOR)));
        return stack;
    }

    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootWorldContext.Builder builder) {
        List<ItemStack> stacks = super.getDroppedStacks(state, builder);
        stacks.forEach(stack -> {
            if (stack.isIn(RelicsAndRuinsTags.ENGRAVED_STONE_ITEMS)) {
                stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, new Data(state.get(ENGRAVING), state.get(COLOR)));
            }
        });
        return stacks;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = getDefaultState();
        if (ctx.getStack().contains(RelicsAndRuinsDataComponentTypes.ENGRAVING)) {
            EngravedStoneBlock.Data data = ctx.getStack().get(RelicsAndRuinsDataComponentTypes.ENGRAVING);
            state = state.with(ENGRAVING, data.engraving).with(COLOR, data.color);
        }
        return state.with(NATURAL, ctx.getPlayer().isInCreativeMode());
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem() instanceof DyeItem dyeItem && dyeItem.getColor() != state.get(COLOR)) {
            BlockState newState = state.with(COLOR, dyeItem.getColor());
            world.setBlockState(pos, newState, 11);
            if (!world.isClient())
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) player, pos, stack);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, newState));
            stack.decrementUnlessCreative(1, player);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ENGRAVING, COLOR);
    }

    public enum Engraving implements StringIdentifiable {
        ANGLER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LUCK_OF_THE_SEA)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LURE)).build()),
        ARCHER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.POWER)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PUNCH)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.INFINITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.MULTISHOT)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PIERCING)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.QUICK_CHARGE)).build()),
        ARMS_UP(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.KNOCKBACK)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PROTECTION)).build()),
        BLADE(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SHARPNESS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SMITE)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BANE_OF_ARTHROPODS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.IMPALING)).build()),
        BREWER,
        BURN(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FLAME)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FIRE_ASPECT)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FIRE_PROTECTION)).build()),
        DANGER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.THORNS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BLAST_PROTECTION)).build()),
        EXPLORER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.RIPTIDE)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.RESPIRATION)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.DEPTH_STRIDER)).build()),
        FLOW(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.CHANNELING)).build()),
        FRIEND(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FEATHER_FALLING)).build()),
        GUSTER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.WIND_BURST)).build()),
        HEART(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.MENDING)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BINDING_CURSE)).build()),
        HEARTBREAK(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.VANISHING_CURSE)).build()),
        HOWL(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FROST_WALKER)).build()),
        MINER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.EFFICIENCY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.AQUA_AFFINITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SILK_TOUCH)).build()),
        MOURNER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SWIFT_SNEAK)).build()),
        PLENTY(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LOOTING)).build()),
        PRIZE(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FORTUNE)).build()),
        SCRAPE(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SWEEPING_EDGE)).build()),
        SHEAF(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PROJECTILE_PROTECTION)).build()),
        SHELTER(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.UNBREAKING)).build()),
        SKULL(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.DENSITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BREACH)).build()),
        SNORT(Pool.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SOUL_SPEED)).build());

        public static final Codec<Engraving> CODEC = StringIdentifiable.createCodec(Engraving::values);
        private final Pool<Knowledge> pool;

        Engraving(Pool<Knowledge> pool) {
            this.pool = pool;
        }

        Engraving() {
            this.pool = Pool.<Knowledge>builder().build();
        }

        public Pool<Knowledge> getPool() {
            return pool;
        }

        @Override
        public String asString() {
            return name().toLowerCase();
        }
    }

    public record Data(Engraving engraving, DyeColor color) {
        public static final Codec<Data> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(
                    Engraving.CODEC.fieldOf("engraving").forGetter(Data::engraving),
                    DyeColor.CODEC.fieldOf("color").forGetter(Data::color)
            ).apply(instance, Data::new);
        });
        public static final PacketCodec<RegistryByteBuf, Data> PACKET_CODEC = PacketCodec.of(Data::write, Data::read);

        public void write(RegistryByteBuf buf) {
            buf.writeInt(engraving.ordinal());
            buf.writeInt(color.ordinal());
        }

        public static Data read(RegistryByteBuf buf) {
            Engraving engraving = Engraving.values()[buf.readInt()];
            DyeColor color = DyeColor.values()[buf.readInt()];
            return new Data(engraving, color);
        }
    }
}
