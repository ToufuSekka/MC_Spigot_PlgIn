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
		new TwitMain().ServerMSGTwit("Our Minecraft Server open." + "\nIf you wonder a thing, Please DM"
				+ "\nServerType : JE 1.18.1" + "\nCommunity : https://cafe.naver.com/mcneptune"
				+ "\nConnection ServerIP : wint0719.codns.com" + "\n#MinecraftServer #Minecraft");
	}

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerBackEnd(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(), this);
	}

	@Override
	public void onDisable() {
		new TwitMain().ServerMSGTwit("Server is Closed. See you Next Time."
				+ "\nCommunity : https://cafe.naver.com/mcneptune" + "\n#MinecraftServer #Minecraft");
	}
}
