package org.fortyoteam.darsasystem.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.commands.Shop;
import org.fortyoteam.darsasystem.config.DarsaConfig;

import java.util.ArrayList;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        // Shop Events
        if (e.getInventory().equals(Shop.shopGui)) {
            e.setCancelled(true);

            ItemStack buyedItem = e.getCurrentItem();
            ItemMeta meta = buyedItem.getItemMeta();
            int price = Integer.parseInt(new StringBuilder(meta.getLore().get(0).replaceAll("[^0-9]", "")).deleteCharAt(0).toString());
            meta.setLore(new ArrayList<>());

            if (!player.getInventory().contains(Material.GOLD_INGOT, price)) {
                player.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.RED +"Emas Anda Kurang");
                return;
            }
            player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, price));
            player.getInventory().addItem(buyedItem);
            player.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GREEN + "Berhasi melakukan pembelian! ");
        }
    }
}
