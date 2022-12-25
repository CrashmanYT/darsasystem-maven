package org.fortyoteam.darsasystem.commands;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;
import org.fortyoteam.darsasystem.config.DarsaConfig;
import org.fortyoteam.darsasystem.enums.ErrorMessage;

public class Buff implements CommandExecutor {
    public static boolean BUFF_TOGGLE = false;

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg) {
        // TODO Auto-generated method stub
        if (arg.length == 0) {
            sender.sendMessage(DarsaConfig.ERROR_MESSAGE.get(ErrorMessage.EMPTY_ARGUMENTS));
            return true;
        }
        sender.sendMessage(arg[0]);
        if (arg[0].equals("supermine")) {
            toggleBuff(new PotionEffect[] {
                    new PotionEffect(PotionEffectType.FAST_DIGGING, 15000, 1)
            }, sender, ChatColor.GOLD + "" + ChatColor.BOLD + "Super Mine");
            return true;
        }
        if (arg[0].equals("fighterspirit")) {
            toggleBuff(new PotionEffect[] {
                    new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15000, 0),
                    new PotionEffect(PotionEffectType.SPEED, 15000, 0),
                    new PotionEffect(PotionEffectType.REGENERATION, 15000, 1),
                    new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15000, 0),
            }, sender, ChatColor.RED + "" + ChatColor.BOLD + "Fighter Spirit");
            return true;
        }

        return false;
    }

    private void toggleBuff(PotionEffect[] effects, CommandSender sender, String buffName) {
        if (BUFF_TOGGLE) {
            for (Player players : sender.getServer().getOnlinePlayers()) {
                for (PotionEffect effect : players.getActivePotionEffects()) {
                    players.removePotionEffect(effect.getType());
                }
                players.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.RED + " Sistem menonaktifkan " + buffName);
            }
            BUFF_TOGGLE = false;
        } else {
            for (Player players : sender.getServer().getOnlinePlayers()) {
                for (PotionEffect effect : effects) {
                    players.addPotionEffect(effect);
                }
                players.sendMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GREEN + " Sistem mengaktifkan " + buffName);
            }
            BUFF_TOGGLE = true;
        }
    }


}
