package us.insanity;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.signatured.ezqueuespigot.EzQueueAPI;
import us.insanity.commands.AdventureCommand;
import us.insanity.commands.BroadcastCommand;
import us.insanity.commands.ClearChatCommand;
import us.insanity.commands.CreativeCommand;
import us.insanity.commands.FlightCommand;
import us.insanity.commands.HelpCommand;
import us.insanity.commands.StoreCommand;
import us.insanity.commands.SurvivalCommand;
import us.insanity.commands.TeamSpeakCommand;
import us.insanity.items.ItemJoin;
import us.insanity.selector.SelectorClass;
import us.insanity.Main;
import us.insanity.listeners.AsyncPlayerChat;
import us.insanity.listeners.BlockBreak;
import us.insanity.listeners.BlockPlace;
import us.insanity.listeners.DoubleJump;
import us.insanity.listeners.DropItem;
import us.insanity.listeners.PickupItem;
import us.insanity.listeners.PlayerJoin;
import us.insanity.listeners.PlayerQuit;
import us.insanity.listeners.PopPlayer;
import us.insanity.listeners.TeleportBow;
import us.insanity.listeners.VisibilityToggleListener;
import us.insanity.listeners.useless.CraftItem;
import us.insanity.listeners.useless.CreatureSpawn;
import us.insanity.listeners.useless.EntityDamage;
import us.insanity.listeners.useless.ExplosionPrime;
import us.insanity.listeners.useless.FoodLevelChange;
import us.insanity.listeners.useless.InventoryOpen;
import us.insanity.listeners.useless.LightningStrike;
import us.insanity.listeners.useless.PlayerExpChange;
import us.insanity.listeners.useless.PortalCreate;
import us.insanity.listeners.useless.WeatherChange;
import us.insanity.scoreboard.ScoreboardObject;
import us.insanity.scoreboard.ScoreboardObjectHandler;
import us.insanity.tablist.PlayerTab;

import net.milkbowl.vault.permission.Permission;
import net.minecraft.util.org.apache.commons.lang3.StringEscapeUtils;

import java.util.*;

import java.text.*;

import org.bukkit.plugin.*;

public class Main extends JavaPlugin implements Listener {
	
	
	PluginManager pm;
    private ScoreboardObjectHandler scoreboardDataHandler;
    private DecimalFormat formatter;
    public static Permission perms;
    private static Main plugin;
    private List<String> base;
    private String bars;
    private String title;
	private static Main instance;
	public String LINE = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH
			+ "---*---------------------------------------------*---";
	
	static {
        Main.perms = null;
    }
    
    public Main() {
        this.scoreboardDataHandler = new ScoreboardObjectHandler(this);
        this.pm = Bukkit.getServer().getPluginManager();
        this.formatter = new DecimalFormat("0.0");
    }

	
	public void onEnable() {
		instance = this;
		this.getServer().getPluginManager().registerEvents(new CraftItem(), this);
		this.getServer().getPluginManager().registerEvents(new CreatureSpawn(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		this.getServer().getPluginManager().registerEvents(new DoubleJump(), this);
		this.getServer().getPluginManager().registerEvents(new ExplosionPrime(), this);
		this.getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
		this.getServer().getPluginManager().registerEvents(new InventoryOpen(), this);
		this.getServer().getPluginManager().registerEvents(new LightningStrike(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerExpChange(), this);
		this.getServer().getPluginManager().registerEvents(new PortalCreate(), this);
		this.getServer().getPluginManager().registerEvents(new WeatherChange(), this);
		this.getServer().getPluginManager().registerEvents(new AsyncPlayerChat(), this);
		this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		this.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		this.getServer().getPluginManager().registerEvents(new DropItem(), this);
		this.getServer().getPluginManager().registerEvents(new PickupItem(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerTab(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new SelectorClass(), this);
		this.getServer().getPluginManager().registerEvents(new PopPlayer(), this);
		this.getServer().getPluginManager().registerEvents(new TeleportBow(), this);
		this.getServer().getPluginManager().registerEvents(new VisibilityToggleListener(), this);
		this.getServer().getPluginManager().registerEvents(new ItemJoin(), this);

		getCommand("gma").setExecutor(new AdventureCommand());
		getCommand("gms").setExecutor(new SurvivalCommand());
		getCommand("gmc").setExecutor(new CreativeCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("alert").setExecutor(new BroadcastCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("fly").setExecutor(new FlightCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("?").setExecutor(new HelpCommand());
		getCommand("store").setExecutor(new StoreCommand());
		getCommand("buy").setExecutor(new StoreCommand());
		getCommand("ts").setExecutor(new TeamSpeakCommand());
		getCommand("teamspeak").setExecutor(new TeamSpeakCommand());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
		
		this.scoreboardDataHandler.enable();
        this.setupScoreboard();
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
		
	}
	
	public void setupScoreboard() {
        new BukkitRunnable() {
            public void run() {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player player = onlinePlayers[i];
                    final ScoreboardObject scoreboard = Main.this.scoreboardDataHandler.getScoreboardFor(player);
                    scoreboard.clear();
                    scoreboard.add("&7&m--------------------------------");
                    scoreboard.add("&3&lName: &f" + player.getName());
                    scoreboard.add("");
                    scoreboard.add("&3&lRank: &f" + Main.this.getRank(player));
                    scoreboard.add("");
                    if (EzQueueAPI.getQueue(player) != null) {
                        final int spot = EzQueueAPI.getPosition(EzQueueAPI.getQueue(player));
                        scoreboard.add("&bQueued for&7:");
                        scoreboard.add("  &c" + Main.getQueuedServer(player));
                        scoreboard.add("  &cPosition: &f#" + spot + " of " + EzQueueAPI.getQueueSize(Main.getQueuedServer(player)));
                        scoreboard.add("");
                    }
                    scoreboard.add("&bwww.insanity.com");
                    scoreboard.add("&7&m--------------------------------");
                    scoreboard.update(player);
                }
            }
        }.runTaskTimer((Plugin)this, 2L, 2L);
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
    }
    
    public DecimalFormat getDecimalFormatter() {
        return this.formatter;
    }
    
    public String translate(final String input) {
        return StringEscapeUtils.unescapeJava(ChatColor.translateAlternateColorCodes('&', input));
    }
    
    public List<String> translate(final List<String> input) {
        final List<String> text = new ArrayList<String>();
        for (final String string : input) {
            text.add(this.translate(string));
        }
        return text;
    }
    
    public String getOnlineAmount() {
        int counter = 0;
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player p = onlinePlayers[i];
            ++counter;
        }
        return String.valueOf(counter);
    }
    
    public String getRank(final Player p) {
        if (p.hasPermission("player.owner")) {
            return "&fOwner";
        }
        if (p.hasPermission("player.default")) {
            return "&fNone";
        }
        if (p.hasPermission("player.plat")) {
            return "&fSenior-Admin";
        }
        if (p.hasPermission("player.dev")) {
        	return "&fDeveloper";
        }
        if (p.hasPermission("player.admin")) {
            return "&fAdmin";
        }
        if (p.hasPermission("player.mod")) {
            return "&fModerator";
        }
        if (p.hasPermission("player.smod")) {
            return "&fSenior-Mod";
        }
        if (p.hasPermission("player.tmod")) {
        	return "&fTrial-Mod";
        }
        if (p.hasPermission("player.helper")) {
            return "&fHelper";
        }
        if (p.hasPermission("player.Manager")) {
        	return "&fManager";
        }
        if (p.hasPermission("player.hmod")) {
        	return "&fHead-Mod";
        }
        if (p.hasPermission("player.builder")) {
        	return "&fBuilder";
        }
        if (p.hasPermission("player.lord")) {
            return "&fLord";
        }
        if (p.hasPermission("player.ultra")) {
            return "&fUltra";
        }
        if (p.hasPermission("player.titan")) {
            return "&fTitan";
        }
        if (p.hasPermission("player.legend")) {
            return "&fLegend";
        }
        if (p.hasPermission("player.eternal")) {
        	return "&fEternal";
        }
        if (p.hasPermission("player.hero")) {
        	return "&fHero";
        }
        return Main.perms.getPrimaryGroup(p);
    }
    
    public static String getQueuedServer(final Player p) {
        final String server = EzQueueAPI.getQueue(p);
        if (server.equalsIgnoreCase("hcf")) {
            return "HCF";
        }
        if (server.equalsIgnoreCase("practice")) {
            return "Practice";
        }
        if (server.equalsIgnoreCase("development")) {
            return "Development";
        }
        return null;
    }
    
    public static Main getPlugin() {
        return Main.plugin;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
}

