package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class LightningStrike implements Listener {

	@EventHandler
	public void lightningStrike(LightningStrikeEvent e) {
		e.setCancelled(true);
	}
}