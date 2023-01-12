package org.fortyoteam.darsasystem.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BlacksmithConfig {

    private static File file;
    private static FileConfiguration blacksmithConfig;

    public static void setup() {
        file = new File(Bukkit.getPluginManager().getPlugin("DarsaSystem").getDataFolder(), "blacksmith.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignored) {}
        }
        blacksmithConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {return blacksmithConfig; }

    public static void save() {
        try {
            blacksmithConfig.save(file);
        } catch (IOException ignored) {}
    }

    public static void reload() { blacksmithConfig = YamlConfiguration.loadConfiguration(file); }
}
