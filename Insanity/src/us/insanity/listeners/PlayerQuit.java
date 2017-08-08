package us.insanity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
}