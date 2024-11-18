package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.world.processor.SwampPyramidStructureProcessor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsStructureProcessors {
    public static final StructureProcessorType<SwampPyramidStructureProcessor> SWAMP_PYRAMID_PROCESSOR = () -> SwampPyramidStructureProcessor.CODEC;

    public static void register() {
        Registry.register(Registries.STRUCTURE_PROCESSOR, Identifier.of(GreatBigWorld.NAMESPACE, "swamp_pyramid"), SWAMP_PYRAMID_PROCESSOR);
    }
}
