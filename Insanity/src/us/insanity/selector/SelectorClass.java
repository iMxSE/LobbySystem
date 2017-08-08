package us.insanity.selector;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelectorClass implements Listener {

	Inventory selector = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Select a server!");

	@EventHandler
	public void selectorOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getItem() == null || e.getItem().getType().equals(Material.AIR)) {
			return;
		}
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getItem().getType().equals(Material.COMPASS)) {
				ItemStack HCFactions = new ItemStack(Material.FISHING_ROD);
				ItemMeta HCFactions_Meta = HCFactions.getItemMeta();
				HCFactions_Meta.setDisplayName("§3§lHCF");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("§3§m-----------------------------");
				lore.add("§bMap Kit» §fProtection I, Sharpness I");
				lore.add("§bFactions» §f20 man, 1 ally");
				lore.add("§bStatus» §aOPEN");
				lore.add("         §binsanitynetwork.net    ");
				lore.add("§3§m-----------------------------");
				HCFactions_Meta.setLore(lore);
				HCFactions.setItemMeta(HCFactions_Meta);
				selector.setItem(10, HCFactions);

				ItemStack Kits = new ItemStack(Material.POTION, 1, (short) 16421);
				ItemMeta Kits_Meta = Kits.getItemMeta();
				Kits_Meta.setDisplayName("§3§lKitMap");
				ArrayList<String> lore2 = new ArrayList<String>();
				lore2.add("§3§m-----------------------------");
				lore2.add("§bMap Kit» §fProtection I, Sharpness I");
				lore2.add("§bFactions» §f5 man, 1 ally");
				lore2.add("§bStatus» §cIn-Dev");
				lore2.add("        §binsanitynetwork.net    ");
				lore2.add("§3§m-----------------------------");
				Kits_Meta.setLore(lore2);
				Kits.setItemMeta(Kits_Meta);
				selector.setItem(14, Kits);

				ItemStack Solos = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemMeta Solos_Meta = Solos.getItemMeta();
				Solos_Meta.setDisplayName("§3§lSquads");
				ArrayList<String> lore3 = new ArrayList<String>();
				lore3.add("§3§m-----------------------------");
				lore3.add("§bMap Kit» §fProtection I, Sharpness I");
				lore3.add("§bFactions» §f15 man, 1 ally");
				lore3.add("§bStatus» §cIn-Dev");
				lore3.add("        §binsanitynetwork.net    ");
				lore3.add("§3§m-----------------------------");
				Solos_Meta.setLore(lore3);
				Solos.setItemMeta(Solos_Meta);
				selector.setItem(12, Solos);

				ItemStack Practice = new ItemStack(Material.GOLD_HELMET, 1);
				ItemMeta Practice_Meta = Practice.getItemMeta();
				Practice_Meta.setDisplayName("§e§lPractice");
				Practice.setItemMeta(Practice_Meta);
				ArrayList<String> lore4 = new ArrayList<String>();
				lore4.add("§3§m-----------------------------");
				lore4.add("§bElo, Tops");
				lore4.add("§bParty mode");
				lore4.add("§bStatus» §cIn-Dev");
				lore4.add("           §binsanitynetwork.net   ");
				lore4.add("§3§m-----------------------------");
				Practice_Meta.setLore(lore4);
				Practice.setItemMeta(Practice_Meta);

				selector.setItem(16, Practice);
				p.updateInventory();
				p.openInventory(selector);
				return;
			}
		}
	}

	@EventHandler
	public void inventoryEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!p.hasPermission("hub.click")) {
			e.setCancelled(true);
		}
		if (e.getClickedInventory() == null || (e.getCurrentItem().getType() == Material.AIR)) {
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.FISHING_ROD) {
			p.chat("/play HCF");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.POTION) {
			p.chat("/play Kits");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
			p.chat("/play Squads");
			p.closeInventory();
			return;
		}
		if (e.getClickedInventory().equals(selector) && e.getCurrentItem().getType() == Material.GOLD_HELMET) {
			p.chat("/play Practice");
			p.closeInventory();
			return;
		}
	}
}