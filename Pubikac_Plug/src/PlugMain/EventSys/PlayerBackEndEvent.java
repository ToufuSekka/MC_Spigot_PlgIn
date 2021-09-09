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

public class PlayerBackEndEvent implements Listener {
	private Player P;
	private SimpleDateFormat SimDatFmt= new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss");
	private Date[] date;
	@EventHandler
	public void ServerJoin(PlayerLoginEvent PLE) {
		date = new Date[1];
		
		P = PLE.getPlayer();
		String str =P.getUniqueId().toString();		
	}
	
	@EventHandler
	public void ServerQuit() {}
}
