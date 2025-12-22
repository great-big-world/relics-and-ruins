package dev.creoii.greatbigworld.relicsandruins.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.block.KnowledgeBlock;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponentTypes;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.*;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.commons.lang3.StringUtils;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class EngravedStoneBlock extends KnowledgeBlock {
    public static final EnumProperty<Engraving> ENGRAVING = EnumProperty.create("engraving", Engraving.class);
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public EngravedStoneBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState().setValue(NATURAL, true).setValue(ENGRAVING, Engraving.ANGLER).setValue(COLOR, DyeColor.WHITE));
    }

    @Override
    public WeightedList<Knowledge> getKnowledgePool(BlockState state) {
        return state.getValue(ENGRAVING).pool;
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        ItemStack stack = super.getCloneItemStack(levelReader, blockPos, blockState, bl);
        stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, new Data(blockState.getValue(ENGRAVING), blockState.getValue(COLOR)));
        return stack;
    }

    @Override
    protected List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        List<ItemStack> stacks = super.getDrops(blockState, builder);
        stacks.forEach(stack -> {
            if (stack.is(RelicsAndRuinsTags.ENGRAVED_STONE_ITEMS)) {
                stack.set(RelicsAndRuinsDataComponentTypes.ENGRAVING, new Data(blockState.getValue(ENGRAVING), blockState.getValue(COLOR)));
            }
        });
        return stacks;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState state = defaultBlockState();
        if (blockPlaceContext.getItemInHand().has(RelicsAndRuinsDataComponentTypes.ENGRAVING)) {
            EngravedStoneBlock.Data data = blockPlaceContext.getItemInHand().get(RelicsAndRuinsDataComponentTypes.ENGRAVING);
            state = state.setValue(ENGRAVING, data.engraving).setValue(COLOR, data.color);
        }
        return state.setValue(NATURAL, blockPlaceContext.getPlayer().isCreative());
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (stack.getItem() instanceof DyeItem dyeItem && dyeItem.getDyeColor() != state.getValue(COLOR)) {
            BlockState newState = state.setValue(COLOR, dyeItem.getDyeColor());
            world.setBlock(pos, newState, 11);
            if (!world.isClientSide())
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            stack.consume(1, player);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ENGRAVING, COLOR);
    }

    public enum Engraving implements StringRepresentable {
        ANGLER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LUCK_OF_THE_SEA)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LURE)).build()),
        ARCHER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.POWER)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PUNCH)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.INFINITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.MULTISHOT)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PIERCING)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.QUICK_CHARGE)).build()),
        ARMS_UP(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.KNOCKBACK)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PROTECTION)).build()),
        BLADE(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SHARPNESS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SMITE)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BANE_OF_ARTHROPODS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.IMPALING)).build()),
        BREWER,
        BURN(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FLAME)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FIRE_ASPECT)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FIRE_PROTECTION)).build()),
        DANGER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.THORNS)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BLAST_PROTECTION)).build()),
        EXPLORER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.RIPTIDE)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.RESPIRATION)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.DEPTH_STRIDER)).build()),
        FLOW(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.CHANNELING)).build()),
        FRIEND(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FEATHER_FALLING)).build()),
        GUSTER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.WIND_BURST)).build()),
        HEART(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.MENDING)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BINDING_CURSE)).build()),
        HEARTBREAK(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.VANISHING_CURSE)).build()),
        HOWL(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FROST_WALKER)).build()),
        MINER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.EFFICIENCY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.AQUA_AFFINITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SILK_TOUCH)).build()),
        MOURNER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SWIFT_SNEAK)).build()),
        PLENTY(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.LOOTING)).build()),
        PRIZE(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.FORTUNE)).build()),
        SCRAPE(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SWEEPING_EDGE)).build()),
        SHEAF(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.PROJECTILE_PROTECTION)).build()),
        SHELTER(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.UNBREAKING)).build()),
        SKULL(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.DENSITY)).add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.BREACH)).build()),
        SNORT(WeightedList.<Knowledge>builder().add(new Knowledge(Knowledge.Type.ENCHANTMENT, Enchantments.SOUL_SPEED)).build());

        public static final Codec<Engraving> CODEC = StringRepresentable.fromValues(Engraving::values);
        private final WeightedList<Knowledge> pool;

        Engraving(WeightedList<Knowledge> pool) {
            this.pool = pool;
        }

        Engraving() {
            this.pool = WeightedList.<Knowledge>builder().build();
        }

        public WeightedList<Knowledge> getPool() {
            return pool;
        }

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }
    }

    public record Data(Engraving engraving, DyeColor color) implements TooltipProvider {
        public static final Codec<Data> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(
                    Engraving.CODEC.fieldOf("engraving").forGetter(Data::engraving),
                    DyeColor.CODEC.fieldOf("color").orElse(DyeColor.WHITE).forGetter(Data::color)
            ).apply(instance, Data::new);
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, Data> PACKET_CODEC = StreamCodec.ofMember(Data::write, Data::read);

        public void write(RegistryFriendlyByteBuf buf) {
            buf.writeInt(engraving.ordinal());
            buf.writeInt(color.ordinal());
        }

        public static Data read(RegistryFriendlyByteBuf buf) {
            Engraving engraving = Engraving.values()[buf.readInt()];
            DyeColor color = DyeColor.values()[buf.readInt()];
            return new Data(engraving, color);
        }

        @Override
        public void addToTooltip(net.minecraft.world.item.Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag, DataComponentGetter dataComponentGetter) {
            consumer.accept(Component.translatable("item.engraving", StringUtils.capitalize(engraving.getSerializedName())).withStyle(ChatFormatting.GRAY));
        }
    }
}
