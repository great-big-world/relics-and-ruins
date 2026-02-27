package dev.creoii.greatbigworld.relicsandruins;

import com.google.common.collect.Sets;
import dev.creoii.greatbigworld.event.ItemEvents;
import dev.creoii.greatbigworld.knowledge.Knowledge;
import dev.creoii.greatbigworld.knowledge.KnowledgeManager;
import dev.creoii.greatbigworld.knowledge.KnowledgeUtil;
import dev.creoii.greatbigworld.registry.GBWBlockEntityTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.*;
import dev.creoii.greatbigworld.relicsandruins.util.RelicsAndRuinsTags;
import dev.creoii.greatbigworld.thealterworld.TheAlterworld;
import dev.creoii.greatbigworld.util.network.LearnKnowledgeS2C;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.ComponentTooltipAppenderRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.HashSet;
import java.util.Set;

public class RelicsAndRuins implements ModInitializer {
    @Override
    public void onInitialize() {
        RelicsAndRuinsBlocks.register();
        RelicsAndRuinsItems.register();
        RelicsAndRuinsStructureProcessors.register();
        RelicsAndRuinsPotions.register();
        RelicsAndRuinsFeatures.register();
        RelicsAndRuinsDataComponentTypes.register();
        RelicsAndRuinsBlockStateProviderTypes.register();
        RelicsAndRuinsLootFunctionTypes.register();

        if (GBWBlockEntityTypes.KNOWLEDGE_BLOCK != null)
            ((BlockEntityTypeAccessor) GBWBlockEntityTypes.KNOWLEDGE_BLOCK).getBlocks().add(RelicsAndRuinsBlocks.ENGRAVED_STONE);

        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_LOWER);
        BiomeModifications.addFeature(BiomeSelectors.tag(RelicsAndRuinsTags.FOSSIL_BIOMES), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.FOSSIL_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_UPPER_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, RelicsAndRuinsPlacedFeatures.FOSSIL_LOWER_COMMON);

        BiomeModifications.addFeature(TheAlterworld.foundInOverworldLike(), GenerationStep.Decoration.UNDERGROUND_ORES, RelicsAndRuinsPlacedFeatures.CAVE_PAINTING);

        ItemEvents.PICKUP.register((player, itemEntity) -> {
            tryLearnFrom(player, itemEntity.getItem());
        });

        ComponentTooltipAppenderRegistry.addBefore(DataComponents.MAP_ID, RelicsAndRuinsDataComponentTypes.ENGRAVING);
    }

    private static void tryLearnFrom(Player player, ItemStack stack) {
        if (stack.has(DataComponents.POT_DECORATIONS)) {
            Level world = player.level();
            PotDecorations sherds = stack.get(DataComponents.POT_DECORATIONS);

            if (sherds == PotDecorations.EMPTY || world.isClientSide())
                return;

            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Set<Knowledge> knowledges = new HashSet<>();
            sherds.ordered().forEach(item -> {
                if (item != Items.BRICK) {
                    Knowledge knowledge = new Knowledge(Knowledge.Type.POTTERY_SHERD, BuiltInRegistries.ITEM.getKey(item));
                    knowledges.add(knowledge);
                    knowledgeManager.learn(player, knowledge);
                }
            });
            ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.POTTERY_SHERD, knowledges));
        } else if (stack.is(ItemTags.DECORATED_POT_SHERDS)) {
            Level world = player.level();

            if (world.isClientSide())
                return;

            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Knowledge knowledge = new Knowledge(Knowledge.Type.POTTERY_SHERD, BuiltInRegistries.ITEM.getKey(stack.getItem()));
            knowledgeManager.learn(player, knowledge);
            ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.POTTERY_SHERD, Sets.newHashSet(knowledge)));
        } else if (stack.isEnchanted()) {
            Level world = player.level();
            ItemEnchantments itemEnchantmentsComponent = stack.getEnchantments();

            if (world.isClientSide())
                return;

            Registry<Enchantment> enchantmentRegistry = world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Set<Knowledge> knowledges = new HashSet<>();
            itemEnchantmentsComponent.entrySet().forEach(enchantmentRegistryEntry -> {
                Knowledge knowledge = new Knowledge(Knowledge.Type.ENCHANTMENT, enchantmentRegistry.getKey(enchantmentRegistryEntry.getKey().value()));
                knowledges.add(knowledge);
                knowledgeManager.learn(player, knowledge);
            });
            ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.ENCHANTMENT, knowledges));
        } else if (stack.has(DataComponents.STORED_ENCHANTMENTS)) {
            Level world = player.level();
            ItemEnchantments itemEnchantmentsComponent = stack.get(DataComponents.STORED_ENCHANTMENTS);

            if (world.isClientSide())
                return;

            Registry<Enchantment> enchantmentRegistry = world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Set<Knowledge> knowledges = new HashSet<>();
            itemEnchantmentsComponent.entrySet().forEach(enchantmentRegistryEntry -> {
                Knowledge knowledge = new Knowledge(Knowledge.Type.ENCHANTMENT, enchantmentRegistry.getKey(enchantmentRegistryEntry.getKey().value()));
                knowledges.add(knowledge);
                knowledgeManager.learn(player, knowledge);
            });
            ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.ENCHANTMENT, knowledges));
        } else if (stack.getItem() instanceof SmithingTemplateItem smithingTemplateItem) {
            if (stack.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                return;

            ResourceKey<TrimPattern> armorTrimPattern = KnowledgeUtil.getArmorTrimPatternFromStack(stack);

            if (armorTrimPattern != null) {
                Level world = player.level();
                Registry<TrimPattern> armorTrimPatterns = world.registryAccess().lookupOrThrow(Registries.TRIM_PATTERN);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Knowledge knowledge = new Knowledge(Knowledge.Type.ARMOR_TRIM, armorTrimPatterns.getKey(armorTrimPatterns.getValue(armorTrimPattern)));
                if (knowledgeManager.learn(player, knowledge)) {
                    ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.ARMOR_TRIM, Sets.newHashSet(knowledge)));
                }
            }
        } else if (stack.has(DataComponents.TRIM)) {
            Level world = player.level();
            ArmorTrim armorTrim = stack.get(DataComponents.TRIM);
            Registry<TrimPattern> armorTrimPatterns = world.registryAccess().lookupOrThrow(Registries.TRIM_PATTERN);
            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Knowledge knowledge = new Knowledge(Knowledge.Type.ARMOR_TRIM, armorTrimPatterns.getKey(armorTrim.pattern().value()));
            if (knowledgeManager.learn(player, knowledge)) {
                ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.ARMOR_TRIM, Sets.newHashSet(knowledge)));
            }
        } else if (stack.has(DataComponents.PROVIDES_BANNER_PATTERNS)) {
            Level world = player.level();
            TagKey<BannerPattern> bannerPatternTagKey = stack.get(DataComponents.PROVIDES_BANNER_PATTERNS);

            ResourceKey<BannerPattern> pattern = KnowledgeUtil.getBannerPatternFromTag(bannerPatternTagKey);

            if (pattern != null) {
                Registry<BannerPattern> bannerPatterns = world.registryAccess().lookupOrThrow(Registries.BANNER_PATTERN);
                KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
                Knowledge knowledge = new Knowledge(Knowledge.Type.BANNER_PATTERN, bannerPatterns.getKey(bannerPatterns.getValue(pattern)));
                if (knowledgeManager.learn(player, knowledge)) {
                    ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.BANNER_PATTERN, Sets.newHashSet(knowledge)));
                }
            }
        } else if (stack.has(DataComponents.BANNER_PATTERNS)) {
            Level world = player.level();
            BannerPatternLayers bannerPatternsComponent = stack.get(DataComponents.BANNER_PATTERNS);
            Registry<BannerPattern> bannerPatterns = world.registryAccess().lookupOrThrow(Registries.BANNER_PATTERN);
            KnowledgeManager knowledgeManager = KnowledgeManager.getServerState(world.getServer());
            Set<Knowledge> knowledges = new HashSet<>();
            bannerPatternsComponent.layers().forEach(layer -> {
                if (layer.pattern().is(bannerPatternRegistryKey -> bannerPatternRegistryKey != BannerPatterns.BASE)) {
                    Knowledge knowledge = new Knowledge(Knowledge.Type.BANNER_PATTERN, bannerPatterns.getKey(layer.pattern().value()));
                    knowledges.add(knowledge);
                    knowledgeManager.learn(player, knowledge);
                }
            });
            ServerPlayNetworking.send((ServerPlayer) player, new LearnKnowledgeS2C(Knowledge.Type.BANNER_PATTERN, knowledges));
        }
    }
}
