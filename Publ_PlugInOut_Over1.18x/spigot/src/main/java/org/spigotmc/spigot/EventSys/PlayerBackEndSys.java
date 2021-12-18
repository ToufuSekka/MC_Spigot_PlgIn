package org.spigotmc.spigot.EventSys;

import java.util.*;
import java.time.*;
import org.bukkit.*;
import org.bukkit.BanList.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import org.spigotmc.spigot.SysSpt.*;

public class PlayerBackEndSys extends SQLSystem implements Listener{
	private Player P;
	
	private LocalDateTime LDT;
	private Date D;
		
	@EventHandler
	public void ServerJoin(PlayerJoinEvent PJe) {
		this.P = PJe.getPlayer();
		String str = this.P.getUniqueId().toString();
		
		if(!ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] {str})) {
			ReservedSQL(SQLCMD_Reserved.Rigist, new String[] {str});
		}
		ReservedSQL(SQLCMD_Reserved.Login, new String[] {str});
	}
	
	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		this.P = PQe.getPlayer();
		String str =this.P.getUniqueId().toString();
		ReservedSQL(SQLCMD_Reserved.GameLeft, new String[] {str});
	}
	
	@EventHandler
	public void PlayerDeathKick(PlayerDeathEvent PDe) {
		this.P = PDe.getEntity().getPlayer();
		int RevelveTime = 0;
		
		ItemStack Head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta MetaHead = (SkullMeta) Head.getItemMeta();
		
		MetaHead.setOwningPlayer(this.P);
		Head.setItemMeta(MetaHead);
		this.P.getWorld().dropItemNaturally(this.P.getLocation(), Head);
		
		if(this.P.getBedSpawnLocation() == null) {
			RevelveTime = 52;
			this.LDT = LocalDateTime.now().plusMinutes(RevelveTime);
			this.D = Date.from(this.LDT.atZone(ZoneId.systemDefault()).toInstant());
		} else {
			RevelveTime = 32;
			this.LDT = LocalDateTime.now().plusMinutes(RevelveTime);
			this.D = Date.from(this.LDT.atZone(ZoneId.systemDefault()).toInstant());
		}
		
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), "사망하였습니다. "+RevelveTime+"분동안 접속이 불가능합니다.", D, "");
		this.P.kickPlayer("사망하였습니다. "+RevelveTime+"분듕안 접속이 불가능합니다.");
		this.D = null;
	}
}
