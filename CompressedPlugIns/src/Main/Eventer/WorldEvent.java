package Main.Eventer;

import org.bukkit.*;
import org.bukkit.World.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.util.*;
import org.bukkit.event.*;

import Main.Store.*;
import Main.SysSPT.SysDice;

public class WorldEvent extends Items implements Listener {

	Location loc;
	Environment worldtype;
	BoundingBox WorldArea1 = new BoundingBox(-388, 0, 16, 512, 512, -640);
	LivingEntity Le;

	SysDice DD = null;

	ItemStack IS;

	@EventHandler
	public void AncientEvent(EntityDeathEvent EDE) {
		this.Le = (LivingEntity) EDE.getEntity();
		this.worldtype = this.Le.getWorld().getEnvironment();
		this.loc = this.Le.getLocation();

		String Lore[] = { "멸망했던 제국의 건물 잔해이다.", "쓸모 없어 보이는 이것을", "부덴아우스 유적제단에서", "모조리 회수 한다고 한다.",
				"명령어의 [/store evt]로 그 목록을 확인해 보자." };

		IS = LoredItem(Material.COBBLESTONE_WALL, 1, "고대 시대의 잔해", Lore);

		// zombies and Skels
		if (WorldArea1.contains((Vector) loc.toVector()) && worldtype.equals(World.Environment.NORMAL)) {
			if (Le instanceof Zombie || Le instanceof Skeleton) {
				DD = new SysDice(9, new int[] { 1 });
				if (DD.GetWin()) {
					loc.getWorld().dropItemNaturally(loc, this.IS);
				}
				DD = null;
			}

			// Phantom
			if (Le instanceof Phantom) {
				DD = new SysDice(27, new int[] { 4, 16 });
				if (DD.GetWin()) {
					loc.getWorld().dropItemNaturally(loc, this.IS);
				}
				DD = null;
			}

			// ZombieVill
			if (Le instanceof ZombieVillager) {
				loc.getWorld().dropItemNaturally(loc, this.IS);
			}
		}
	}
}