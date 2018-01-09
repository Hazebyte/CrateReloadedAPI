package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Crate {

    String getCrateName();
    
    String getUUID();
    
    String getDisplayName();
    
    ItemStack getDisplayItem();
    
    CrateType getType();
    
    ItemStack getCrateItem();
    
    ItemStack getKeyItem();
    
    double getCost();
    
    AnimationType getAnimationType();

    void addReward(Reward reward);

    void removeReward(Reward reward);

    void setRewards(List<Reward> rewards);

    List<Reward> getRewards();

    List<Reward> generatePrizes(Player player);

    boolean open(Player player, Object... args);

    void preview(Player player);
    
    boolean purchase(Player player, int amount);

    boolean giveTo(Player player, int amount);

    String getRewardString();

    int getRewardSize();
    
    int getMinimumRewards();
    
    int getMaximumRewards();
    
    double getGrossChance(List<Reward> rewards);
    
    boolean requiresKey();
    
    int getPreviewRows();

    void setDisplayName(String name);

    void setAnimationType(AnimationType type);

    void setDisplayItem(ItemStack item);
    
    void setCrateItem(ItemStack item);
    
    void setKeyItem(ItemStack item);
    
    void setRequiresKey(boolean bool);

    boolean isKey(ItemStack item);

    boolean isCrate(ItemStack item);
    
    boolean isBuyable();
    
    boolean isPreviewable();

    List<String> getHolographicText();

    void setHolographicText(List<String> text);

    void showHolographic(Location location);

    void hideHolographic(Location location);
}
