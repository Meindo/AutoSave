package net.minigameking.autosave.utils;

import net.minigameking.autosave.AutoSave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class autosaveinfo {
    static Updater updater = new Updater(AutoSave.getPlugin(AutoSave.class), "https://api.minigameking.net/AutoSave.html");
    public static void sendInfo(Player pl){
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Server running AutoSave V" + LManager.PDFVersion +  " by MiniGameKing"));
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Current AutoSave State: " + saveservr.automatic));
        if(!(updater.needsUpdate())){
            pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Running latest version of AutoSave"));
        } else{
            if(updater.needsUpdate()){
                pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Running AutoSave V" + LManager.PDFVersion +  ", latest is " + Updater.version));
                pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Please update as fast as possible by restarting the server"));
            }
        }

    }
    public static void sendUsage(Player pl){
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Usage: Enable/Disable/Stats"));
    }
    public static void consoleMSG(){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &cConsole cannot use autosave command"));
    }
    public static void enableMSG(){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3AutoSave  Enabled"));
    }
    public static void sendNoPerm(Player pl){
        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &CYou do not have permission to use this command."));
    }
}
