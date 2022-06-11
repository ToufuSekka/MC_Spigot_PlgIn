package MCPlugIn119v.Eventer;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;

import MCPlugIn119v.Supporter.*;

public class NatureItemDrop implements Listener {
	private ItemStack RewardIS;
	private LivingEntity Le;

	private Dice Dc;

	public void Wither_Death(EntityDeathEvent EDE) {
		Le = EDE.getEntity();
		Dc = null;

		if (Le instanceof Wither) {
			Dc = new Dice(12.5f);// Percentage;
			RewardIS = new ItemStack(Material.CHORUS_FLOWER);
			if (Dc.GetWin()) {
				Le.getWorld().dropItemNaturally(Le.getLocation(), RewardIS);
			}
		}
	}

	@EventHandler
	public void AllEntityDeath(EntityDeathEvent EDE) {
		Le = EDE.getEntity();
		Dc = null;
		RewardIS = new ItemStack(Material.NETHER_WART);
		Dc = new Dice(1500, new int[] {15});// Percentage;

		if (Dc.GetWin())
			Le.getWorld().dropItemNaturally(Le.getLocation(), RewardIS);
	}
}
