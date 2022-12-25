package org.fortyoteam.darsasystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;


import java.util.ArrayList;
import java.util.List;

public class Shop implements CommandExecutor {

    public static Inventory shopGui;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;
        createShop((Player) sender);

        return true;
    }
    public static void createShop(Player player) {
        Merchant shop = Bukkit.createMerchant(ChatColor.translateAlternateColorCodes('&', "&b┌&2&o&lDarsa&6&o&lShop&b┘"));

        List<MerchantRecipe> items = new ArrayList<>();
        items.add(AddItem(Material.END_STONE, Material.GOLD_INGOT, 32, 1));
        items.add(AddItem(Material.BLACKSTONE, Material.GOLD_INGOT, 32, 1));
        items.add(AddItem(Material.NETHERRACK, Material.GOLD_INGOT, 32, 1));
        items.add(AddItem(Material.CHISELED_QUARTZ_BLOCK, Material.GOLD_INGOT, 32, 6));
        items.add(AddItem(Material.QUARTZ_BLOCK, Material.GOLD_INGOT, 32, 5));
        items.add(AddItem(Material.GLOWSTONE, Material.GOLD_INGOT, 8, 1));
        items.add(AddItem(Material.SPONGE, Material.GOLD_INGOT, 3, 7));

        shop.setRecipes(items);

        ((Player) player).openMerchant(shop, true);
    }

    private static MerchantRecipe AddItem(Material result, Material money, int count ,int price) {
        MerchantRecipe item = new MerchantRecipe(new ItemStack(result, count), 10000);
        item.addIngredient(new ItemStack(money, price));
        return item;
    }
}

