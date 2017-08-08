package us.insanity.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdventureCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("gma") && p.hasPermission("hub.gma")) {
				if (p.getGameMode() == GameMode.ADVENTURE) {
					p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ERROR " + ChatColor.RED
							+ "You are already in Adventure Mode.");
					return true;
				}
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage(ChatColor.DARK_AQUA.toString() + "" + ChatColor.BOLD + "SUCCESS" + ChatColor.AQUA
						+ " You have changed your game-mode to Adventure Mode.");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}