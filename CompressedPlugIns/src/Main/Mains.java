package Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

import Main.Eventer.*;
import Main.Store.CMDs.StoreCom;

public class Mains extends JavaPlugin {

	final PluginDescriptionFile pdf = this.getDescription();;
	
	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new PlayerEV(), this);
		Bukkit.getPluginManager().registerEvents(new UnitHunterEV(), this);
		Bukkit.getPluginManager().registerEvents(new WeaponsEV(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEvent(), this);
		Bukkit.getPluginManager().registerEvents(new UnitSpawnEv(), this);
		this.getCommand("store").setExecutor(new StoreCom());
		this.getCommand("evt").setExecutor(new StoreCom());
	}

	@Override
	public void onDisable() {
		int DateTime = (int) Bukkit.getWorld("world").getFullTime() / 24000;
		System.out.println("오늘의 종료 시각은 : " + DateTime + "일 입니다.");
	}
}