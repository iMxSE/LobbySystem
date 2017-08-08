package us.insanity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("broadcast")
					|| label.equalsIgnoreCase("alert") && p.hasPermission("hub.alert")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Usage: /" + label + " <message>");
					return true;
				}
				StringBuilder message = new StringBuilder("");
				for (String part : args) {
					if (!message.toString().equals(""))
						message.append(" ");
					message.append(part);
				}
				Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + p.getName()
						+ ChatColor.GRAY + "] " + ChatColor.AQUA + message.toString());
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}