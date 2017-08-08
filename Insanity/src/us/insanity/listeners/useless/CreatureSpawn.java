package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawn implements Listener {

	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent e) {
		e.setCancelled(true);
	}
}
