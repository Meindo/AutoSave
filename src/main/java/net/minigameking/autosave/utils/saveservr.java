package net.minigameking.autosave.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class saveservr {
    public static Boolean automatic = true;
    public static void saveServer(){
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "save-all");
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Saved the server"));
    }
}
