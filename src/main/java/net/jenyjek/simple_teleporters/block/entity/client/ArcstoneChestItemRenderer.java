package net.jenyjek.simple_teleporters.block.entity.client;

import net.jenyjek.simple_teleporters.item.custom.ArcstoneChestBlockItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArcstoneChestItemRenderer extends GeoItemRenderer<ArcstoneChestBlockItem> {
    public ArcstoneChestItemRenderer() {
        super(new ArcstoneChestItemModel());
    }
}
