package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.block.entity.KnowledgeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class RelicsAndRuinsBlockEntities {
    public static BlockEntityType<KnowledgeBlockEntity> KNOWLEDGE_BLOCK;

    public static void register() {
        KNOWLEDGE_BLOCK = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(GreatBigWorld.NAMESPACE, "knowledge_block"), FabricBlockEntityTypeBuilder.create(KnowledgeBlockEntity::new).addBlock(RelicsAndRuinsBlocks.ENGRAVED_STONE).build());
    }
}
