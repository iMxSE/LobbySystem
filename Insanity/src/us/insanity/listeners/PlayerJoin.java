package us.insanity.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerJoin implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		
		
		p.sendMessage("§8§m--------------------------------------------------");
	    p.sendMessage("        §3§lWelcome to Insanity       ");
	    p.sendMessage("§b» §3§lStore§7: §bstoreinsanity.buycraft.net");
	    p.sendMessage("§b» §3§lWebsite§7: §binsanitynetwork.hol.es");
	    p.sendMessage("§b» §3§lForums§7: §binsanitynetwork.hol.es/forums");
	    p.sendMessage("§b» §3§lRules§7: §binsanitynetwork.hol.es/rules");
	    p.sendMessage("§8§m--------------------------------------------------");


		ItemStack Selector = new ItemStack(Material.COMPASS, 1);
		ItemMeta Selector_Meta = Selector.getItemMeta();
		Selector_Meta.setDisplayName(ChatColor.GRAY.toString() + ChatColor.BOLD + "» " + ChatColor.DARK_AQUA.toString()
				+ "Server Selector" + ChatColor.GRAY.toString() + ChatColor.BOLD + " «");
		Selector.setItemMeta(Selector_Meta);
		p.getInventory().setItem(4, Selector);
		p.setGameMode(GameMode.ADVENTURE);
		e.setJoinMessage(null);
		
		}
}
