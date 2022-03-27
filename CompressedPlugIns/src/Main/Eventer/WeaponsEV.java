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
	public void MortalGun(FireworkExplodeEvent FwEE) {
		this.its = new Items();
		this.Fw = (Firework) FwEE.getEntity();

		if (this.Fw.getFireworkMeta().hasLore()) {
			String str = this.Fw.getFireworkMeta().getLore().toString();
			switch (str) {
			case "[諛뺢꺽 1 �떒怨�]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "�닔吏곹깂", new String[] { "諛뺢꺽  1 �떒怨�" }));
				break;
			case "[諛뺢꺽 2 �떒怨�]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "�닔吏곹깂", new String[] { "諛뺢꺽  2 �떒怨�" }));
				break;
			case "[諛뺢꺽 3 �떒怨�]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "�닔吏곹깂", new String[] { "諛뺢꺽  3 �떒怨�" }));
				break;
			case "[諛뺢꺽 4 �떒怨�]":
				this.ThrP = (ThrownPotion) this.Fw.getWorld().spawnEntity(Fw.getLocation(), EntityType.SPLASH_POTION);
				this.ThrP.setItem(its.LoredItem(Material.SPLASH_POTION, 1, "�닔吏곹깂", new String[] { "諛뺢꺽  4 �떒怨�" }));
				break;
			default:
				break;
			}
		}
	}
}