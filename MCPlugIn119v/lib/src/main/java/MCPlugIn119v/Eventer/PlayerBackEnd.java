package MCPlugIn119v.Eventer;

import java.util.*;
import java.time.*;

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

	private String PlayerUUID;

	@EventHandler
	public void ServerJoin2(PlayerJoinEvent PJe) {
		Bukkit.reloadWhitelist();
		P = PJe.getPlayer();
		PlayerUUID = P.getUniqueId().toString();

		SQLPre(PlayerUUID);

		if (sqlSetter.UserCheck())
			PJe.setJoinMessage("");
		else
			P.kickPlayer("You must rigist your information before");

		sqlSetter = null;
		CustConfig = null;
	}

	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		PlayerUUID = P.getUniqueId().toString();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
		
		SQLPre(PlayerUUID);

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
