package org.fortyoteam.darsasystem.misc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.events.InventoryClick;

import java.util.Arrays;

public class Blacksmith {

    String displayName;
    Inventory inv;
    Player player;

    public Blacksmith(Player player) {
        this.player = player;
    }

    public void showGui() {
        Inventory inv = Bukkit.createInventory(null, InventoryType.ANVIL, this.displayName);

        this.player.openInventory(inv);
        this.inv = inv;
    }

    public void setDisplayName(String displayName) { this.displayName = ChatColor.translateAlternateColorCodes('&', displayName);}
    public String getDisplayName() { return this.displayName; }
    public Inventory getInventory() {return this.inv; }

    public void setRecipe(InventoryClickEvent event) {
//        if (event.getInventory().getType() == InventoryType.ANVIL) {
//            AnvilInventory inv = (AnvilInventory) event.getInventory();
//
//            ItemStack tools = inv.getItem(0);
//            ItemStack ingredient = inv.getItem(1);
//            this.player.sendMessage("test");
//            this.player.sendMessage(tools.getType().name() + "," + ingredient.getType().name());
//        }
    }
}
