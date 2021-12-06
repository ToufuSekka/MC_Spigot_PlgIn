package Main.Eventer;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;

import Main.SysSPT.*;

public class UnitHunterEV  implements Listener {
	Player P = null;
	LivingEntity Le = null;

	ItemStack IS = null;

	SysDice DD = null;

	public void EventType_Piglings(EntityDeathEvent Ede) {
		this.Le = Ede.getEntity();

		if (Le instanceof Piglin) {
			DD = new SysDice(200, new int[] { 1, 5, 20 });
			IS = new ItemStack(Material.ANCIENT_DEBRIS, 1);

			if (DD.GetWin())
				Le.getWorld().dropItemNaturally(Le.getLocation(), this.IS);
			DD = null;
		}

		if (Le instanceof PigZombie) {
			DD = new SysDice(2000, new int[] { 30, 200, 1000 });
			IS = new ItemStack(Material.ANCIENT_DEBRIS, 1);

			if (DD.GetWin())
				Le.getWorld().dropItemNaturally(Le.getLocation(), this.IS);
			DD = null;
		}
	}
}