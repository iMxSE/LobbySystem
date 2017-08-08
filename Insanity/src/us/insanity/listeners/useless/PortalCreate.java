package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalCreate implements Listener {

	@EventHandler
	public void portalCreate(PlayerPortalEvent e) {
		e.setCancelled(true);
	}
}