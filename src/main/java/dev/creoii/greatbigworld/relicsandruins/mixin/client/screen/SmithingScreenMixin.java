package dev.creoii.greatbigworld.relicsandruins.mixin.client.screen;

import dev.creoii.greatbigworld.relicsandruins.util.ExtendedSmithingScreenHandler;
import dev.creoii.greatbigworld.relicsandruins.util.TemplateUnlockerPlayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.ingame.SmithingScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.screen.SmithingScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingScreen.class)
public abstract class SmithingScreenMixin extends ForgingScreen<SmithingScreenHandler> {
    @Shadow @Final private static Vector3f field_45497;
    @Shadow @Final private static Quaternionf ARMOR_STAND_ROTATION;
    @Shadow @Nullable private ArmorStandEntity armorStand;
    @Unique private static final Identifier SCROLLER_TEXTURE = new Identifier("container/stonecutter/scroller");
    @Unique private static final Identifier SCROLLER_DISABLED_TEXTURE = new Identifier("container/stonecutter/scroller_disabled");
    @Unique private static final Identifier RECIPE_SELECTED_TEXTURE = new Identifier("container/stonecutter/recipe_selected");
    @Unique private static final Identifier RECIPE_HIGHLIGHTED_TEXTURE = new Identifier("container/stonecutter/recipe_highlighted");
    @Unique private static final Identifier RECIPE_TEXTURE = new Identifier("container/stonecutter/recipe");
    @Unique private float scrollAmount;
    @Unique private boolean mouseClicked;
    @Unique private int scrollOffset;
    @Unique private boolean canCraft = true;

    public SmithingScreenMixin(SmithingScreenHandler handler, PlayerInventory playerInventory, Text title, Identifier texture) {
        super(handler, playerInventory, title, texture);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gbw$fixTitleY(SmithingScreenHandler handler, PlayerInventory playerInventory, Text title, CallbackInfo ci) {
        titleY = 4;
    }

    @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/InventoryScreen;drawEntity(Lnet/minecraft/client/gui/DrawContext;FFFLorg/joml/Vector3f;Lorg/joml/Quaternionf;Lorg/joml/Quaternionf;Lnet/minecraft/entity/LivingEntity;)V"), cancellable = true)
    private void gbw$renderArmorStandToTheRight(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        InventoryScreen.drawEntity(context, (float)(x + 152), (float)(y + 63), 25, field_45497, ARMOR_STAND_ROTATION, null, armorStand);
        ci.cancel();
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void gbw$renderSmithingTemplates(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int i = x;
        int j = y;
        int k = (int)(41f * scrollAmount);
        Identifier identifier = shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        context.drawGuiTexture(identifier, i + 118, j + 14 + k, 12, 15);
        int l = x + 51;
        int m = y + 13;
        int n = scrollOffset + 12;
        renderRecipeBackground(context, mouseX, mouseY, l, m, n);
        renderRecipeIcons(context, l, m, n);
    }

    @Unique
    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int x, int y, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < ((TemplateUnlockerPlayer) client.player).gbw$getUnlockedTemplates().size(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            if (i == ((ExtendedSmithingScreenHandler) handler).gbw$getSelectedRecipe()) {
                context.drawGuiTexture(RECIPE_SELECTED_TEXTURE, k, m - 1, 16, 18);
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                context.drawGuiTexture(RECIPE_HIGHLIGHTED_TEXTURE, k, m - 1, 16, 18);
            } else {
                context.drawGuiTexture(RECIPE_TEXTURE, k, m - 1, 16, 18);
            }
        }
    }

    @Unique
    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < ((TemplateUnlockerPlayer) client.player).gbw$getUnlockedTemplates().size(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            context.drawItem(((Item) ((TemplateUnlockerPlayer) client.player).gbw$getUnlockedTemplates().toArray()[i]).getDefaultStack(), k, m);
        }
    }

    @Override
    protected void drawSlot(DrawContext context, Slot slot) {
        if (slot.id == 0)
            return;
        super.drawSlot(context, slot);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (canCraft) {
            int i = x + 51;
            int j = y + 13;
            int k = scrollOffset + 12;
            for (int l = scrollOffset; l < k; ++l) {
                int m = l - scrollOffset;
                double d = mouseX - (double)(i + m % 4 * 16);
                double e = mouseY - (double)(j + m / 4 * 18);
                if (d >= 0d && e >= 0d && d < 16d && e < 18d && handler.onButtonClick(this.client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1f));
                    client.interactionManager.clickButton(handler.syncId, l);
                    return true;
                }
            }

            i = x + 118;
            j = y + 9;
            if (mouseX >= (double)i && mouseX < (double)(i + 13) && mouseY >= (double)j && mouseY < (double)(j + 59)) {
                this.mouseClicked = !mouseClicked;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (mouseClicked && shouldScroll()) {
            int i = y + 13;
            int j = i + 51;
            scrollAmount = ((float)mouseY - (float)i - 7.5f) / ((float)(j - i) - 15f);
            scrollAmount = MathHelper.clamp(scrollAmount, 0f, 1f);
            scrollOffset = (int)((double)(scrollAmount * (float)getMaxScroll()) + .5d) * 4;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (shouldScroll()) {
            int i = getMaxScroll();
            float f = (float)verticalAmount / (float)i;
            scrollAmount = MathHelper.clamp(scrollAmount - f, 0f, 1f);
            scrollOffset = (int)((double)(scrollAmount * (float)i) + .5d) * 4;
        }
        return true;
    }

    private boolean shouldScroll() {
        return canCraft && ((TemplateUnlockerPlayer) client.player).gbw$getUnlockedTemplates().size() > 12;
    }

    protected int getMaxScroll() {
        return (((TemplateUnlockerPlayer) client.player).gbw$getUnlockedTemplates().size() + 4 - 1) / 4 - 3;
    }
}
