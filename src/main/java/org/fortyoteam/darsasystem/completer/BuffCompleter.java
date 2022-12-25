package org.fortyoteam.darsasystem.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class BuffCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> buffNames = new ArrayList<>();
            buffNames.add("supermine");
            buffNames.add("fighterspirit");
        return buffNames;
        }
        return null;
    }
}
