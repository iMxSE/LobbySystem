package us.insanity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupItem implements Listener {

	@EventHandler
	public void pickupItem(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
}
