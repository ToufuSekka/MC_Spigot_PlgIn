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
 * @since 2022-12-28
 * @author ToufuSekka
 */
public class PlayerBackEnd implements Listener {
	private Player P;

	private LocalDateTime LDT;
	private Date D;

	private SQLMain sqlSetter;
	private CustDataConfig CustConfig;

	@EventHandler
	public void ServerJoin2(PlayerJoinEvent PJe) {
		P = PJe.getPlayer();
		String str = P.getUniqueId().toString();

		SQLPre(str);

		switch (sqlSetter.UserCheck2()) {
		case UnRigisted:
			P.kickPlayer("You must rigist your information before");
			break;
		case Blocked:
			P.setWhitelisted(false);
			P.kickPlayer("You're Banned by Outter System");
			break;
		case UnListed:
			P.setWhitelisted(true);
			sqlSetter.Sign(false);
			PJe.setJoinMessage("");
			break;
		case Rigisted:
			if (sqlSetter.GetLeftTime() < 0) {
				P.kickPlayer("Nothing Playing Time. You should ask to ADMIN");
			}
			sqlSetter.Sign(true);
			PJe.setJoinMessage("");
			break;
		}
		sqlSetter = null;
		CustConfig = null;
	}

	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		String str = P.getUniqueId().toString();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;

		SQLPre(str);

		sqlSetter.SetPlayTime(Time);
		sqlSetter.GameLeave();
		PQe.setQuitMessage("");
		sqlSetter = null;
		CustConfig = null;
	}

	public void PlayerPingkick() {

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

	private void SQLPre(String UUID) {
		CustConfig = new CustDataConfig("MC_Config.txt");
		sqlSetter = new SQLMain(CustConfig.getSQLAdre(), CustConfig.getUserName(), CustConfig.getSQLPW());
		sqlSetter.SetUUID(UUID);
	}
}
