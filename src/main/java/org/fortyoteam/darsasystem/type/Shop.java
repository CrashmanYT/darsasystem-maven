package org.fortyoteam.darsasystem.type;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Array;
import java.util.Arrays;

public class Shop {

    public static Inventory createShop(String title ,SelledItem[] items) {
        Inventory shop = Bukkit.createInventory(null,54, ChatColor.translateAlternateColorCodes('&',title ));


    }

    private static SelledItem AddItem(SelledItem item) {
        ItemMeta meta = item.getItemMeta();
        String[] lore = {ChatColor.translateAlternateColorCodes('&', "&e&lPrice : " + item.getPrice())};
        meta.setLore(Arrays.asList(lore));
        return item;
    }

}
