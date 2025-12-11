package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.util.stateprovider.EngravedStoneStateProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public final class RelicsAndRuinsBlockStateProviderTypes {
    public static BlockStateProviderType<EngravedStoneStateProvider> ENGRAVED_STONE;

    public static void register() {
        ENGRAVED_STONE = Registry.register(BuiltInRegistries.BLOCKSTATE_PROVIDER_TYPE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "engraved_stone"), new BlockStateProviderType<>(EngravedStoneStateProvider.CODEC));
    }
}
