package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.fortyoteam.darsasystem.commands.BlacksmithCommand;

public class PrepareAnvil implements Listener {

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent e) {
        if (e == null || e.getResult() == null) return;

        e.setResult(new BlacksmithCommand().setItemTier((Player) e.getView().getPlayer(), e.getResult(), false, false).getItem());
    }
}
