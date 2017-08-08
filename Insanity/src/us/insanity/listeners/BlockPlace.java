package us.insanity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

	@EventHandler
	public void blockPlace(BlockPlaceEvent e) {
		if (!e.getPlayer().hasPermission("hub.build")) {
			e.setCancelled(true);
		}
	}
}