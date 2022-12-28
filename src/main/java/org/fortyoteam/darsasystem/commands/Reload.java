package org.fortyoteam.darsasystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.fortyoteam.darsasystem.config.DarsaConfig;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        ItemConfig.reload();
        sender.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GREEN +"Berhasil memperbarui file konfigurasi");

        return true;
    }
}
