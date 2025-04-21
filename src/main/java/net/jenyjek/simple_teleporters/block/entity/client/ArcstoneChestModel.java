package net.jenyjek.simple_teleporters.block.entity.client;

import net.jenyjek.simple_teleporters.SimpleTeleporters;
import net.jenyjek.simple_teleporters.block.entity.ArcstoneChestBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ArcstoneChestModel extends GeoModel<ArcstoneChestBlockEntity> {
    @Override
    public Identifier getModelResource(ArcstoneChestBlockEntity arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "geo/arcstone_chest.geo.json");
    }

    @Override
    public Identifier getTextureResource(ArcstoneChestBlockEntity arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "textures/block/arcstone_chest.png");
    }

    @Override
    public Identifier getAnimationResource(ArcstoneChestBlockEntity arcstoneChestBlockEntity) {
        return new Identifier(SimpleTeleporters.MOD_ID, "animations/arcstone_chest.animation.json");
    }
}
