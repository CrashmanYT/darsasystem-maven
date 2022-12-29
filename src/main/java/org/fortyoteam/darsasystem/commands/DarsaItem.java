package org.fortyoteam.darsasystem.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.fortyoteam.darsasystem.config.ItemConfig;
import org.fortyoteam.darsasystem.items.AncientHealingBall;
import org.fortyoteam.darsasystem.items.FierySword;
import org.fortyoteam.darsasystem.items.FrostSword;

import java.util.ArrayList;

public class DarsaItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) return false;

        Player player = (Player) sender;
        Material type = Material.getMaterial(ItemConfig.get().getString(args[0] + ".Type"));
        String tier = ChatColor.translateAlternateColorCodes('&', ItemConfig.get().getString(args[0] + ".Tier"));
        String name = ItemConfig.get().getString(args[0] + ".DisplayName");
        ArrayList<String> lore = (ArrayList<String>) ItemConfig.get().getList(args[0] + ".Lore");

        if (lore.contains(tier)) lore.remove(tier);
        lore.add(tier);


        // set text color for lore
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i,ChatColor.translateAlternateColorCodes('&', lore.get(i)));
        }

        ItemStack item = new ItemStack(type, 1);
        ItemMeta meta =  item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        // for item that have color (like leather armor)
        String color = ItemConfig.get().getString(args[0] + ".Color");
        player.sendMessage(color + "");

        // if item have color, set meta to LeatherArmorMeta
        if (color != null) {
            String[] rgbCode = color.split(",");
            LeatherArmorMeta leatherArmor = (LeatherArmorMeta) meta;
            leatherArmor.setColor(Color.fromRGB(
                    Integer.parseInt(rgbCode[0]),
                    Integer.parseInt(rgbCode[1]),
                    Integer.parseInt(rgbCode[2])
            ));
            leatherArmor.setLore(lore);
            item.setItemMeta(leatherArmor);

        } else {

            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        player.getInventory().addItem(item);


        return false;
    }

    public static void setEvent(PlayerInteractEvent e, String itemname) {
        switch (itemname) {
            case "frostsword":
                FrostSword.setEvent(e);
                break;
            case "fierysword":
                new FierySword(e);
                break;
            case "ancienthealball":
                new AncientHealingBall(e,e.getPlayer());
                break;
            default:

        }
    }
    public static void isDarsaItem(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        for (String key : ItemConfig.get().getKeys(false)) {

            boolean isDarsaItem = false;
            String item = ItemConfig.get().getString(key + ".DisplayName");
            isDarsaItem = e.getItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',item));
            if (isDarsaItem) setEvent(e, key);

        }
    }

}
