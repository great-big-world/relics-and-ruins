package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.util.lootfunction.RandomKnowledgeLootFunction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public final class RelicsAndRuinsLootFunctionTypes {
    public static LootItemFunctionType<RandomKnowledgeLootFunction> RANDOM_KNOWLEDGE;

    public static void register() {
        RANDOM_KNOWLEDGE = Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "random_knowledge"), new LootItemFunctionType<>(RandomKnowledgeLootFunction.CODEC));
    }
}
