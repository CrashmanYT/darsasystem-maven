package org.fortyoteam.darsasystem.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.fortyoteam.darsasystem.config.ScoreboardConfig;
import org.fortyoteam.darsasystem.events.PlayerDeath;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DScoreboard {
    private static final ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static Scoreboard scoreboard = manager.getNewScoreboard();
    private static Collection<? extends Player> onlinePlayers;
    private static Objective sideBar;

    public DScoreboard(Collection<? extends Player> players) {
        onlinePlayers = players;
        ArrayList<String>scoreboardLines = (ArrayList<String>) ScoreboardConfig.get().getStringList("scoreboard.lines");
        String displayName = ScoreboardConfig.get().getString("scoreboard.displayname");

        if (scoreboard.getObjective("sidebar") == null) {
            sideBar = scoreboard.registerNewObjective("sidebar", "sidebar", ChatColor.translateAlternateColorCodes('&', displayName));
            sideBar.setDisplaySlot(DisplaySlot.SIDEBAR);
            for (Player player : players) {

                int lineCount = 1;
                for (int i = scoreboardLines.size() - 1; i >= 0; i--) {
                    Score score = setScore(player, scoreboardLines.get(i), sideBar);
                    score.setScore(lineCount);
                    ++lineCount;
                }
                player.setScoreboard(scoreboard);
            }

        }

    }

    private static Score setScore(Player player, String text, Objective objective) {
        return objective.getScore(ChatColor.translateAlternateColorCodes('&',checkPlaceholder(player, text)));
    }

    private static String checkPlaceholder(Player player, String text) {
        HashMap<String, Object> placeholder = new HashMap<>();
        HashMap<UUID, Integer> killsCount = PlayerDeath.killsCount;
        HashMap<UUID, Integer> deathsCount = PlayerDeath.deathsCount;
        placeholder.put("name", player.getDisplayName());
        placeholder.put("kills", killsCount.getOrDefault(player.getUniqueId(), 0));
        placeholder.put("deaths", deathsCount.getOrDefault(player.getUniqueId(), 0));

        String checkedLine = text;
        Pattern placeholderPattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher line = placeholderPattern.matcher(checkedLine);
        while (line.find()) {
            // Replace ${pattern} to placeholder key
            String result = placeholder.get(line.group(1)) + "";
            String pattern = line.group();
            checkedLine = checkedLine.replace(pattern, result);
        }

        return checkedLine;
    }


}
