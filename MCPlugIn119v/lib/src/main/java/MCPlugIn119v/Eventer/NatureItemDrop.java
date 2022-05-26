package MCPlugIn119v.Eventer;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;

import MCPlugIn119v.Supporter.Utils.*;

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

	public void AllEntityDeath(EntityDeathEvent EDE) {
		Le = EDE.getEntity();
		Dc = null;
		RewardIS = new ItemStack(Material.NETHER_WART);
		Dc = new Dice(0.01f);// Percentage;

		if (Dc.GetWin())
			Le.getWorld().dropItemNaturally(Le.getLocation(), RewardIS);
	}

	// 약탈자 1/8 -> 2기
	// 변명자 1/12, 1/9 -> 2기
	// 파괴수 1/24, 1/18, 1/14 -> 1기
	// 소환사 1/36, 1/30, 1/24, 1/18 -> 1기
	// 환술사 1/72, 1/64, 1/56, 1/48, 1/40 -> 1기
	public void Illiger_Death(EntityDeathEvent EDE) {
		Le = EDE.getEntity();
		Dc = null;

		if (Le instanceof Illager) {
			Dc = new Dice(8, new int[] { 2 });

			RewardIS = new ItemStack(Material.CHORUS_FLOWER);
			if (Dc.GetWin()) {
				Le.getWorld().dropItemNaturally(Le.getLocation(), RewardIS);
			}
		}
	}
}
