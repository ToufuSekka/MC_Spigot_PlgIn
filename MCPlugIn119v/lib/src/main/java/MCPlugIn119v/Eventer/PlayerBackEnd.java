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

import MCPlugIn119v.Supporter.*;

/**
 * 
 * @author ToufuSekka
 */
public class PlayerBackEnd implements Listener {
	private Player P;

	private LocalDateTime LDT;
	private Date D;

	private SQLMain sqlSetter;
	private CustDataConfig CustConfig;

	@EventHandler
	public void ServerJoin(PlayerJoinEvent PJe) {
		P = PJe.getPlayer();
		String str = P.getUniqueId().toString();

		CustConfig = new CustDataConfig(null);
		
		sqlSetter = new SQLMain(CustConfig.getSQLAdre(),
				CustConfig.getUserName(), CustConfig.getSQLPW());

		sqlSetter.SetUUID(str);

		if (sqlSetter.UserCheck()) {
			if (sqlSetter.GetLeftTime() > 0) {
				sqlSetter.Sign();
				P.setStatistic(Statistic.PLAY_ONE_MINUTE, 0);
			} else {
				P.kickPlayer("Nothing Playing Time. You should ask to ADMIN");
				sqlSetter = null;
				return;
			}
		} else {
			sqlSetter.Rigist();
		}
		
		CustConfig = null;
		sqlSetter = null;
	}

	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		String str = P.getUniqueId().toString();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;

		
		CustConfig = new CustDataConfig(null);
		
		sqlSetter = new SQLMain(CustConfig.getSQLAdre(),
				CustConfig.getUserName(), CustConfig.getSQLPW());

		sqlSetter.SetUUID(str);
		sqlSetter.SetPlayTime(Time);
		sqlSetter.GameLeave();
		sqlSetter = null;
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

		String BanText = "You're dead.\nYou are unable to join our Server for "
				+ RevelveTime + " Miniutes.";
		Bukkit.getBanList(Type.NAME).addBan(P.getName(), BanText, D,
				PDe.getDeathMessage());
		P.kickPlayer(BanText);
		D = null;
	}
}
