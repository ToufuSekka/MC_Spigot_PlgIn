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

	@EventHandler
	public void Orb_Event01(EntityDeathEvent EDE) {
		this.Le = (LivingEntity) EDE.getEntity();
		this.worldtype = this.Le.getWorld().getEnvironment();
		this.loc = this.Le.getLocation();

		String Lore[] = { "지옥의 아귀에서 태어난 더러운 정수이다.", "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };

		IS = LoredItem(Material.MAGMA_CREAM, 1, "선혈의 정수", Lore);

		if (worldtype.equals(World.Environment.NETHER)) {
			DD = new SysDice(18, new int[] { 3 });
			if (DD.GetWin()) {
				loc.getWorld().dropItemNaturally(loc, this.IS);
			}
			DD = null;
		}
	}

	@EventHandler
	public void Orb_Event02(EntityDeathEvent EDE) {
		this.Le = (LivingEntity) EDE.getEntity();
		this.worldtype = this.Le.getWorld().getEnvironment();
		this.loc = this.Le.getLocation();
		
		String Lore[] = { "이 세계에 흝뿌려진 순수한 영혼이 담긴 정수이다.", "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };
		IS = LoredItem(Material.SLIME_BALL, 1, "자연의 정수", Lore);
		
		if (worldtype.equals(World.Environment.NORMAL)) {
			DD = new SysDice(45, new int[] { 6 });
			if (DD.GetWin()) {
				loc.getWorld().dropItemNaturally(loc, this.IS);
			}
			DD = null;
		}
	}

	public void Orb_Event03(EntityDeathEvent EDE) {
		this.Le = (LivingEntity) EDE.getEntity();
		this.loc = this.Le.getLocation();
		String Lore[] = { "이 세계에서 절대 존재 해선 안되는 정수이다.",  "이것을 가져가 정수 연금수사에게 보여주면", "쓸만한 것으로 바꿔준다 한다.",
				"명령어[/evt orb]로 확인해 보자." };
		IS = LoredItem(Material.ENDER_PEARL, 1, "공허의 정수", Lore);

		if (worldtype.equals(World.Environment.THE_END)) {
			DD = new SysDice(18, new int[] { 6 });
			if (DD.GetWin()) {
				loc.getWorld().dropItemNaturally(loc, this.IS);
			}
			DD = null;
		}
	}
}