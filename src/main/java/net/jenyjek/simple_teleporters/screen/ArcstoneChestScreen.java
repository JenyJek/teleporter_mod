package net.jenyjek.simple_teleporters.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jenyjek.simple_teleporters.SimpleTeleporters;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArcstoneChestScreen extends HandledScreen<ArcstoneChestScreenHandler> {
    private  static final Identifier TEXTURE = new Identifier(SimpleTeleporters.MOD_ID, "textures/gui/arcstone_chest_9x9_part1_gui.png");
    private  static final Identifier TEXTURE_2 = new Identifier(SimpleTeleporters.MOD_ID, "textures/gui/arcstone_chest_9x9_part2_gui.png");

    public ArcstoneChestScreen(ArcstoneChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.backgroundWidth = 176;
        this.backgroundHeight = 274;

        // Recalculate position
        this.x = (this.width - this.backgroundWidth) / 2;
        this.y = (this.height - this.backgroundHeight) / 2;

        //this.backgroundWidth = 256;
        //this.backgroundHeight = 512;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShaderTexture(1, TEXTURE_2);
        int x = this.x;
        int y = this.y;

        context.drawTexture(TEXTURE, x, y, 0, 0, 176, 256);
        context.drawTexture(TEXTURE_2, x, y+256, 0, 0, 176, 18);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX, mouseY);
        context.drawBorder(this.x, this.y, this.backgroundWidth, this.backgroundHeight, 0xFFFF0000);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        // Title (e.g. "Arcstone Chest")
        context.drawText(this.textRenderer, this.title, 8, 6, 0x404040, false);

        // "Inventory" label
        context.drawText(this.textRenderer, Text.literal("Inventory"), 8, this.backgroundHeight - 94, 0x404040, false);
    }
}
