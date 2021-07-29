package Main.Eventer;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class PlayerEV implements Listener {
	Player P;
	ItemStack Head;
	SkullMeta MetaHead;
	int DaysTime = 0;

	@EventHandler
	public void BreakHead(PlayerDeathEvent PDE) {
		this.P = (Player) PDE.getEntity().getPlayer();
		this.Head = new ItemStack(Material.PLAYER_HEAD);

		this.MetaHead = (SkullMeta) this.Head.getItemMeta();
		this.MetaHead.setOwningPlayer(this.P.getPlayer());

		this.Head.setItemMeta(this.MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), this.Head);
	}

	@EventHandler
	public void StallEvent(PlayerMoveEvent PME) {
		this.P = PME.getPlayer();
		if (this.P.getLocation().getY() > 384f) {
			if (P.isGliding()) {
				P.sendMessage("활공 허용치를 초과했습니다. 얼어붙습니다.");
				P.setGliding(false);
			}
		}
	}
}
