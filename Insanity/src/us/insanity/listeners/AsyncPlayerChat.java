package us.insanity.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {

	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String m = e.getMessage();

		if (p.hasPermission("hub.chat") && !p.isOp()) {
			p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "ERROR " + ChatColor.RED
					+ "Chat is currently restricted to your rank. Purchase a rank at " + ChatColor.GOLD.toString()
					+ ChatColor.UNDERLINE + "store.insanity.net" + ChatColor.RED + " to bypass this Restriction.");
			e.setCancelled(true);
		}

		/*
		 * Other Ranks
		 */

		if (p.hasPermission("hub.lord")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GOLD + "Lord" + ChatColor.GRAY + "] " + ChatColor.GOLD
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.hero")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.BLUE + "Hero" + ChatColor.GRAY + "] " + ChatColor.BLUE
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.supreme")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.YELLOW + "Supreme" + ChatColor.GRAY + "] " + ChatColor.YELLOW
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.eternal")) {
			e.setFormat(
					ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "Eternal" + ChatColor.GRAY + "] " + ChatColor.DARK_GREEN
							+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.Titan")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Titan" + ChatColor.GRAY + "] "
					+ ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE
					+ m.toString());
		}

		if (p.hasPermission("hub.famous")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "Famous" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_PURPLE + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE
					+ m.toString());
		}
		
		if (p.hasPermission("hub.legend")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Legend" + ChatColor.GRAY + "] " 
					+ ChatColor.RED + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE
					+ m.toString());
		}
		
		if (p.hasPermission("hub.ultra")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Ultra" + ChatColor.GRAY + "] " 
					+ ChatColor.BLACK + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE
					+ m.toString());
		}

		/*
		 * Staff Ranks
		 */

		if (p.hasPermission("hub.mod")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Moderator" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}
		
		if (p.hasPermission("hub.builder")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Builder" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.mod+")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Senior Moderator" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}
		
		if (p.hasPermission("hub.hmod")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Head Moderator" + ChatColor.GRAY + "] "
					+ ChatColor.DARK_AQUA + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.admin")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Administrator" + ChatColor.GRAY + "] " + ChatColor.RED
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.admin+")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Senior Administrator" + ChatColor.GRAY + "] "
					+ ChatColor.RED + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}
		
		if (p.hasPermission("hub.manager")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.RED + "Manager" + ChatColor.GRAY + "] "
					+ ChatColor.RED + p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.dev")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN + "Developer" + ChatColor.GRAY + "] " + ChatColor.GREEN
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}

		if (p.hasPermission("hub.owner")) {
			e.setFormat(ChatColor.GRAY + "[" + ChatColor.AQUA + "Owner" + ChatColor.GRAY + "] " + ChatColor.AQUA
					+ p.getName() + ChatColor.GRAY + " : " + ChatColor.WHITE + m.toString());
		}		
	}
}