package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.util.lootfunction.RandomKnowledgeLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RelicsAndRuinsLootFunctionTypes {
    public static LootFunctionType<RandomKnowledgeLootFunction> RANDOM_KNOWLEDGE;

    public static void register() {
        RANDOM_KNOWLEDGE = Registry.register(Registries.LOOT_FUNCTION_TYPE, Identifier.of(GreatBigWorld.NAMESPACE, "random_knowledge"), new LootFunctionType<>(RandomKnowledgeLootFunction.CODEC));
    }
}
