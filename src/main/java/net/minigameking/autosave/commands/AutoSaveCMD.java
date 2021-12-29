package net.minigameking.autosave.commands;

import net.minigameking.autosave.utils.saveservr;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.minigameking.autosave.utils.autosaveinfo;
import org.bukkit.entity.Player;

public class AutoSaveCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("autosave")) {
            if (sender instanceof Player) {
                Player pl = (Player) sender;
                if (args.length == 0) {
                    if (pl.hasPermission("autosave.admin")){
                        autosaveinfo.sendUsage(pl);
                        return true;
                    } else{
                        autosaveinfo.sendInfo(pl);
                        return true;
                    }

                } if (pl.hasPermission("autosave.admin")) {
                    if (args[0].equalsIgnoreCase("enable")) {
                        saveservr.automatic = true;
                        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3AutoSave successfully set enabled"));
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("disable")) {
                        saveservr.automatic = false;
                        pl.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3AutoSave successfully set disabled"));
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("stats")) {
                        autosaveinfo.sendInfo(pl);
                    } else {
                        autosaveinfo.sendUsage(pl);
                    }
                } else {
                    autosaveinfo.sendNoPerm(pl);
                }
                return true;
            } else {
                autosaveinfo.consoleMSG();
                return true;
            }
        }
        return false;
    }
}
