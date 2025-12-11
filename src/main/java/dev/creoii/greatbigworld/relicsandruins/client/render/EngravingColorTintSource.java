package dev.creoii.greatbigworld.relicsandruins.client.render;

import com.mojang.serialization.MapCodec;
import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsDataComponentTypes;
import dev.creoii.greatbigworld.util.ColorHelper;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class EngravingColorTintSource implements ItemTintSource {
    public static final EngravingColorTintSource INSTANCE = new EngravingColorTintSource();
    public static final MapCodec<EngravingColorTintSource> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public int calculate(ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity user) {
        if (stack.has(RelicsAndRuinsDataComponentTypes.ENGRAVING)) {
            return 0xff000000 | ColorHelper.multiply(6250335, stack.get(RelicsAndRuinsDataComponentTypes.ENGRAVING).color().getTextColor(), .33334d);
        }
        return 0;
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return CODEC;
    }
}
