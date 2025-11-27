package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsDataComponentTypes {
    public static ComponentType<EngravedStoneBlock.Data> ENGRAVING;

    public static void register() {
        ENGRAVING = Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(GreatBigWorld.NAMESPACE, "engraving"), ComponentType.<EngravedStoneBlock.Data>builder().codec(EngravedStoneBlock.Data.CODEC).packetCodec(EngravedStoneBlock.Data.PACKET_CODEC).build());
    }
}
