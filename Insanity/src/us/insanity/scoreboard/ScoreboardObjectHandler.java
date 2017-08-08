package us.insanity.scoreboard;

import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.scoreboard.*;

import us.insanity.*;

import org.bukkit.event.*;
import java.util.*;
import org.bukkit.event.player.*;

public class ScoreboardObjectHandler extends Handler implements Listener
{
    private Map<UUID, ScoreboardObject> sbData;
    
    public ScoreboardObjectHandler(final Main plugin) {
        super(plugin);
        this.sbData = new HashMap<UUID, ScoreboardObject>();
    }
    
    @Override
    public void enable() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            this.loadData(player);
        }
        Main.getInstance().getServer().getPluginManager().registerEvents((Listener)this, (Plugin)Main.getInstance());
    }
    
    public void reload() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            this.reloadData(player);
        }
    }
    
    public ScoreboardObject getScoreboardFor(final Player player) {
        return this.sbData.get(player.getUniqueId());
    }
    
    public void loadData(final Player player) {
        final Scoreboard scoreboard = Main.getInstance().getServer().getScoreboardManager().getNewScoreboard();
        player.setScoreboard(scoreboard);
        this.sbData.put(player.getUniqueId(), new ScoreboardObject(scoreboard, ChatColor.translateAlternateColorCodes('&', "&3&lInsanity&b&lNetwork")));
    }
    
    public void reloadData(final Player player) {
        if (this.sbData.containsKey(player.getUniqueId())) {
            final Scoreboard scoreaboard = player.getScoreboard();
            player.setScoreboard(scoreaboard);
            this.sbData.put(player.getUniqueId(), new ScoreboardObject(scoreaboard, ChatColor.translateAlternateColorCodes('&', "&3&lInsanity&b&lNetwork")));
        }
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        this.loadData(player);
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        for (final String entries : player.getScoreboard().getEntries()) {
            player.getScoreboard().resetScores(entries);
        }
        this.sbData.remove(player);
    }
    
    @EventHandler
    public void onPlayerKick(final PlayerKickEvent event) {
        final Player player = event.getPlayer();
        for (final String entries : player.getScoreboard().getEntries()) {
            player.getScoreboard().resetScores(entries);
        }
        this.sbData.remove(player);
    }
}