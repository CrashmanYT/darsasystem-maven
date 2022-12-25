package org.fortyoteam.darsasystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Help implements CommandExecutor {
    JavaPlugin plugin;
    public Help(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Plugin : &a&lDarsa&6&lSystem\n"));
        sender.sendMessage("  ");
        sender.sendMessage(ChatColor.YELLOW  + "Commands(s) :  ");
        sender.sendMessage(ChatColor.YELLOW  + "-------------  ");
        plugin.getDescription().getCommands().forEach((key, cmd) -> {
            sender.sendMessage(ChatColor.GOLD + "" + cmd.get("usage") + ChatColor.translateAlternateColorCodes('&', " - &a" + (String) cmd.get("description")));

        });


        return false;
    }
}
