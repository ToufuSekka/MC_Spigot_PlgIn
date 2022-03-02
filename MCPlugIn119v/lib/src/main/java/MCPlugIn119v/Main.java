package MCPlugIn119v;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;

import MCPlugIn119v.Supporter.Twitters.*;
import MCPlugIn119v.Eventer.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka 실 실행부문.
 */
public class Main extends JavaPlugin {

	@Override
	public void onLoad() {
		new PlayerDataSorter().Sorting();
		new TwitMain().ServerMSGTwit(
				"Our Minecraft Server open." + "\nServerType : JE 1.18.1" + "\nCommunity : cafe.naver.com/mcnaptune"
						+ "\nConnection Server : wint0719.codns.com" + "\n#MinecraftServer" + "\n#Minecraft");

	}

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEnd(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(), this);
	}

	@Override
	public void onDisable() {
		new TwitMain().ServerMSGTwit("Server is Closed. See you Next Time." + "\n#MinecraftServer" + "\n#Minecraft");
	}
}
