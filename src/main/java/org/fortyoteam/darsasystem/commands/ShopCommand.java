package org.fortyoteam.darsasystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;

public class ShopCommand implements CommandExecutor {

    public static Inventory categoryShop;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;
        createShop((Player) sender);

        return true;
    }
    public static void createShop(Player player) {
        String title = ChatColor.translateAlternateColorCodes('&', "&2&km&2&o&lDarsa&6&o&lShop&6&km");

        categoryShop = Bukkit.createInventory(null, 9, title);
//        categoryShop.setItem(0, new CategoryItem(Material.DIAMOND, "&b&lCategory", CategoryType.NOTHING));
//        categoryShop.setItem(2, new CategoryItem(Material.PEONY, "&e&lDecoration Blocks", CategoryType.DECORATIONS_BLOCKS));
//        categoryShop.setItem(3, new CategoryItem(Material.BREAD, "&a&lFoods", CategoryType.FOODS));
//        categoryShop.setItem(4, new CategoryItem(Material.GRASS_BLOCK, "&2&lEarth Blocks", CategoryType.EARTH_BLOCKS));
//        categoryShop.setItem(5, new CategoryItem(Material.PRISMARINE, "&b&lSea Blocks", CategoryType.SEA_BLOCKS));
//        categoryShop.setItem(6, new CategoryItem(Material.NETHERRACK, "&4&lNether Blocks", CategoryType.NETHER_BLOCKS));
//        categoryShop.setItem(7, new CategoryItem(Material.END_STONE, "&f&lEnd Blocks", CategoryType.END_BLOCKS));

        player.openInventory(categoryShop);
    }


    public static void startEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        player.sendMessage("tset");
        if (event.getInventory().equals(categoryShop)) {
            event.setCancelled(true);
        }
    }
}

