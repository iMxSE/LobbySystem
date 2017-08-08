package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftItem implements Listener {

	@EventHandler
	public void craftItem(CraftItemEvent e) {
		e.setCancelled(true);
	}
}