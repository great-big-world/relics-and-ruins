package dev.creoii.greatbigworld.relicsandruins.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public record RelicComponent(int charge, int maxCharge, Optional<BlockPos> origin) {
    public static final Codec<RelicComponent> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                Codecs.POSITIVE_INT.fieldOf("charge").forGetter(RelicComponent::charge),
                Codecs.POSITIVE_INT.fieldOf("max_charge").forGetter(RelicComponent::maxCharge),
                BlockPos.CODEC.optionalFieldOf("origin").orElse(Optional.empty()).forGetter(RelicComponent::origin)
        ).apply(instance, RelicComponent::new);
    });
    public static final PacketCodec<RegistryByteBuf, RelicComponent> PACKET_CODEC = PacketCodec.tuple(
            PacketCodecs.VAR_INT, RelicComponent::charge,
            PacketCodecs.VAR_INT, RelicComponent::maxCharge,
            PacketCodecs.optional(BlockPos.PACKET_CODEC), RelicComponent::origin,
            RelicComponent::new);

    public static void setOrigin(ItemStack stack, BlockPos pos) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            stack.set(RelicsAndRuinsComponentTypes.RELIC, new RelicComponent(component.charge(), component.maxCharge(), Optional.of(pos)));
        }
    }

    @Nullable
    public static BlockPos getOrigin(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null && component.origin().isPresent()) {
            return component.origin().get();
        }
        return null;
    }

    public static int getChargeItemBarStep(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            return Math.round(((float) getCharge(stack) / component.maxCharge()) * 13);
        }
        return -1;
    }

    public static int getCharge(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            return component.charge();
        }
        return -1;
    }

    public static void incrementCharge(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            stack.set(RelicsAndRuinsComponentTypes.RELIC, new RelicComponent(Math.min(component.maxCharge(), component.charge() + 1), component.maxCharge(), component.origin()));
        }
    }

    public static void resetCharge(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            stack.set(RelicsAndRuinsComponentTypes.RELIC, new RelicComponent(0, component.maxCharge(), component.origin()));
        }
    }

    public static boolean isCharged(ItemStack stack) {
        RelicComponent component = stack.get(RelicsAndRuinsComponentTypes.RELIC);
        if (component != null) {
            return component.charge() >= component.maxCharge();
        }
        return false;
    }
}
