package org.fortyoteam.darsasystem.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.fortyoteam.darsasystem.config.DarsaConfig;

public class AncientHealingBall {

    public AncientHealingBall(PlayerInteractEvent e, Player player) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
            for (Team team : sb.getTeams()) {
                if (team.getEntries().contains(player.getName())) {
                    for (String memberName : team.getEntries()) {
                        Player member = Bukkit.getPlayer(memberName);
                        member.setHealth(member.getMaxHealth());
                        member.getWorld().playSound(member, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 2, 2);
                    }
                }
            }
            Bukkit.getServer().broadcastMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GOLD + ChatColor.BOLD + player.getName() + ChatColor.translateAlternateColorCodes('&'," &aMenggunakan Item Suci &e&lAncient Healing Ball"));

        }
    }
}
