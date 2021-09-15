package PlugMain;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;

import PlugMain.EventSys.*;

public class Main extends JavaPlugin {
	
	@Override
	public void onLoad() {
		
	}
	
	@Override
	public void onEnable() {
		EventAdder();
		StoreAdder();
	}
	
	@Override
	public void onDisable() {
		//
	}
	
	private void EventAdder() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEndEvent(), this);
	}
	private void StoreAdder() {}
}
