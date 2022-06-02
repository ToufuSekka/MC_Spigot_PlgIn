package MCPlugIn119v.Eventer;

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

import MCPlugIn119v.Supporter.SQL.*;


/**
 * 플레이어에 관한 특수 서버사이드, 이벤트
 * @author ToufuSekka
 */
public class PlayerBackEnd extends SQLMain implements Listener {
	private Player P;

	private LocalDateTime LDT;
	private Date D;

	@EventHandler
	public void ServerJoin(PlayerJoinEvent PJe) {
		P = PJe.getPlayer();
		String str = P.getUniqueId().toString();

		P.setStatistic(Statistic.PLAY_ONE_MINUTE,0);
		
		if (!ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { str })) {
			ReservedSQL(SQLCMD_Reserved.Rigist, new String[] { str });
		}

		ReservedSQL(SQLCMD_Reserved.Login, new String[] { str });
	}

	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
		
		String str = P.getUniqueId().toString();
		ReservedSQL(SQLCMD_Reserved.GameLeft, new String[] { str });
	}

	@EventHandler
	public void PlayerDeath(PlayerDeathEvent PDe) {
		P = PDe.getEntity().getPlayer();
		ItemStack Head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta MetaHead = (SkullMeta) Head.getItemMeta();

		MetaHead.setOwningPlayer(P);
		Head.setItemMeta(MetaHead);
		P.getWorld().dropItemNaturally(P.getLocation(), Head);
	}
	
	@Deprecated
	public void PlayerDeathKick(PlayerDeathEvent PDe) {
		P = PDe.getEntity().getPlayer();

		int RevelveTime = 0;

		ItemStack Head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta MetaHead = (SkullMeta) Head.getItemMeta();

		MetaHead.setOwningPlayer(P);
		Head.setItemMeta(MetaHead);
		P.getWorld().dropItemNaturally(P.getLocation(), Head);

		if (P.getBedSpawnLocation() == null) {
			RevelveTime = 0;
			LDT = LocalDateTime.now().plusMinutes(RevelveTime);
			D = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());
		} else {
			RevelveTime = 0;
			LDT = LocalDateTime.now().plusMinutes(RevelveTime);
			D = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());
		}

		String BanText = "You're dead.\nYou are unable to join our Server for " + RevelveTime + " Miniutes.";
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), BanText, D, PDe.getDeathMessage());
		P.kickPlayer(BanText);
		D = null;
	}
}
