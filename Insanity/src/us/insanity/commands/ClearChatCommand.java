package us.insanity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("cc") && p.hasPermission("hub.cc")) {
				for (int i = 0; i < 100; i++) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage(ChatColor.GRAY + "Chat was cleared by " + ChatColor.AQUA.toString()
						+ ChatColor.BOLD + p.getName() + ChatColor.GRAY + ".");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}