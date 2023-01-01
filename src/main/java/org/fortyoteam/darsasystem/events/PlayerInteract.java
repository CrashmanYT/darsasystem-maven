package org.fortyoteam.darsasystem.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.fortyoteam.darsasystem.commands.DarsaItemCommand;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            DarsaItemCommand.isDarsaItem(e);

    }


}
