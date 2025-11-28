package dev.creoii.greatbigworld.relicsandruins.client.render;

import com.mojang.serialization.MapCodec;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponentTypes;
import dev.creoii.greatbigworld.util.ColorHelper;
import net.minecraft.client.render.item.tint.TintSource;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class EngravingColorTintSource implements TintSource {
    public static final EngravingColorTintSource INSTANCE = new EngravingColorTintSource();
    public static final MapCodec<EngravingColorTintSource> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public int getTint(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity user) {
        if (stack.contains(RelicsAndRuinsDataComponentTypes.ENGRAVING)) {
            return 0xff000000 | ColorHelper.multiply(6250335, stack.get(RelicsAndRuinsDataComponentTypes.ENGRAVING).color().getSignColor(), .33334d);
        }
        return 0;
    }

    @Override
    public MapCodec<? extends TintSource> getCodec() {
        return CODEC;
    }
}
