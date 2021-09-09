package PlugMain;

import org.bukkit.plugin.java.*;

import PlugMain.EventSys.*;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		EventAdder();
		StoreAdder();
	}
	
	@Override
	public void onDisable() {
		//
	}
	
	private void EventAdder() {}
	private void StoreAdder() {}
}
