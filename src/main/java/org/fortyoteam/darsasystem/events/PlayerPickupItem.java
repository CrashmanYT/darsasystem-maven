package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.fortyoteam.darsasystem.commands.Blacksmith;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
        e.setCancelled((boolean) Blacksmith.setItemTier(e.getPlayer(), e.getItem().getItemStack(), true, false)[0]);

        if (e.isCancelled()) e.getItem().remove();
    }
}
