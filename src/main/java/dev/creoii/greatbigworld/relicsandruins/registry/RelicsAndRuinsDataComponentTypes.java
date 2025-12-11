package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public final class RelicsAndRuinsDataComponentTypes {
    public static DataComponentType<EngravedStoneBlock.Data> ENGRAVING;

    public static void register() {
        ENGRAVING = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraving"), DataComponentType.<EngravedStoneBlock.Data>builder().persistent(EngravedStoneBlock.Data.CODEC).networkSynchronized(EngravedStoneBlock.Data.PACKET_CODEC).build());
    }
}
