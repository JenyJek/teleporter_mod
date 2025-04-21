package net.jenyjek.simple_teleporters.block.entity.client;

import net.jenyjek.simple_teleporters.block.entity.ArcstoneChestBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ArcstoneChestRenderer extends GeoBlockRenderer<ArcstoneChestBlockEntity> {
    public ArcstoneChestRenderer(BlockEntityRendererFactory.Context context) {
        super(new ArcstoneChestModel());
    }
}
