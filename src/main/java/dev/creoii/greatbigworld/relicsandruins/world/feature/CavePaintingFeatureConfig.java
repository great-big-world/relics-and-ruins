package dev.creoii.greatbigworld.relicsandruins.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CavePaintingFeatureConfig(BlockStateProvider provider, IntProvider lineLength, IntProvider lineCount, IntProvider linePadding, IntProvider searchRadius) implements FeatureConfiguration {
    public static final Codec<CavePaintingFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(CavePaintingFeatureConfig::provider),
            IntProvider.codec(0, 16).fieldOf("line_length").forGetter(CavePaintingFeatureConfig::lineLength),
            IntProvider.codec(0, 16).fieldOf("line_count").forGetter(CavePaintingFeatureConfig::lineCount),
            IntProvider.codec(0, 16).fieldOf("line_padding").forGetter(CavePaintingFeatureConfig::linePadding),
            IntProvider.codec(0, 16).fieldOf("search_radius").forGetter(CavePaintingFeatureConfig::searchRadius)
    ).apply(instance, CavePaintingFeatureConfig::new));
}