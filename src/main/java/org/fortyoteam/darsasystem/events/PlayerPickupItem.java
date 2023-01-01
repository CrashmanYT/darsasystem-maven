package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.fortyoteam.darsasystem.commands.BlacksmithCommand;
import org.fortyoteam.darsasystem.type.Tier;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
        Tier tier = new BlacksmithCommand().setItemTier(e.getPlayer(), e.getItem().getItemStack(), true, false);
        e.setCancelled(tier.isCancel());
        // remove item/block when player picked
        if (e.isCancelled()) {
            e.getPlayer().getInventory().addItem(tier.getItem());
            e.getItem().remove();

        }
    }
}
