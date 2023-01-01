package org.fortyoteam.darsasystem.type;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Shop {


    public static Inventory createShop(String title ,SelledItem[] items) {
        // create next page if items is more than 28, use recursive function
        if (items.length > 28) return createNextPage(title, Arrays.copyOfRange(items, 27, items.length - 1));

        Inventory shop = Bukkit.createInventory(null,54, ChatColor.translateAlternateColorCodes('&',title ));


        int[] blacklistedSlot = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53,54}; // blacklisted slot
        // loop all selled items and add to shop
        for (SelledItem item : items) {
            // loop all slot from 10
            for (int i = 10; i < items.length; i++) {
                if (!Arrays.asList(blacklistedSlot).contains(i)) // if slot index is contain blacklisted slot
                    shop.setItem(i, addItem(item));
            }
        }
        return shop;

    }

    // Function to convert item and add item into shop
    private static SelledItem addItem(SelledItem item) {
        ItemMeta meta = item.getItemMeta();
        String[] lore = {ChatColor.translateAlternateColorCodes('&', "&e&lPrice : " + item.getPrice() + " Gold")};
        meta.setLore(Arrays.asList(lore));
        return item;
    }

    // Function to create next page when items size is bigger than 28
    private static Inventory createNextPage(String title, SelledItem[] items) {
        return createShop(title, items);
    }

}
