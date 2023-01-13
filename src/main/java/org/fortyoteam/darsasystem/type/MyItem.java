package org.fortyoteam.darsasystem.type;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MyItem {

    public static ItemStack createItemStackWithDisplayName(ItemStack item, String DisplayName) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', DisplayName));
        item.setItemMeta(meta);

        return item;
    }


}
