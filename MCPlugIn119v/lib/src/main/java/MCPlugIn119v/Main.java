package MCPlugIn119v;

import org.bukkit.*;
import org.bukkit.plugin.java.*;

import MCPlugIn119v.Eventer.*;
import MCPlugIn119v.Eventer.SpecialWeapon.*;
import MCPlugIn119v.Commander.*;
import MCPlugIn119v.Recipe.EnumSet.*;
import MCPlugIn119v.Recipe.ShapeLess.*;
import MCPlugIn119v.Supporter.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka 실 실행부문.
 */
public class Main extends JavaPlugin {

	@Override
	public void onLoad() {

		new PlayerDataSorter().Sorting();

		new TwitMain("Minecraft Server opened.\n" + "If you have opinions, Please send DM.\n" + "Version : JE, 1.19.2\n"
				+ "Ganre : Servival, Spigot-Vanilla\n" + "Community(Korean Only) : https://cafe.naver.com/mcneptune\n"
				+ "Discord : https://discord.gg/vE7ETwXcG8 \n" + "This server is Genuine User Only!\n"
				+ "Server IP: mcneptune.net #Minecraft");

	}

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(new PlayerBackEnd(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(), this);
		Bukkit.getPluginManager().registerEvents(new NatureItemDrop(), this);
		Bukkit.getPluginManager().registerEvents(new BombSet(), this);

		// StoreSet
		this.getCommand("store").setExecutor(new CMDMain());

		// Specialrecipe
		new TNTBomb(BombType.Bomb, this);
		new TNTBomb(BombType.Nuclear, this);
		new TNTBomb(BombType.Howitzer, this);
	}

	@Override
	public void onDisable() {

		new TwitMain("Server is Closed. \nIf you have opinions, Please DM." + "\nSee you next time."
				+ "\nCommunity(Korean Only) : https://cafe.naver.com/mcneptune"
				+ "\nGlobal Discord : https://discord.gg/vE7ETwXcG8" + "\n#MinecraftServer #Minecraft");

	}
}
