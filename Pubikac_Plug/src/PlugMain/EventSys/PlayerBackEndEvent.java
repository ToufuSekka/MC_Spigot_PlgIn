package PlugMain.EventSys;

import java.util.*;
import java.time.*;
import org.bukkit.*;
import org.bukkit.BanList.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import PlugMain.SysSPT.*;

public class PlayerBackEndEvent extends SQLSystem implements Listener {
	private LocalDateTime LDT;
	private Player P;
	private ItemStack Head;
	private SkullMeta MetaHead;
		
	private Date D;
	private int MinTime;
	@EventHandler
	public void ServerJoin(PlayerLoginEvent PLe) {
		P = PLe.getPlayer();
		String str =P.getUniqueId().toString();

		if(!Reserv_(SQLCMD_Reserved.SearchUser, new String[] {str})) {
			Reserv_(SQLCMD_Reserved.Rigist,new String[] {str});
		}
		Reserv_(SQLCMD_Reserved.Login, new String[] {str});
	}

	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		String str =P.getUniqueId().toString();
		Reserv_(SQLCMD_Reserved.GameLeft,new String[] {str});
	}
	
	@EventHandler
	public void Death(PlayerDeathEvent PDe) {
		this.P =(Player) PDe.getEntity().getPlayer();
		
		this.Head = new ItemStack(Material.PLAYER_HEAD);
		this.MetaHead = (SkullMeta) this.Head.getItemMeta();
		this.MetaHead.setOwningPlayer(this.P);
		this.Head.setItemMeta(this.MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), this.Head);
		
		if(this.P.getBedSpawnLocation() == null) {
			MinTime = 48;
			LDT = LocalDateTime.now().plusMinutes(MinTime);
			this.D = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());
		} else {
			MinTime = 36;
			LDT = LocalDateTime.now().plusMinutes(MinTime);
			this.D = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());
		}
		
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), "사망하였습니다. "+MinTime+"분동안 접속이 불가능합니다.", D, "");
		this.P.kickPlayer("사망하였습니다. 일정시간동안 접속이 불가능합니다.");
		this.D = null;
	}
}
