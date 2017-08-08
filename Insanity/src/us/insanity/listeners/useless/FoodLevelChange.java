package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

	@EventHandler
	public void foodLevelChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
}