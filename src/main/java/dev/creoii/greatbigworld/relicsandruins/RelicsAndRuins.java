package dev.creoii.greatbigworld.relicsandruins;

import com.google.common.collect.Sets;
import dev.creoii.greatbigworld.event.ItemEvents;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.knowledge.KnowledgeUtil;
import dev.creoii.greatbigworld.relicsandruins.registry.*;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.block.entity.Sherds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;

import java.util.HashSet;
import java.util.Set;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();
        RelicsAndRuinsDataComponentTypes.register();

        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.FOSSIL_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Feature.UNDERGROUND_STRUCTURES, UndergroundPlacedFeatures.FOSSIL_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_UPPER_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), GenerationStep.Feature.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_LOWER_COMMON);

        ItemEvents.PICKUP.register((player, itemEntity) -> {
            ItemStack stack = itemEntity.getStack();

            if (stack.contains(DataComponentTypes.POT_DECORATIONS)) {
                World world = player.getEntityWorld();
                Sherds sherds = stack.get(DataComponentTypes.POT_DECORATIONS);

                if (sherds == Sherds.DEFAULT || world.isClient())
                    return;

                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Set<Knowledge> knowledges = new HashSet<>();
                sherds.toList().forEach(item -> {
                    if (item != Items.BRICK) {
                        Knowledge knowledge = new Knowledge(Knowledge.Type.POTTERY_SHERD, Registries.ITEM.getId(item));
                        knowledges.add(knowledge);
                        knowledgeManager.learn(player, knowledge);
                    }
                });
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.POTTERY_SHERD, knowledges));
            } else if (stack.isIn(ItemTags.DECORATED_POT_SHERDS)) {
                World world = player.getEntityWorld();

                if (world.isClient())
                    return;

                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Knowledge knowledge = new Knowledge(Knowledge.Type.POTTERY_SHERD, Registries.ITEM.getId(stack.getItem()));
                knowledgeManager.learn(player, knowledge);
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.POTTERY_SHERD, Sets.newHashSet(knowledge)));
            } else if (stack.hasEnchantments()) {
                World world = player.getEntityWorld();
                ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getEnchantments();

                if (world.isClient())
                    return;

                Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Set<Knowledge> knowledges = new HashSet<>();
                itemEnchantmentsComponent.getEnchantments().forEach(enchantmentRegistryEntry -> {
                    Knowledge knowledge = new Knowledge(Knowledge.Type.ENCHANTMENT, enchantmentRegistry.getId(enchantmentRegistryEntry.value()));
                    knowledges.add(knowledge);
                    knowledgeManager.learn(player, knowledge);
                });
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.ENCHANTMENT, knowledges));
            } else if (stack.contains(DataComponentTypes.STORED_ENCHANTMENTS)) {
                World world = player.getEntityWorld();
                ItemEnchantmentsComponent itemEnchantmentsComponent = stack.get(DataComponentTypes.STORED_ENCHANTMENTS);

                if (world.isClient())
                    return;

                Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Set<Knowledge> knowledges = new HashSet<>();
                itemEnchantmentsComponent.getEnchantments().forEach(enchantmentRegistryEntry -> {
                    Knowledge knowledge = new Knowledge(Knowledge.Type.ENCHANTMENT, enchantmentRegistry.getId(enchantmentRegistryEntry.value()));
                    knowledges.add(knowledge);
                    knowledgeManager.learn(player, knowledge);
                });
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.ENCHANTMENT, knowledges));
            } else if (stack.getItem() instanceof SmithingTemplateItem smithingTemplateItem) {
                if (stack.isOf(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                    return;
                
                RegistryKey<ArmorTrimPattern> armorTrimPattern = KnowledgeUtil.getArmorTrimPatternFromStack(stack);

                if (armorTrimPattern != null) {
                    World world = player.getEntityWorld();
                    Registry<ArmorTrimPattern> armorTrimPatterns = world.getRegistryManager().getOrThrow(RegistryKeys.TRIM_PATTERN);
                    KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                    Knowledge knowledge = new Knowledge(Knowledge.Type.ARMOR_TRIM, armorTrimPatterns.getId(armorTrimPatterns.get(armorTrimPattern)));
                    if (knowledgeManager.learn(player, knowledge)) {
                        ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.ARMOR_TRIM, Sets.newHashSet(knowledge)));
                    }
                }
            } else if (stack.contains(DataComponentTypes.TRIM)) {
                World world = player.getEntityWorld();
                ArmorTrim armorTrim = stack.get(DataComponentTypes.TRIM);
                Registry<ArmorTrimPattern> armorTrimPatterns = world.getRegistryManager().getOrThrow(RegistryKeys.TRIM_PATTERN);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Knowledge knowledge = new Knowledge(Knowledge.Type.ARMOR_TRIM, armorTrimPatterns.getId(armorTrim.pattern().value()));
                if (knowledgeManager.learn(player, knowledge)) {
                    ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.ARMOR_TRIM, Sets.newHashSet(knowledge)));
                }
            } else if (stack.contains(DataComponentTypes.PROVIDES_BANNER_PATTERNS)) {
                World world = player.getEntityWorld();
                TagKey<BannerPattern> bannerPatternTagKey = stack.get(DataComponentTypes.PROVIDES_BANNER_PATTERNS);

                RegistryKey<BannerPattern> pattern = KnowledgeUtil.getBannerPatternFromTag(bannerPatternTagKey);

                if (pattern != null) {
                    Registry<BannerPattern> bannerPatterns = world.getRegistryManager().getOrThrow(RegistryKeys.BANNER_PATTERN);
                    KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                    Knowledge knowledge = new Knowledge(Knowledge.Type.BANNER_PATTERN, bannerPatterns.getId(bannerPatterns.get(pattern)));
                    if (knowledgeManager.learn(player, knowledge)) {
                        ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.BANNER_PATTERN, Sets.newHashSet(knowledge)));
                    }
                }
            } else if (stack.contains(DataComponentTypes.BANNER_PATTERNS)) {
                World world = player.getEntityWorld();
                BannerPatternsComponent bannerPatternsComponent = stack.get(DataComponentTypes.BANNER_PATTERNS);
                Registry<BannerPattern> bannerPatterns = world.getRegistryManager().getOrThrow(RegistryKeys.BANNER_PATTERN);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Set<Knowledge> knowledges = new HashSet<>();
                bannerPatternsComponent.layers().forEach(layer -> {
                    if (layer.pattern().matches(bannerPatternRegistryKey -> bannerPatternRegistryKey != BannerPatterns.BASE)) {
                        Knowledge knowledge = new Knowledge(Knowledge.Type.BANNER_PATTERN, bannerPatterns.getId(layer.pattern().value()));
                        knowledges.add(knowledge);
                        knowledgeManager.learn(player, knowledge);
                    }
                });
                ServerPlayNetworking.send((ServerPlayerEntity) player, new LearnKnowledgeS2C(Knowledge.Type.BANNER_PATTERN, knowledges));
            }
        });
    }
}
