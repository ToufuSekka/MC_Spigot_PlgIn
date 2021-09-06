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
		Bukkit.getPluginManager().registerEvents(new WeaponsEV(), this);
		this.getCommand("store").setExecutor(new StoreCom());
		this.getCommand("evt").setExecutor(new StoreCom());
	}

	@Override
	public void onDisable() {
		int DateTime = (int) Bukkit.getWorld("world").getFullTime() / 24000;
		System.out.println("�삤�뒛�쓽 醫낅즺 �떆媛곸� : " + DateTime + "�씪 �엯�땲�떎.");
	}
}