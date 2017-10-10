package com.hazebyte.crate.api.crate.reward;

import com.hazebyte.crate.api.crate.Crate;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public interface Reward {

    Crate getParent();

    void setParent(Crate crate);

    RewardLine getLine();

    boolean hasOneTimePerm(Player player);

    void setOneTimePerm(List<String> perms);

    int getSlot();

    void setSlot(int slot);

    double getChance();

    void setChance(double chance);

    ItemStack getDisplayItem();

    void setDisplayItem(ItemStack item);

    List<ItemStack> getItems();

    void setItems(List<ItemStack> items);

    List<String> getCommands();

    void setCommands(List<String> commands);

    Map<MessageType, String> getMessages();

    String getBroadcast();

    String getInlineBroadcast();

    String getOpenMessage();

    void setMessages(Tag tag, List<String> messages);

    boolean hasNoDuplicate();

    void setNoDuplicate(boolean bool);
}
