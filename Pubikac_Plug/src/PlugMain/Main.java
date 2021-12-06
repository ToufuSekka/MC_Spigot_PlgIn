package PlugMain;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;

import PlugMain.EventSys.*;
import PlugMain.Recipe.*;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		EventAdder();
		StoreAdder();
		RecipeAdder();
	}
	
	@Override
	public void onDisable() {
		//
	}
	
	private void EventAdder() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEndEvent(), this);
	}
	private void StoreAdder() {
		//
	}
	
	private void RecipeAdder() {
		new CstUnshpRecp().Bomb_Level_1();
	};
}
