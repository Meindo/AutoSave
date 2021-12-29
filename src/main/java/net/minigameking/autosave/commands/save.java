package net.minigameking.autosave.commands;

import net.minigameking.autosave.utils.saveservr;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class save implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("save")){
            saveservr.saveServer();
        }
        return true;
    }
}
