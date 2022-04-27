package MCPlugIn119v;

import java.time.*;
import java.util.*;

import org.bukkit.*;
import org.bukkit.plugin.java.*;

import MCPlugIn119v.Supporter.Twitters.*;

import MCPlugIn119v.Eventer.*;
import MCPlugIn119v.Eventer.SpecialWeapon.*;

import MCPlugIn119v.Commander.*;

import MCPlugIn119v.Recipe.EnumSet.*;
import MCPlugIn119v.Recipe.ShapeLess.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka 실 실행부문.
 */
public class Main extends JavaPlugin {

	private LocalDateTime LDT;
	private Date D_Open;
	private Date D_Close;

	@Override
	public void onLoad() {
		LDT = LocalDateTime.now().plusHours(24);

		D_Open = new Date();
		D_Close = Date.from(LDT.atZone(ZoneId.systemDefault()).toInstant());

		new PlayerDataSorter().Sorting();

		new TwitMain("Minecraft Server open." + "\nIf you have opinions, Please send DM." + "\nServerType : JE 1.18.2"
				+ "\nCommunity : https://cafe.naver.com/mcneptune (Only Korean Support)" + "\nRunning Time : " + D_Open
				+ "~" + D_Close + "\nConnection ServerIP : wint0719.codns.com" + "\n#MinecraftServer #Minecraft");

	}

	@Override
	public void onEnable() {
		// Bukkit.getPluginManager().registerEvents(new PlayerBackEnd(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(), this);

		// BombSet
		Bukkit.getPluginManager().registerEvents(new BombSet(), this);

		// StoreSet
		this.getCommand("store").setExecutor(new CMDMain());

		// Specialrecipe
		new TNTBomb(BombType.TNTBomb, this);
		// new TNTBomb(BombType.Radioactive, this);
		// new TNTBomb(BombType.Nuclear, this);
	}

	@Override
	public void onDisable() {

		new TwitMain("Server is Closed. \nIf you have opinions, Please DM." + "\nSee you next time."
				+ "\nCommunity : https://cafe.naver.com/mcneptune" + "\n#MinecraftServer #Minecraft");

	}
}
