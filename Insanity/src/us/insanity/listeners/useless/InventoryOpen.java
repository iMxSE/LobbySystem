package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpen implements Listener {

	@EventHandler
	public void inventoryOpen(InventoryOpenEvent e) {
		if (e.getInventory().getType() == InventoryType.ANVIL) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.BEACON) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.BREWING) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.CRAFTING) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.DROPPER) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.ENCHANTING) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.FURNACE) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.HOPPER) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.MERCHANT) {
			e.setCancelled(true);
		}
		if (e.getInventory().getType() == InventoryType.WORKBENCH) {
			e.setCancelled(true);
		}
	}
}