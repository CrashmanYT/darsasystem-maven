package org.fortyoteam.darsasystem;


import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.commands.*;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.config.ScoreboardConfig;
import org.fortyoteam.darsasystem.events.*;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class Main extends JavaPlugin {
    public static JavaPlugin plugin;
    @Override
    public void onEnable() {

        plugin = this;
        // Load Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ItemConfig.setup();
        ItemConfig.get().options().copyDefaults(true);
        ItemConfig.save();

        ScoreboardConfig.setup();
        ScoreboardConfig.get().options().copyDefaults(true);
        ScoreboardConfig.save();
        // Config Commands
        getCommand("dsr").setExecutor(new Reload());

        getCommand("darsabuff").setExecutor(new Buff());
        getCommand("darsabuff").setTabCompleter(new BuffCompleter());

        getCommand("darsablacksmith").setExecutor(new Blacksmith());

        getCommand("darsaitem").setExecutor(new DarsaItem());
        getCommand("darsaitem").setTabCompleter(new DarsaItemsCompleter());

        getCommand("darsahelp").setExecutor(new Help(this));

        getCommand("darsashop").setExecutor(new Shop());


        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new EntityResurrect(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new InventoryMove(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpen(), this);
        getServer().getPluginManager().registerEvents(new InventoryDrag(), this);
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);
        getServer().getPluginManager().registerEvents(new CraftItem(), this);
        getServer().getPluginManager().registerEvents(new PrepareAnvil(), this);
        getServer().getPluginManager().registerEvents(new PrepareItemCraft(), this);
        getServer().getPluginManager().registerEvents(new PrepareSmithing(), this);

    }


}
