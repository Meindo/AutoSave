package net.minigameking.autosave.utils;

import net.minigameking.autosave.AutoSave;
import org.bukkit.plugin.PluginDescriptionFile;

public class LManager {
    public static PluginDescriptionFile pdf = AutoSave.getPlugin(AutoSave.class).getDescription();
    public static Float PDFVersion = ParseFloat.parse(pdf.getVersion());
}
