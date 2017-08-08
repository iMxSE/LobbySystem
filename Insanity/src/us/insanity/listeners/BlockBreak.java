package us.insanity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		if (!e.getPlayer().hasPermission("hub.build")) {
			e.setCancelled(true);
		}
	}
}