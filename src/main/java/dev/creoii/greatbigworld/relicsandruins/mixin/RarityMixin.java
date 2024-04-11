package dev.creoii.greatbigworld.relicsandruins.mixin;

import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(Rarity.class)
public class RarityMixin {
    @Invoker("<init>")
    private static Rarity init(String name, int id, Formatting formatting) {
        throw new AssertionError();
    }

    @Shadow
    @Final
    @Mutable
    private static Rarity[] field_8905;

    static {
        ArrayList<Rarity> values = new ArrayList<>(Arrays.asList(field_8905));
        int last = values.size();

        values.add(init("RELIC", last, Formatting.GOLD));

        field_8905 = values.toArray(new Rarity[0]);
    }
}
