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

public class PlayerBackEndEvent implements Listener {
	private LocalDateTime LDT;
	private Player P;
	private ItemStack Head;
	private SkullMeta MetaHead;
	
	private SQLSystem SQLSys = new SQLSystem();
	
	@EventHandler
	public void ServerJoin(PlayerLoginEvent PLe) {
		LDT =LocalDateTime.now(); 
		P = PLe.getPlayer();
		String str =P.getUniqueId().toString();
		P.setStatistic(Statistic.PLAY_ONE_MINUTE, 0);
		
		if(!SQLSys.Reserv_(SQLCMD_Reserved.SearchUser, new String[] {str})) {
			SQLSys.Reserv_(SQLCMD_Reserved.Rigist,new String[] {str});
		}
		SQLSys.Reserv_(SQLCMD_Reserved.LoginDate, new String[] {str});
	}
	
	@EventHandler
	public void ServerKicking(PlayerJoinEvent PJe) {
		
		P = PJe.getPlayer();
		String str =P.getUniqueId().toString();

		if(!SQLSys.Reserv_(SQLCMD_Reserved.TimeLimiter, new String[] {str})) {
			this.P.kickPlayer("가용 시간이 없습니다. 충전하십시오.");
		}
	}
	
	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		String str =P.getUniqueId().toString();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
		System.out.println("나감->"+str +"'Player : "+ Time);
		SQLSys.Reserv_(SQLCMD_Reserved.TimeCulcurater,new String[] {String.valueOf(Time), str});
	}
	
	@EventHandler
	public void Death(PlayerDeathEvent PDe) {
		this.P =(Player) PDe.getEntity().getPlayer();
		
		this.Head = new ItemStack(Material.PLAYER_HEAD);
		this.MetaHead = (SkullMeta) this.Head.getItemMeta();
		this.MetaHead.setOwningPlayer(this.P);
		this.Head.setItemMeta(this.MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), this.Head);
		
		LDT = LocalDateTime.now().plusMinutes(40);
		Date D = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());
		
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), "사망하였습니다. 40분동안 접속이 불가능합니다.", D, "");
		this.P.kickPlayer("사망하였습니다. 일정시간동안 접속이 불가능합니다.");
	}
}
