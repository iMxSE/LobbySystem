package us.insanity.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PopPlayer implements Listener {
	
	@EventHandler
	public void onPlayerDmagge(EntityDamageByEntityEvent e) {
		Player damager = (Player) e.getDamager();
		Player hurt = (Player) e.getEntity();
		if (hurt instanceof Player) {
			e.setCancelled(true);
			damager.hidePlayer(hurt);
			damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1, 1);
			damager.playEffect(damager.getLocation(), Effect.STEP_SOUND, Material.ANVIL);
			damager.sendMessage(ChatColor.AQUA + "Pop! " + hurt.getName());
		}
		
	}

}

