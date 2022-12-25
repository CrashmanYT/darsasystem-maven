package org.fortyoteam.darsasystem.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.fortyoteam.darsasystem.config.ItemConfig;

import java.util.ArrayList;
import java.util.List;

public class DarsaItemsCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 1) {
            List<String> itemNames = new ArrayList<>();
            for (String item : ItemConfig.get().getKeys(false)) {
                itemNames.add(item);
            }
            return itemNames;
        }
        return null;
    }
}
