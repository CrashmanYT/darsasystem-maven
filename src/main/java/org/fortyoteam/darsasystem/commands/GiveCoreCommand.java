package org.fortyoteam.darsasystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.type.MyItem;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class GiveCoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        HashMap<String, ItemStack> cores = new HashMap<>();

        cores.put("red", MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&c&lRED CORES"));
        cores.put("blue", MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&1&lBLUE CORES"));
        cores.put("green", MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&2&lGREEN CORES"));
        cores.put("yellow", MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&6&lYELLOW CORES"));

        if (args.length > 1) {
            Player player = Bukkit.getPlayer(args[0]);
            ItemStack core = cores.get(args[1]);

            player.getInventory().addItem(core);
        }

        return true;
    }
}
