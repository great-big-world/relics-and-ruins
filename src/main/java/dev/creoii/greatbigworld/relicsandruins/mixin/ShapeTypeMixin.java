package dev.creoii.greatbigworld.relicsandruins.mixin;

import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.RaycastContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(RaycastContext.ShapeType.class)
public class ShapeTypeMixin {
    @Invoker("<init>")
    private static RaycastContext.ShapeType init(String name, int id, RaycastContext.ShapeProvider provider) {
        throw new AssertionError();
    }

    @Shadow @Final @Mutable private static RaycastContext.ShapeType[] field_17561;

    static {
        ArrayList<RaycastContext.ShapeType> values = new ArrayList<>(Arrays.asList(field_17561));
        int last = values.size();

        values.add(init("EMPTY", last, (state, world, pos, context) -> VoxelShapes.empty()));

        field_17561 = values.toArray(new RaycastContext.ShapeType[0]);
    }
}
