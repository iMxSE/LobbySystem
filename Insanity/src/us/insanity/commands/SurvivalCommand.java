package us.insanity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("gms") && p.hasPermission("hub.gms")) {
				if (p.getGameMode() == GameMode.SURVIVAL) {
					p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ERROR " + ChatColor.RED
							+ "You are already in Survival Mode.");
					return true;
				}
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(ChatColor.DARK_AQUA.toString() + "" + ChatColor.BOLD + "SUCCESS" + ChatColor.AQUA
						+ " You have changed your game-mode to Survival Mode.");
				for (Player s : Bukkit.getOnlinePlayers()) {
					if (s.hasPermission("hub.notify")) {
						s.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA.toString() + ChatColor.BOLD.toString()
								+ ChatColor.MAGIC + "|" + ChatColor.GRAY + "] " + ChatColor.AQUA + p.getName()
								+ ChatColor.GRAY + " has changed their game-mode to " + ChatColor.GOLD + "Survival Mode"
								+ ChatColor.GRAY + ".");
					}
				}
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}
