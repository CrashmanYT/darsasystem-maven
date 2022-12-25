package org.fortyoteam.darsasystem.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ItemConfig {

    private static File file;
    private static FileConfiguration itemConfigFile;

    public static void setup() {
        file = new File(Bukkit.getPluginManager().getPlugin("DarsaSystem").getDataFolder(), "item.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) { }
        }

        itemConfigFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return itemConfigFile;
    }

    public static void save() {
        try {
            itemConfigFile.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }

    public static void reload() {
        itemConfigFile = YamlConfiguration.loadConfiguration(file);
    }

}
