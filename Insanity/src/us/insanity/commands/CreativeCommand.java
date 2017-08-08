package us.insanity.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("gmc") && p.hasPermission("hub.gmc")) {
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ERROR " + ChatColor.RED
							+ "You are already in Creative Mode.");
					return true;
				}
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(ChatColor.DARK_GREEN.toString() + "" + ChatColor.BOLD + "SUCCESS" + ChatColor.AQUA
						+ " You have changed your game-mode to Creative Mode.");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as Console.");
		return true;
	}
}