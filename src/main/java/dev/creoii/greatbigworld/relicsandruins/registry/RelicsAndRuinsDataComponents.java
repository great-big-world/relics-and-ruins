package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.relicsandruins.RelicsAndRuins;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.minecraft.component.DataComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsDataComponents {
    public static final DataComponentType<RelicComponent> RELIC = DataComponentType.<RelicComponent>builder().codec(RelicComponent.CODEC).packetCodec(RelicComponent.PACKET_CODEC).cache().build();

    public static void register() {
        Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier(RelicsAndRuins.NAMESPACE, "relic"), RELIC);
    }
}
