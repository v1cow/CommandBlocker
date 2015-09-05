package org.v1cow.commandblocker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlockerListener implements Listener {

    public static CommandBlocker plugin;

    public CommandBlockerListener(CommandBlocker instance) {
        this.plugin = instance;
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onCommandProcess(PlayerCommandPreprocessEvent evt) {
        String commandpre = evt.getMessage();
        String[] finalcommand = commandpre.split(" ");
        String command = finalcommand[0].replaceAll("/", "");
        Player player = evt.getPlayer();

        for (String message : plugin.getConfig().getStringList("blockedcmds")) {

            if (command.equalsIgnoreCase(message)) {
                player.sendMessage(plugin.blockmsg);
                evt.setCancelled(true);
                return;
            }

        }
    }
}
