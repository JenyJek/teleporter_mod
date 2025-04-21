package net.jenyjek.simple_teleporters.block.entity.client;

import net.jenyjek.simple_teleporters.SimpleTeleporters;
import net.jenyjek.simple_teleporters.block.entity.ArcstoneChestBlockEntity;
import net.jenyjek.simple_teleporters.item.custom.ArcstoneChestBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ArcstoneChestItemModel extends GeoModel<ArcstoneChestBlockItem> {
    @Override
    public Identifier getModelResource(ArcstoneChestBlockItem arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "geo/arcstone_chest.geo.json");
    }

    @Override
    public Identifier getTextureResource(ArcstoneChestBlockItem arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "textures/block/arcstone_chest.png");
    }

    @Override
    public Identifier getAnimationResource(ArcstoneChestBlockItem arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "animations/arcstone_chest.animation.json");
    }
}
