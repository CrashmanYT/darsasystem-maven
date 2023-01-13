package org.fortyoteam.darsasystem;


import org.bukkit.plugin.java.JavaPlugin;
import org.fortyoteam.darsasystem.commands.*;
import org.fortyoteam.darsasystem.completer.*;
import org.fortyoteam.darsasystem.config.BlacksmithConfig;
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

        BlacksmithConfig.setup();
        BlacksmithConfig.get().options().copyDefaults(true);
        BlacksmithConfig.save();
        // Config Commands
        getCommand("dsr").setExecutor(new ReloadCommand());

        getCommand("gvc").setExecutor(new GiveCoreCommand());

        getCommand("darsabuff").setExecutor(new BuffCommand());
        getCommand("darsabuff").setTabCompleter(new BuffCompleter());

        getCommand("darsablacksmith").setExecutor(new BlacksmithCommand());

        getCommand("darsaitem").setExecutor(new DarsaItemCommand());
        getCommand("darsaitem").setTabCompleter(new DarsaItemsCompleter());

        getCommand("darsahelp").setExecutor(new HelpCommand(this));

        getCommand("darsashop").setExecutor(new ShopCommand());


        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new EntityResurrect(), this);
        getServer().getPluginManager().registerEvents(new EntityShootBow(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
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
