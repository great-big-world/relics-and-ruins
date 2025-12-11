package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.world.processor.SwampPyramidStructureProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class RelicsAndRuinsStructureProcessors {
    public static final StructureProcessorType<SwampPyramidStructureProcessor> SWAMP_PYRAMID_PROCESSOR = () -> SwampPyramidStructureProcessor.CODEC;

    public static void register() {
        Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "swamp_pyramid"), SWAMP_PYRAMID_PROCESSOR);
    }
}
