package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionPrime implements Listener {

	@EventHandler
	public void explosionPrime(ExplosionPrimeEvent e) {
		e.setCancelled(true);
	}
}