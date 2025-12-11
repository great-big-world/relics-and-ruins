package dev.creoii.greatbigworld.relicsandruins.mixin.block;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.Codec;
import dev.creoii.greatbigworld.relicsandruins.util.DyedDecoratedPot;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.TagValueOutput;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin implements DyedDecoratedPot {
    @Unique private MapColor color;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gbw$setColor(BlockBehaviour.Properties settings, CallbackInfo ci) {
        if ((Object) this != Blocks.DECORATED_POT)
            color = ((DecoratedPotBlock) (Object) this).defaultMapColor();
    }

    @Inject(method = "getCloneItemStack", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private void gbw$fixPotPickStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl, CallbackInfoReturnable<ItemStack> cir, @Local DecoratedPotBlockEntity decoratedPotBlockEntity) {
        ItemStack stack = decoratedPotBlockEntity.getBlockState().getBlock().asItem().getDefaultInstance();
        TagValueOutput nbtWriteView = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, levelReader.registryAccess());
        List<String> list = new ArrayList<>();
        decoratedPotBlockEntity.getDecorations().ordered().forEach(item -> list.add(BuiltInRegistries.ITEM.getKey(item).toString()));
        nbtWriteView.store("sherds", Codec.STRING.listOf(), list);
        BlockItem.setBlockEntityData(stack, BlockEntityType.DECORATED_POT, nbtWriteView);
        cir.setReturnValue(stack);
    }

    @ModifyReturnValue(method = "newBlockEntity", at = @At("RETURN"))
    private BlockEntity gbw$dyeCreateBlockEntity(BlockEntity original, @Local(argsOnly = true) BlockState state) {
        if (!state.is(Blocks.DECORATED_POT))
            ((DyedDecoratedPot) original).gbw$setColor(color);
        else ((DyedDecoratedPot) original).gbw$setColor(null);
        return original;
    }

    @Override
    @Nullable
    public MapColor gbw$getColor() {
        return color;
    }

    @Override
    public void gbw$setColor(MapColor color) {
        this.color = color;
    }
}
