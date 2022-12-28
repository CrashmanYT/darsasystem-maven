package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.fortyoteam.darsasystem.commands.Blacksmith;
import org.fortyoteam.darsasystem.type.Tier;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
        Tier tier = new Blacksmith().setItemTier(e.getPlayer(), e.getItem().getItemStack(), true, false);
        e.setCancelled(tier.isCancel());
        // remove item/block when player picked
        if (e.isCancelled()) {
            e.getItem().remove();

        }
    }
}
