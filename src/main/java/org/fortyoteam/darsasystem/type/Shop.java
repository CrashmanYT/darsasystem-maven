package org.fortyoteam.darsasystem.type;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.enums.ButtonType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {

    private static List<Inventory> page = new ArrayList<>();

    public static Inventory createShop(String title ,SelledItem[] items, boolean isNewPage) {
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

        if (isNewPage) {
            shop.setItem(51, createButton(Material.REDSTONE, ButtonType.PREVIOUS_PAGE,"Previous Page", new String[]{"Go To Previous Page"}));
            shop.setItem(52, createButton(Material.REDSTONE, ButtonType.CLOSE_INV,"Close Shop", new String[]{"Close this shop"}));
            shop.setItem(53, createButton(Material.REDSTONE, ButtonType.NEXT_PAGE,"Next Page", new String[]{"Go To Next Page"}));
            page.add(shop);
        }
        return isNewPage ? page.get(page.indexOf(shop)) : shop;

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
        return createShop(title, items, true);
    }

    private static Button createButton(Material material, ButtonType type, String name, String[] lore) {
        Button item = new Button(material, type, name, lore);
        return item;
    }

}


