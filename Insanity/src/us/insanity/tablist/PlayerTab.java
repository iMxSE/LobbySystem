package us.insanity.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerTab implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			p.setPlayerListName(ChatColor.DARK_RED + p.getName());
		}

		if (p.hasPermission("hub.lord")) {
			p.setPlayerListName(ChatColor.GOLD + p.getName());
		}

		if (p.hasPermission("hub.hero")) {
			p.setPlayerListName(ChatColor.BLUE + p.getName());
		}

		if (p.hasPermission("hub.supreme")) {
			p.setPlayerListName(ChatColor.YELLOW + p.getName());
		}

		if (p.hasPermission("hub.eternal")) {
			p.setPlayerListName(ChatColor.GREEN + p.getName());
		}

		if (p.hasPermission("hub.titan")) {
			p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName());
		}

		if (p.hasPermission("hub.famous")) {
			p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
		}
		
		if (p.hasPermission("hub.legend")) {
			p.setPlayerListName(ChatColor.RED + p.getName());
		}
		
		if (p.hasPermission("hub.ultra")) {
			p.setPlayerListName(ChatColor.BLACK + p.getName());
		}

		if (p.hasPermission("hub.mod")) {
			p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
		}

		if (p.hasPermission("hub.mod+")) {
			p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
		}

		if (p.hasPermission("hub.admin")) {
			p.setPlayerListName(ChatColor.RED + p.getName());
		}

		if (p.hasPermission("hub.admin+")) {
			p.setPlayerListName(ChatColor.RED + p.getName());
		}

		if (p.hasPermission("hub.dev")) {
			p.setPlayerListName(ChatColor.GREEN + p.getName());
		}
		
		if (p.hasPermission("hub.owner")) {
			p.setPlayerListName(ChatColor.AQUA + p.getName());
		}
	}
}