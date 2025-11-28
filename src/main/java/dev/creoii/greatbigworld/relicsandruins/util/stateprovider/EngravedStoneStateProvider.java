package dev.creoii.greatbigworld.relicsandruins.util.stateprovider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.creoii.greatbigworld.relicsandruins.block.EngravedStoneBlock;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlockStateProviderTypes;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;

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
    protected BlockStateProviderType<?> getType() {
        return RelicsAndRuinsBlockStateProviderTypes.ENGRAVED_STONE;
    }

    @Override
    public BlockState get(Random random, BlockPos pos) {
        return RelicsAndRuinsBlocks.ENGRAVED_STONE.getDefaultState().with(EngravedStoneBlock.ENGRAVING, engravings.get(random.nextInt(engravings.size()))).with(EngravedStoneBlock.COLOR, colors.get(random.nextInt(colors.size()))).with(EngravedStoneBlock.NATURAL, natural);
    }
}
