package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.fortyoteam.darsasystem.commands.BlacksmithCommand;

public class PrepareSmithing implements Listener {

    @EventHandler
    public void onPrepareSmithing(PrepareSmithingEvent e) {
        if (e == null || e.getResult() == null) return;
        e.setResult(new BlacksmithCommand().setItemTier((Player) e.getView().getPlayer(), e.getResult(), false, false).getItem());
    }
}
