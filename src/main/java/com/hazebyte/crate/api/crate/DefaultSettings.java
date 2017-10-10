package com.hazebyte.crate.api.crate;

import org.bukkit.inventory.ItemStack;

public class DefaultSettings {

    boolean isPreviewButtonsEnabled;
    boolean isPushbackEnabled;
    boolean isCreativeControlOn;
    boolean isCraftingEnabled;
    boolean isHotbarEnabled;

    String previewMenuName;

    ItemStack previewBackButton;
    ItemStack previewCloseButton;
    ItemStack previewNextButton;

    double pushbackX;
    double pushbackY;
    double pushbackZ;

    private static DefaultSettings instance;
    public DefaultSettings() {
        instance = this;
    }

    public static DefaultSettings instance() {
        return instance;
    }

    public boolean isPreviewButtonsEnabled() {
        return isPreviewButtonsEnabled;
    }

    public void setPreviewButtonsEnabled(boolean previewButtonsEnabled) {
        isPreviewButtonsEnabled = previewButtonsEnabled;
    }

    public boolean isPushbackEnabled() {
        return isPushbackEnabled;
    }

    public void setPushbackEnabled(boolean pushbackEnabled) {
        isPushbackEnabled = pushbackEnabled;
    }

    public boolean isCreativeControlOn() {
        return isCreativeControlOn;
    }

    public void setCreativeControlOn(boolean creativeControlOn) {
        isCreativeControlOn = creativeControlOn;
    }

    public boolean isCraftingEnabled() {
        return isCraftingEnabled;
    }

    public void setCraftingEnabled(boolean craftingEnabled) {
        isCraftingEnabled = craftingEnabled;
    }

    public boolean isHotbarEnabled() {
        return isHotbarEnabled;
    }

    public void setHotbarEnabled(boolean hotbarEnabled) {
        isHotbarEnabled = hotbarEnabled;
    }

    public String getPreviewMenuName() {
        return previewMenuName;
    }

    public void setPreviewMenuName(String previewMenuName) {
        this.previewMenuName = previewMenuName;
    }

    public ItemStack getPreviewBackButton() {
        return previewBackButton;
    }

    public void setPreviewBackButton(ItemStack previewBackButton) {
        this.previewBackButton = previewBackButton;
    }

    public ItemStack getPreviewCloseButton() {
        return previewCloseButton;
    }

    public void setPreviewCloseButton(ItemStack previewCloseButton) {
        this.previewCloseButton = previewCloseButton;
    }

    public ItemStack getPreviewNextButton() {
        return previewNextButton;
    }

    public void setPreviewNextButton(ItemStack previewNextButton) {
        this.previewNextButton = previewNextButton;
    }

    public double getPushbackX() {
        return pushbackX;
    }
    public void setPushbackX(double pushbackX) {
        this.pushbackX = pushbackX;
    }

    public double getPushbackY() {
        return pushbackY;
    }

    public void setPushbackY(double pushbackY) {
        this.pushbackY = pushbackY;
    }

    public double getPushbackZ() {
        return pushbackZ;
    }

    public void setPushbackZ(double pushbackZ) {
        this.pushbackZ = pushbackZ;
    }
}
