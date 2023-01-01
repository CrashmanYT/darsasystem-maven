package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.fortyoteam.darsasystem.commands.BlacksmithCommand;

public class PrepareItemCraft implements Listener {

    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent e) {
        if (e == null || e.getInventory().getResult() == null) return;
        e.getInventory().setResult(new BlacksmithCommand().setItemTier((Player) e.getView().getPlayer(), e.getInventory().getResult(), false, false).getItem());
    }
}
