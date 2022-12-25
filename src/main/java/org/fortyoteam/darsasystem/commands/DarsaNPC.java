package org.fortyoteam.darsasystem.commands;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.PlayerInteractManager;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.profile.PlayerProfile;

import java.util.UUID;

public class DarsaNPC implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

//        if (args[0].isBlank()) return true;
//        MinecraftServer nmsServer = (MinecraftServer) Bukkit.getServer();
//        WorldServer nmsWorld = (WorldServer) ((Player) sender).getWorld();
//
//        switch (args[0]) {
//            case "create":
//                createNpc(nmsServer, nmsWorld);
//        }
        return false;

    }

    public static void createNpc(MinecraftServer nmsServer, WorldServer nmsWorld) {
        PlayerProfile player = Bukkit.createPlayerProfile(UUID.randomUUID(), "Shop");

    }
}
