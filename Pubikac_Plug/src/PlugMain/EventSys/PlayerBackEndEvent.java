package PlugMain.EventSys;

import java.util.*;
import java.text.*;

import org.bukkit.*;
import org.bukkit.BanList.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import PlugMain.SysSPT.*;

public class PlayerBackEndEvent implements Listener {
	private Player P;
	private SimpleDateFormat SimDatFmt= new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss");
	private Date[] date;
	
	private SQLSystem SQLSys = new SQLSystem();
	
	@EventHandler
	public void ServerJoin(PlayerLoginEvent PLE) {
		date = new Date[1];
		
		P = PLE.getPlayer();
		String str =P.getUniqueId().toString();
		SQLSys.Rigister(str);
	}
	
	@EventHandler
	public void ServerQuit() {
		
	}
}
