package us.insanity.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VisibilityToggleListener implements Listener {
	
	ArrayList<Player> enabled = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		// They can see players
		ItemStack visibility;
		ItemMeta visibilityMeta;
		visibility = new ItemStack(Material.SLIME_BALL);
		visibilityMeta = visibility.getItemMeta();
		visibilityMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Player Visibility &8» &aOn"));
		visibility.setItemMeta(visibilityMeta);
		
		// They can't see players
		ItemStack visibilityOff;
		ItemMeta visibilityOffMeta;
		visibilityOff = new ItemStack(Material.FIREWORK_CHARGE);
		visibilityOffMeta = visibilityOff.getItemMeta();
		visibilityOffMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Player Visibility &8» &cOff"));
		visibilityOff.setItemMeta(visibilityOffMeta);
		
		
		// Checking if they click the slim
		if (p.getItemInHand().getType().equals(Material.SLIME_BALL) || p.getItemInHand().getType().equals(Material.FIREWORK_CHARGE)) {
			if (enabled.contains(p)) { // Can see players
				for (Player player : Bukkit.getOnlinePlayers()) {
					p.hidePlayer(player);
				}
				enabled.remove(p);
				
				p.getInventory().setItem(8, visibilityOff);
				
			} else { // Can not see players
				for (Player player : Bukkit.getOnlinePlayers()) {
					p.showPlayer(player);
				}
				enabled.add(p);
				
				p.getInventory().setItem(8, visibility);
				
			}
		}
	}
}