package dev.creoii.greatbigworld.relicsandruins.registry;

import dev.creoii.greatbigworld.GreatBigWorld;
import dev.creoii.greatbigworld.relicsandruins.block.entity.AncientTotemBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RelicsAndRuinsBlockEntityTypes {
    public static BlockEntityType<AncientTotemBlockEntity> ANCIENT_TOTEM;

    public static void register() {
        ANCIENT_TOTEM = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(GreatBigWorld.NAMESPACE, "ancient_totem"), FabricBlockEntityTypeBuilder.create(AncientTotemBlockEntity::new, RelicsAndRuinsBlocks.ANCIENT_TOTEM).build());
    }
}
