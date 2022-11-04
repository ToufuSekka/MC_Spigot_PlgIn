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
 * @author ToufuSekka.
 */
public class Main extends JavaPlugin {

	@Override
	public void onLoad() {

		new PlayerDataSorter().Sorting();

		new TwitMain("Minecraft Server opened.\n" + "If you have opinions, Please send DM.\n"
				+ "Information Web : http://mcneptune.net\n" + "#SpigotServer #Minecraft");

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

		new TwitMain("Server is Closed." + "\nIf you have opinions, Please DM." + "\nSee you next time."
				+ "\n#MinecraftServer #Minecraft");

	}
}
