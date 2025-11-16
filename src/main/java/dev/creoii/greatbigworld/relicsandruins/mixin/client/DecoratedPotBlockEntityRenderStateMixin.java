package dev.creoii.greatbigworld.relicsandruins.mixin.client;

import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import dev.creoii.greatbigworld.relicsandruins.util.TrimmedDecoratedPot;
import net.minecraft.block.MapColor;
import net.minecraft.client.render.block.entity.state.DecoratedPotBlockEntityRenderState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(DecoratedPotBlockEntityRenderState.class)
public class DecoratedPotBlockEntityRenderStateMixin implements DyedDecoratedPot, TrimmedDecoratedPot {
    @Unique private MapColor color;
    @Unique private int trim;

    @Override
    public @Nullable MapColor gbw$getColor() {
        return color;
    }

    @Override
    public void gbw$setColor(@Nullable MapColor color) {
        this.color = color;
    }

    @Override
    public int gbw$getTrim() {
        return trim;
    }

    @Override
    public void gbw$setTrim(int trim) {
        this.trim = trim;
    }
}
