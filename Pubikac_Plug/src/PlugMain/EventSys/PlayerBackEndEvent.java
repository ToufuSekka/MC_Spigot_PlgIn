package PlugMain.EventSys;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import PlugMain.SysSPT.*;

public class PlayerBackEndEvent implements Listener {
	private ArrayList<Object[]>Data = new ArrayList<Object[]>();
	private Player P;
	
	private SQLSystem SQLSys = new SQLSystem();
	
	@EventHandler
	public void ServerJoin(PlayerLoginEvent PLe) {
		
		P = PLe.getPlayer();
		String str =P.getUniqueId().toString();
		P.setStatistic(Statistic.PLAY_ONE_MINUTE, 0);
		System.out.println(str+"가 올");
		
		Data = SQLSys.Searcher("MCUser",new String[] {"UUID"}, new String[] {"UUID"}, new Object[] {str});
		if(Data.isEmpty()) {
			SQLSys.Rigister(str);
		}
		
	}
	
	@EventHandler
	public void ServerQuit(PlayerQuitEvent PQe) {
		P = PQe.getPlayer();
		int Time = P.getStatistic(Statistic.PLAY_ONE_MINUTE)/20;
		System.out.println(Time+"초 동안 함.");
	}
}
