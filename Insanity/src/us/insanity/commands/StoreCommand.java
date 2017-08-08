package us.insanity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (label.equalsIgnoreCase("store") || label.equalsIgnoreCase("buy")) {
				p.sendMessage("§3§lStore: §bstoreinsanity.buycraft.net");
			}
			return true;
		}
		sender.sendMessage(ChatColor.GOLD + "Please run commands as a player.");
		return true;
	}
}