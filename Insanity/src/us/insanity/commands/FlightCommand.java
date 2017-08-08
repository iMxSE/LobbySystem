package us.insanity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlightCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("fly") && p.hasPermission("hub.fly")) {
				p.setAllowFlight(!p.getAllowFlight());
				p.sendMessage(ChatColor.AQUA + "You have " + (p.getAllowFlight() ? "§aenabled " : "§cdisabled ")
						+ "§3player §b§lFlight§3.");
				return true;
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as Console.");
		return true;
	}
}