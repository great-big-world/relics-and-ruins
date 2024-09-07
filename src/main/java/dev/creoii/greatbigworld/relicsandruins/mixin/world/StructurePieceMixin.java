package dev.creoii.greatbigworld.relicsandruins.mixin.world;

import dev.creoii.greatbigworld.relicsandruins.registry.RelicsAndRuinsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructurePiece.class)
public class StructurePieceMixin {
    @Shadow @Final private StructurePieceType type;

    @Redirect(method = "addChest(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/util/math/BlockBox;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/block/BlockState;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ServerWorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
    private boolean applyChestVariantGeneration(ServerWorldAccess instance, BlockPos pos, BlockState state, int i) {
        if (state.isOf(Blocks.CHEST)) {
            if (type == StructurePieceType.JUNGLE_TEMPLE) {
                return instance.setBlockState(pos, RelicsAndRuinsBlocks.JUNGLE_CHEST.getStateWithProperties(state), i);
            } else if (type == StructurePieceType.IGLOO) {
                return instance.setBlockState(pos, RelicsAndRuinsBlocks.SPRUCE_CHEST.getStateWithProperties(state), i);
            } else if (type == StructurePieceType.WOODLAND_MANSION) {
                return instance.setBlockState(pos, RelicsAndRuinsBlocks.DARK_OAK_CHEST.getStateWithProperties(state), i);
            }
        }
        return instance.setBlockState(pos, state, i);
    }
}
