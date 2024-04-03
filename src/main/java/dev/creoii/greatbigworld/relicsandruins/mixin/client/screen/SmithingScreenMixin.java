package dev.creoii.greatbigworld.relicsandruins.mixin.client.screen;

import dev.creoii.greatbigworld.relicsandruins.util.ExtendedSmithingScreenHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.ingame.SmithingScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.screen.SmithingScreenHandler;
import net.minecraft.screen.StonecutterScreenHandler;
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

import java.util.List;

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
        this.titleY = 4;
    }

    @Inject(method = "drawBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/InventoryScreen;drawEntity(Lnet/minecraft/client/gui/DrawContext;FFILorg/joml/Vector3f;Lorg/joml/Quaternionf;Lorg/joml/Quaternionf;Lnet/minecraft/entity/LivingEntity;)V"), cancellable = true)
    private void gbw$renderArmorStandToTheRight(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo ci) {
        InventoryScreen.drawEntity(context, (float)(this.x + 147), (float)(this.y + 63), 25, field_45497, ARMOR_STAND_ROTATION, null, armorStand);
        ci.cancel();
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void gbw$renderSmithingTemplates(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int i = this.x;
        int j = this.y;
        int k = (int)(41f * this.scrollAmount);
        Identifier identifier = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        context.drawGuiTexture(identifier, i + 109, j + 14 + k, 12, 15);
        int l = this.x + 59;
        int m = this.y + 13;
        int n = this.scrollOffset + 12;
        renderRecipeBackground(context, mouseX, mouseY, l, m, n);
        renderRecipeIcons(context, l, m, n);
    }

    @Inject(method = "renderSlotTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/SmithingScreenHandler;getSlot(I)Lnet/minecraft/screen/slot/Slot;"), cancellable = true)
    private void gbw$dontRenderTemplateTooltip(DrawContext context, int mouseX, int mouseY, CallbackInfo ci) {
        if (focusedSlot.id == 0)
            ci.cancel();

        if (this.canCraft) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;
            for(int l = this.scrollOffset; l < k && l < ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.size(); ++l) {
                int m = l - this.scrollOffset;
                int n = i + m % 4 * 16;
                int o = j + m / 4 * 18 + 2;
                if (x >= n && x < n + 16 && y >= o && y < o + 18) {
                    context.drawItemTooltip(this.textRenderer, ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.get(l).getDefaultStack(), x, y);
                }
            }
        }
    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int x, int y, int scrollOffset) {
        for(int i = this.scrollOffset; i < scrollOffset && i < ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.size(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 3 * 16;
            int l = j / 3;
            int m = y + l * 18 + 2;
            Identifier identifier;
            if (i == ((ExtendedSmithingScreenHandler)this.handler).gbw$getSelectedRecipe()) {
                identifier = RECIPE_SELECTED_TEXTURE;
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                identifier = RECIPE_HIGHLIGHTED_TEXTURE;
            } else {
                identifier = RECIPE_TEXTURE;
            }

            context.drawGuiTexture(identifier, k, m - 1, 16, 18);
        }
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.size(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 3 * 16;
            int l = j / 3;
            int m = y + l * 18 + 2;
            context.drawItem(ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.get(i).getDefaultStack(), k, m);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.x + 59;
            int j = this.y + 13;
            int k = this.scrollOffset + 12;

            for(int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double)(i + m % 3 * 16);
                double e = mouseY - (double)(j + m / 3 * 18);
                if (d >= 0.0 && e >= 0.0 && d < 16.0 && e < 18.0 && (this.handler).onButtonClick(this.client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.client.interactionManager.clickButton((this.handler).syncId, l);
                    return true;
                }
            }

            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= (double)i && mouseX < (double)(i + 13) && mouseY >= (double)j && mouseY < (double)(j + 59)) {
                this.mouseClicked = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 13;
            int j = i + 59;
            this.scrollAmount = ((float)mouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)this.getMaxScroll()) + 0.5) * 3;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float)verticalAmount / (float)i;
            this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)i) + 0.5) * 3;
        }

        return true;
    }

    @Override
    protected void drawSlot(DrawContext context, Slot slot) {
        if (slot.id == 0)
            return;
        super.drawSlot(context, slot);
    }

    private boolean shouldScroll() {
        return this.canCraft && ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.size() > 9;
    }

    protected int getMaxScroll() {
        return (ExtendedSmithingScreenHandler.SMITHING_TEMPLATES.size() + 3 - 1) / 3 - 3;
    }
}
