package org.spigotmc.spigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;

import org.spigotmc.spigot.Command.*;
import org.spigotmc.spigot.EventSys.*;

public class Main extends JavaPlugin{
	
	@Override
	public void onLoad() {
		//
	}
	
	@Override
	public void onEnable() {
		EventAdder();
		CommamdAdder();
	}
	
	@Override
	public void onDisable() {
		//
	}
	
	//privators
	private void EventAdder() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEndSys(),this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(),this);
	}
	
	private void CommamdAdder() {
		this.getCommand("store").setExecutor(new StoreSet());
	}
}