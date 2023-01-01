package org.fortyoteam.darsasystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.type.Shop;


import java.util.Arrays;

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
        categoryShop.setItem(0, setDisplayName(new ItemStack(Material.DIAMOND), "&b&lCategory"));
        categoryShop.setItem(2, setDisplayName(new ItemStack(Material.PEONY), "&e&lDecoration Blocks"));
        categoryShop.setItem(3, setDisplayName(new ItemStack(Material.BREAD), "&a&lFoods"));
        categoryShop.setItem(4, setDisplayName(new ItemStack(Material.GRASS_BLOCK), "&2&lEarth Blocks"));
        categoryShop.setItem(5, setDisplayName(new ItemStack(Material.PRISMARINE), "&b&lSea Blocks"));
        categoryShop.setItem(6, setDisplayName(new ItemStack(Material.NETHERRACK), "&4&lNether Blocks"));
        categoryShop.setItem(7, setDisplayName(new ItemStack(Material.END_STONE), "&f&lEnd Blocks"));


        player.openInventory(categoryShop);
    }

    private static ItemStack AddItem(Material material, Material money, int count ,int price) {
        ItemStack item = new ItemStack(material, count);
        ItemMeta meta = item.getItemMeta();
        String[] lore = {"Price : " + price + " Gold"};
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack setLore(ItemStack item, String[] lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack setDisplayName(ItemStack item, String displayName) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        item.setItemMeta(meta);
        return item;
    }

    public static void startEvent(InventoryClickEvent event) {
        if (event.getInventory().equals(categoryShop)) {

        }
    }
}

