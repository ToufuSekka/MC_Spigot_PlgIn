package MCPlugIn119v;

import org.bukkit.plugin.java.JavaPlugin;

import MCPlugIn119v.Supporter.Twitters.*;
import MCPlugIn119v.Eventer.*;

public class Main extends JavaPlugin {

	@Override
	public void onLoad() {
		new PlayerDataSorter().Sorting();
		new TwitMain().ServerMSGTwit("");
	}

	@Override
	public void onEnable() {
		//
	}

	@Override
	public void onDisable() {
		new TwitMain().ServerMSGTwit("");
	}
}
