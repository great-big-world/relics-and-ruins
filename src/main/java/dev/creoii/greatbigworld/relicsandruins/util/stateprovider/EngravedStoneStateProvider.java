package dev.creoii.greatbigworld.relicsandruins.util.stateprovider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlockStateProviderTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

import java.util.Arrays;
import java.util.List;

public class EngravedStoneStateProvider extends BlockStateProvider {
    public static final MapCodec<EngravedStoneStateProvider> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(
                EngravedStoneBlock.Engraving.CODEC.listOf().fieldOf("engravings").orElse(Arrays.asList(EngravedStoneBlock.Engraving.values())).forGetter(EngravedStoneStateProvider::getEngravings),
                DyeColor.CODEC.listOf().fieldOf("colors").orElse(Arrays.asList(DyeColor.values())).forGetter(EngravedStoneStateProvider::getColors),
                Codec.BOOL.fieldOf("natural").orElse(true).forGetter(EngravedStoneStateProvider::isNatural)
        ).apply(instance, EngravedStoneStateProvider::new);
    });
    private final List<EngravedStoneBlock.Engraving> engravings;
    private final List<DyeColor> colors;
    private final boolean natural;

    public EngravedStoneStateProvider(List<EngravedStoneBlock.Engraving> engravings, List<DyeColor> colors, boolean natural) {
        this.engravings = engravings;
        this.colors = colors;
        this.natural = natural;
    }

    public List<EngravedStoneBlock.Engraving> getEngravings() {
        return engravings;
    }

    public List<DyeColor> getColors() {
        return colors;
    }

    public boolean isNatural() {
        return natural;
    }

    @Override
    protected BlockStateProviderType<?> type() {
        return RelicsAndRuinsBlockStateProviderTypes.ENGRAVED_STONE;
    }

    @Override
    public BlockState getState(RandomSource randomSource, BlockPos blockPos) {
        return RelicsAndRuinsBlocks.ENGRAVED_STONE.defaultBlockState().setValue(EngravedStoneBlock.ENGRAVING, engravings.get(randomSource.nextInt(engravings.size()))).setValue(EngravedStoneBlock.COLOR, colors.get(randomSource.nextInt(colors.size()))).setValue(EngravedStoneBlock.NATURAL, natural);
    }
}
