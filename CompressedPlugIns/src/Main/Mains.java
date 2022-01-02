package Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

import Main.Eventer.*;
import Main.Store.CMDs.StoreCom;

public class Mains extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new WeaponsEV(), this);
		this.getCommand("store").setExecutor(new StoreCom());
		this.getCommand("evt").setExecutor(new StoreCom());
	}
}