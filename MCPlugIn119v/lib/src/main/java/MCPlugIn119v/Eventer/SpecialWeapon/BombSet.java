package MCPlugIn119v.Eventer.SpecialWeapon;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

import MCPlugIn119v.Items.*;

public class BombSet implements Listener {

	private Location Loc;
	private ThrownPotion ThrPos;
	private List<String> Lores;

	@EventHandler
	public void ImadiBomb(ProjectileHitEvent Phe) {
		if (Phe.getEntity() instanceof ThrownPotion) {

			//
			ThrPos = (ThrownPotion) Phe.getEntity();
			Loc = ThrPos.getLocation();

			//
			if (ThrPos.getItem().getItemMeta().hasLore()) {
				Lores = ThrPos.getItem().getItemMeta().getLore();
				switch (Lores.get(0)) {
				case "Bomb":
					float Power = Float.parseFloat(Lores.get(1));
					Loc.getWorld().createExplosion(Loc, Power, true);
					break;
				default:
					break;
				}
				Lores.clear();
			}
		}
	}

	@EventHandler
	public void Cannon(FireworkExplodeEvent FEe) {
		if (FEe.getEntity() instanceof Firework) {
			Firework Fw = (Firework) FEe.getEntity();
			if (Fw.getFireworkMeta().hasLore()) {
				Lores = Fw.getFireworkMeta().getLore();

				switch (Lores.get(0)) {
				case "Howitzer":
					ThrPos = (ThrownPotion) Fw.getWorld().spawnEntity(FEe.getEntity().getLocation(), EntityType.SPLASH_POTION);
					ThrPos.setItem(new SpecialItems().LoredItem(Material.SPLASH_POTION, 1, "Granade", new String[] { "Bomb",Lores.get(1) }));
					break;
				default:
					break;
				}
			}
		}
	}
}