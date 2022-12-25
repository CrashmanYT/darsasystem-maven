package org.fortyoteam.darsasystem.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.config.ItemConfig;
import org.fortyoteam.darsasystem.items.FrostSword;

import java.util.ArrayList;

public class DarsaItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) return false;

        Player player = (Player) sender;
        Material type = Material.getMaterial(ItemConfig.get().getString(args[0] + ".Type"));
        String tier = ItemConfig.get().getString(args[0] + ".Tier");
        String name = ItemConfig.get().getString(args[0] + ".DisplayName");
        ArrayList<String> lore = (ArrayList<String>) ItemConfig.get().getList(args[0] + ".Lore");

        if (lore.size() < 2) lore.add(tier);
        lore.set(1,tier);


        // set text color for lore
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i,ChatColor.translateAlternateColorCodes('&', lore.get(i)));
        }

        ItemStack item = new ItemStack(type, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        meta.setLore(lore);

        item.setItemMeta(meta);

        player.getInventory().addItem(item);


        return false;
    }

    public static void setEvent(PlayerInteractEvent e, String itemname) {
        switch (itemname) {
            case "frostsword":
                FrostSword.frostSwordEvent(e);
                break;
            case "phoenixaxe":
                e.getPlayer().sendMessage("phoenixaxe activated");

            default:

        }
    }


}
