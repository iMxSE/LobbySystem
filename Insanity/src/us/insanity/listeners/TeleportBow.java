package us.insanity.listeners;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportBow implements Listener {
	
	private static HashMap<UUID, UUID> map = new HashMap<UUID, UUID>();
	
	@EventHandler
	public void onHit(ProjectileHitEvent e) {
		
		Entity entity = e.getEntity();
		
		if (map.containsKey(entity.getUniqueId())) {
			Player p = Bukkit.getPlayer(map.get(entity.getUniqueId()));
			
			Location loc = entity.getLocation().add(0,1,0);
			p.teleport(loc);
			map.remove(entity.getUniqueId());
			
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	@EventHandler
	public void onLaunch(EntityShootBowEvent e) {
		
		Player p = (Player) e.getEntity();
		
		if (e.getEntity() instanceof Player) {
				try {
					Iterator iterator = map.entrySet().iterator();
					if (!map.isEmpty()) {
						while (iterator.hasNext()) {
							if (map.get(iterator.next()).equals(p.getUniqueId())) {
								return;
							}
						}
					}
					map.put(e.getProjectile().getUniqueId(), p.getUniqueId());
				}catch(NullPointerException exception) {
					
			}
		}
		
	}
	
}
