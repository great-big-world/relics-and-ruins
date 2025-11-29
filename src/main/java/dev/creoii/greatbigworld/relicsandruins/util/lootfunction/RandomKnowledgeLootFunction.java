package dev.creoii.greatbigworld.relicsandruins.util.lootfunction;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeComponent;
import dev.creoii.greatbigworld.registry.GBWDataComponentTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsLootFunctionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;

import java.util.ArrayList;
import java.util.List;

public class RandomKnowledgeLootFunction extends ConditionalLootFunction {
    public static final MapCodec<RandomKnowledgeLootFunction> CODEC = RecordCodecBuilder.mapCodec(instance -> addConditionsField(instance).and(IntProvider.NON_NEGATIVE_CODEC.orElse(ConstantIntProvider.ZERO).fieldOf("count").forGetter(RandomKnowledgeLootFunction::getCount)).and(Knowledge.CODEC.listOf().fieldOf("knowledge").forGetter(RandomKnowledgeLootFunction::getKnowledge)).apply(instance, RandomKnowledgeLootFunction::new));
    private final IntProvider count;
    private final List<Knowledge> knowledge;

    private RandomKnowledgeLootFunction(List<LootCondition> conditions, IntProvider count, List<Knowledge> knowledge) {
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

    public LootFunctionType<RandomKnowledgeLootFunction> getType() {
        return RelicsAndRuinsLootFunctionTypes.RANDOM_KNOWLEDGE;
    }

    public ItemStack process(ItemStack stack, LootContext context) {
        int count = this.count.get(context.getRandom());
        for (int i = 0; i < count; ++i) {
            Knowledge knowledge = this.knowledge.get(context.getRandom().nextInt(this.knowledge.size()));

            if (stack.contains(GBWDataComponentTypes.KNOWLEDGE)) {
                stack.get(GBWDataComponentTypes.KNOWLEDGE).knowledge().add(knowledge);
            } else {
                List<Knowledge> knowledges = new ArrayList<>();
                knowledges.add(knowledge);
                stack.set(GBWDataComponentTypes.KNOWLEDGE, new KnowledgeComponent(knowledges));
            }
        }
        return stack;
    }
}
