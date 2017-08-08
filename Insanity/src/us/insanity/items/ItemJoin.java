package us.insanity.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemJoin implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		/* One Heart on join */
		p.setMaxHealth(20);
		p.setHealth(20);
		
		/* Making ItemStacks for the forced items */
		
		
		// Teleport Bow ItemStack
		ItemStack bow;
		ItemMeta bowMeta;
		bow = new ItemStack(Material.BOW);
		bowMeta = bow.getItemMeta();
		bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lTeleport Bow"));
		bowMeta.addEnchant(Enchantment.DURABILITY, 30, true);
		bow.setItemMeta(bowMeta);
		
		// Player Visibility ItemStack
		ItemStack visibility;
		ItemMeta visibilityMeta;
		visibility = new ItemStack(Material.SLIME_BALL);
		visibilityMeta = visibility.getItemMeta();
		visibilityMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Player Visibility &8» &aOn"));
		visibility.setItemMeta(visibilityMeta);
		
		// Arrow ItemStack
		ItemStack ammo;
		ItemMeta ammoMeta;
		ammo = new ItemStack(Material.ARROW, 64);
		ammoMeta = ammo.getItemMeta();
		ammoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9Insanity"));
		ammoMeta.addEnchant(Enchantment.DURABILITY, 30, true);
		ammo.setItemMeta(ammoMeta);
		
		// Skull ItemStack
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
			skullMeta.setOwner(p.getName());
			skull.setItemMeta(skullMeta);
		
		/* Forcing the items in their inventory */
		p.getInventory().setItem(3, skull);
		p.getInventory().setItem(0, bow);
		p.getInventory().setItem(8, visibility);
		p.getInventory().setItem(9, ammo);
		p.updateInventory();
		
	}
}