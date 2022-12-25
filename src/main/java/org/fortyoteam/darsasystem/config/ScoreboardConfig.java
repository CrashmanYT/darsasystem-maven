package org.fortyoteam.darsasystem.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class ScoreboardConfig {

    private static File file;
    private static FileConfiguration scoreboardConfig;

    public static void setup() {
        file = new File(Bukkit.getPluginManager().getPlugin("DarsaSystem").getDataFolder(), "scoreboard.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignored) {}
        }
        scoreboardConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {return scoreboardConfig; }

    public static void save() {
        try {
            scoreboardConfig.save(file);
        } catch (IOException ignored) {}
    }

    public static void reload() { scoreboardConfig = YamlConfiguration.loadConfiguration(file); }
}
