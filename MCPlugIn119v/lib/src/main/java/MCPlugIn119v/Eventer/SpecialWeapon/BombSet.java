package MCPlugIn119v.Eventer.SpecialWeapon;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class BombSet implements Listener {

	private Location Loc;
	private ThrownPotion ThrPos;

	@EventHandler
	public void ImadiBomb(ProjectileHitEvent Phe) {
		if (Phe.getEntity() instanceof ThrownPotion) {

			//
			ThrPos = (ThrownPotion) Phe.getEntity();
			Loc = ThrPos.getLocation();

			//
			if (ThrPos.getItem().getItemMeta().hasLore()) {
				List<String> Lores = ThrPos.getItem().getItemMeta().getLore();
				switch (Lores.get(0)) {
				case "Bomb":
					float Power = Float.parseFloat(Lores.get(1));
					Loc.getWorld().createExplosion(Loc, Power, true);
					break;
				default:
					break;
				}
			}
		}
	}
	
	@EventHandler
	public void Cannon(FireworkExplodeEvent FEe) {
		
	}
}