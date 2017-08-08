package us.insanity.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class PlayerExpChange implements Listener {

	@EventHandler
	public void playerExpChange(PlayerExpChangeEvent e) {
		e.setAmount(0);
	}
}