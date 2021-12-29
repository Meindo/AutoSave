package net.minigameking.autosave;

import net.minigameking.autosave.commands.AutoSaveCMD;
import net.minigameking.autosave.commands.save;
import net.minigameking.autosave.commands.tabCompleter;
import net.minigameking.autosave.utils.LManager;
import net.minigameking.autosave.utils.Updater;
import net.minigameking.autosave.utils.saveservr;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoSave extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("save").setExecutor(new save());
        this.getCommand("autosave").setExecutor(new AutoSaveCMD());
        this.getCommand("autosave").setTabCompleter(new tabCompleter());
        runnable();
        Updater spu = new Updater(this, "https://api.minigameking.net/AutoSave.html");
        spu.enableOut();
        if(spu.needsUpdate()){
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Auto&2Save&8] &3Detected an plugin update, downloading now..."));
            spu.update();
        }

    }


    public static void runnable(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(AutoSave.getPlugin(AutoSave.class), new Runnable() {
            @Override
            public void run() {
                if (saveservr.automatic){
                    saveservr.saveServer();
                }

            }
        }, 0, 36000);
    }
}
