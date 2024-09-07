package dev.creoii.greatbigworld.relicsandruins.mixin.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureTemplate.class)
public class StructureTemplateMixin {
    /*@Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ServerWorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", ordinal = 1))
    private boolean creo$applyChestVariantGeneration(ServerWorldAccess instance, BlockPos pos, BlockState state, int i) {
        if (state.isOf(Blocks.CHEST)) {
            System.out.println("template: " + state.getBlock().getTranslationKey());
            return instance.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState(), i);
        }
        return instance.setBlockState(pos, state, i);
    }*/
}
