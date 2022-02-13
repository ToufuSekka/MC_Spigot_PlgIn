package org.spigotmc.spigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;

import org.spigotmc.spigot.Command.*;
import org.spigotmc.spigot.EventSys.*;

import org.spigotmc.spigot.Outer.Twitter.*;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onLoad() {
		//new PlayerDataSorter().Sorting();
		new TwitterMain().OpenServerTwit("이게 지금 잘만 나온다면... 제발 ...\n-트위터 시험중-");
	}
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEndSys(),this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(),this);
		
		this.getCommand("store").setExecutor(new StoreSet());
	}
	
	@Override
	public void onDisable() {
		//
	}
}