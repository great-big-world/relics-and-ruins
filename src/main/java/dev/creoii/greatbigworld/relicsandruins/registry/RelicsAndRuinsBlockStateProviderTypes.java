package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.util.stateprovider.EngravedStoneStateProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;

public final class RelicsAndRuinsBlockStateProviderTypes {
    public static BlockStateProviderType<EngravedStoneStateProvider> ENGRAVED_STONE;

    public static void register() {
        ENGRAVED_STONE = Registry.register(Registries.BLOCK_STATE_PROVIDER_TYPE, Identifier.of(GreatBigWorld.NAMESPACE, "engraved_stone"), new BlockStateProviderType<>(EngravedStoneStateProvider.CODEC));
    }
}
