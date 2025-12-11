package dev.creoii.greatbigworld.relicsandruins.util.lootfunction;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeComponent;
import dev.creoii.greatbigworld.registry.GBWDataComponentTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsLootFunctionTypes;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.ArrayList;
import java.util.List;

public class RandomKnowledgeLootFunction extends LootItemConditionalFunction {
    public static final MapCodec<RandomKnowledgeLootFunction> CODEC = RecordCodecBuilder.mapCodec(instance -> commonFields(instance).and(IntProvider.NON_NEGATIVE_CODEC.orElse(ConstantInt.ZERO).fieldOf("count").forGetter(RandomKnowledgeLootFunction::getCount)).and(Knowledge.CODEC.listOf().fieldOf("knowledge").forGetter(RandomKnowledgeLootFunction::getKnowledge)).apply(instance, RandomKnowledgeLootFunction::new));
    private final IntProvider count;
    private final List<Knowledge> knowledge;

    private RandomKnowledgeLootFunction(List<LootItemCondition> conditions, IntProvider count, List<Knowledge> knowledge) {
        super(conditions);
        this.count = count;
        this.knowledge = knowledge;
    }

    public IntProvider getCount() {
        return count;
    }

    public List<Knowledge> getKnowledge() {
        return knowledge;
    }

    public LootItemFunctionType<RandomKnowledgeLootFunction> getType() {
        return RelicsAndRuinsLootFunctionTypes.RANDOM_KNOWLEDGE;
    }

    @Override
    protected ItemStack run(ItemStack itemStack, LootContext lootContext) {
        int count = this.count.sample(lootContext.getRandom());
        for (int i = 0; i < count; ++i) {
            Knowledge knowledge = this.knowledge.get(lootContext.getRandom().nextInt(this.knowledge.size()));

            if (itemStack.has(GBWDataComponentTypes.KNOWLEDGE)) {
                itemStack.get(GBWDataComponentTypes.KNOWLEDGE).knowledge().add(knowledge);
            } else {
                List<Knowledge> knowledges = new ArrayList<>();
                knowledges.add(knowledge);
                itemStack.set(GBWDataComponentTypes.KNOWLEDGE, new KnowledgeComponent(knowledges));
            }
        }
        return itemStack;
    }
}
