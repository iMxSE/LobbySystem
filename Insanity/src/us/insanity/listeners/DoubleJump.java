package us.insanity.listeners;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {

	@EventHandler
	public void onPlayerFly(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
			Location loc = p.getLocation();
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(2.5D).setY(1.0D));
			p.spigot().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1, 1, 1, 1, 1, 1, 1, 1);
			p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if ((e.getPlayer().getGameMode() != GameMode.CREATIVE)
				&& (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
			p.setAllowFlight(true);
		}
	}

}