package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.util.RelicComponent;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsComponentTypes {
    public static final ComponentType<RelicComponent> RELIC = ComponentType.<RelicComponent>builder().codec(RelicComponent.CODEC).packetCodec(RelicComponent.PACKET_CODEC).cache().build();

    public static void register() {
        Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(GreatBigWorld.NAMESPACE, "relic"), RELIC);
    }
}
