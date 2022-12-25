package org.fortyoteam.darsasystem;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.function.Function;

public abstract class SubCommand {
    void onCommand(Player player, Command command, String s, String[] args) {

    }
}
