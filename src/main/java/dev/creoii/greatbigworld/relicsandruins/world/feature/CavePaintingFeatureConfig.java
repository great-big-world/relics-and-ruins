package dev.creoii.greatbigworld.relicsandruins.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record CavePaintingFeatureConfig(BlockStateProvider provider, IntProvider lineLength, IntProvider lineCount, IntProvider linePadding, IntProvider searchRadius) implements FeatureConfig {
    public static final Codec<CavePaintingFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter(CavePaintingFeatureConfig::provider),
            IntProvider.createValidatingCodec(0, 16).fieldOf("line_length").forGetter(CavePaintingFeatureConfig::lineLength),
            IntProvider.createValidatingCodec(0, 16).fieldOf("line_count").forGetter(CavePaintingFeatureConfig::lineCount),
            IntProvider.createValidatingCodec(0, 16).fieldOf("line_padding").forGetter(CavePaintingFeatureConfig::linePadding),
            IntProvider.createValidatingCodec(0, 16).fieldOf("search_radius").forGetter(CavePaintingFeatureConfig::searchRadius)
    ).apply(instance, CavePaintingFeatureConfig::new));
}