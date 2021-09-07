package Main.Eventer;

import java.util.*;

import org.bukkit.*;
import org.bukkit.BanList.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class PlayerEV implements Listener {
	Date date;
	long Time;
	
	Random rmd;
	Player P;
	ItemStack Head;
	SkullMeta MetaHead;
	
	@EventHandler
	public void ServerJOIN(PlayerLoginEvent PLE) {
		P = PLE.getPlayer();
		date = new Date();
		Time = date.getTime();
		Bukkit.getLogger().info("테스터가 들어옴 : " + Time);
	}
	
	@EventHandler
	public void ServerOut(PlayerQuitEvent PQE) {
		P = PQE.getPlayer();
		date = new Date();
		Time = date.getTime();
		Bukkit.getLogger().info("테스터가 나감.");
	}
	
	@EventHandler
	public void PlayerDead(PlayerDeathEvent PDE) {
		this.P = (Player) PDE.getEntity().getPlayer();
		this.Head = new ItemStack(Material.PLAYER_HEAD);

		this.MetaHead = (SkullMeta) this.Head.getItemMeta();
		this.MetaHead.setOwningPlayer(this.P.getPlayer());

		this.Head.setItemMeta(this.MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), this.Head);
		
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), "", new Date (P.getPlayerTime() + 24000L), "");
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