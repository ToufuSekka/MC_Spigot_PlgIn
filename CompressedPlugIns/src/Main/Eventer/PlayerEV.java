package Main.Eventer;

import org.bukkit.BanList.Type;

import java.util.Date;

import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class PlayerEV implements Listener {
	Date date;
	long Time;
	Player P;
	ItemStack Head;
	SkullMeta MetaHead;
	int DaysTime = 0;
	
	@EventHandler
	public void ServerJOIN(PlayerLoginEvent PLE) {
		P = PLE.getPlayer();
		date = new Date();
		Time = date.getTime();
	}
	
	@EventHandler
	public void ServerOut(PlayerQuitEvent PQE) {
		//
	}
	
	@EventHandler
	public void PlayerDead(PlayerDeathEvent PDE) {
		this.P = (Player) PDE.getEntity().getPlayer();
		this.Head = new ItemStack(Material.PLAYER_HEAD);

		this.MetaHead = (SkullMeta) this.Head.getItemMeta();
		this.MetaHead.setOwningPlayer(this.P.getPlayer());

		this.Head.setItemMeta(this.MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), this.Head);
		
		//creating
		date = new Date();
		
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), null,null, null);
	}

	@EventHandler
	public void StallEvent(PlayerMoveEvent PME) {
		this.P = PME.getPlayer();
		if (this.P.getLocation().getY() > 384f) {
			if (P.isGliding()) {
				P.setGliding(false);
			}
		}
	}
}