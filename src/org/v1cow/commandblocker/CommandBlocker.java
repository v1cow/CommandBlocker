package org.v1cow.commandblocker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class CommandBlocker extends JavaPlugin {

    public static CommandBlocker plugin;

    public String blockmsg ;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(new CommandBlockerListener(this), this);
        this.loadConfigs();
    }

    public String translateToColorCode(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void loadConfigs() {
        this.saveDefaultConfig();

        this.blockmsg = this.translateToColorCode(this.getConfig().getString("blockmsg"));
    }
}