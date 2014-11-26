package in.twizmwaz.cardinal.match.listeners;

import in.twizmwaz.cardinal.GameHandler;
import in.twizmwaz.cardinal.match.Match;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by kevin on 11/20/14.
 */
public class ConnectionListener implements Listener {

    private final JavaPlugin plugin;
    private final Match match;

    public ConnectionListener(JavaPlugin plugin, Match match) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
        this.match = match;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setScoreboard(match.getScoreboard());
        GameHandler.getGameHandler().getMatch().getTeamById("observers").add(event.getPlayer());
        event.getPlayer().teleport(match.getTeamById("observers").getSpawnPoint());
    }

}