package org.fortyoteam.darsasystem.events;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.fortyoteam.darsasystem.commands.DarsaItem;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            DarsaItem.isDarsaItem(e);

    }


}
