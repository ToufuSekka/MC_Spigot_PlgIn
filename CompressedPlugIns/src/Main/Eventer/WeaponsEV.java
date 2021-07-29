package Main.Eventer;

import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;

import Main.Store.Items;

public class WeaponsEV implements Listener {

	Location loc;
	World world;
	ThrownPotion ThrP;
	Firework Fw;

	Items its;

	@EventHandler
	public void Bomb(ProjectileHitEvent Phe) {

		if (Phe.getEntity() instanceof ThrownPotion) {
			this.ThrP = (ThrownPotion) Phe.getEntity();
			this.loc = ThrP.getLocation();

			// Bomb
			if (this.ThrP.getItem().getItemMeta().hasLore()) {
				String str = this.ThrP.getItem().getItemMeta().getLore().toString();
				switch (str) {
				case "[멸망 1 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 4, true);
					break;
				case "[멸망 2 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 12, true);
					break;
				case "[멸망 3 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 36, true);
					break;
				case "[멸망 4 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 108, true);
					Bukkit.broadcastMessage("누군가 멸망시켰습니다.");
					break;
				default:
					break;
				}

				// Mortal
				switch (str) {
				case "[박격  1 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 2, true);
					break;
				case "[박격  2 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 4, true);
					break;
				case "[박격  3 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 6, true);
					break;
				case "[박격  4 단계]":
					this.loc.getWorld().createExplosion(ThrP.getLocation(), 8, true);
					break;
				default:
					break;
				}
			}
		}
	}

	@EventHandler
	public void MortalGun(FireworkExplodeEvent FwEE) {
		this.its = new Items();
		this.Fw = (Firework) FwEE.getEntity();

		if (this.Fw.getFireworkMeta().hasLore()) {
			String str = this.Fw.getFireworkMeta().getLore().toString();
			switch (str) {
			case "[박격 1 단계]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "수직탄", new String[] { "박격  1 단계" }));
				break;
			case "[박격 2 단계]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "수직탄", new String[] { "박격  2 단계" }));
				break;
			case "[박격 3 단계]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "수직탄", new String[] { "박격  3 단계" }));
				break;
			case "[박격 4 단계]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "수직탄", new String[] { "박격  4 단계" }));
				break;
			default:
				break;
			}
		}
	}
}