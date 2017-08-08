package us.insanity.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

	@EventHandler
	public void playerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			p.spigot().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 1, 1, 1, 1, 1, 1, 1, 1);
		}
		if (p.getLocation().getY() <= 90) {
			p.teleport(new Location(Bukkit.getWorld("Lobby"), 0.5, 100, 0.5, 0, 0));
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		}
	}
}