package MCPlugIn119v;
import MCPlugIn119v.Commander.*;
import MCPlugIn119v.Supporter.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka.
 */
public class Main extends JavaPlugin {

	private PlayerDataSorter Sorter;
	private CustDataConfig CustConfig;

	@Override
	public void onLoad() {
		CustConfig = new CustDataConfig("MC_Config.txt");

		Sorter = new PlayerDataSorter(CustConfig.getUserDataPath(), CustConfig.getSQLAdre(), CustConfig.getUserName(),
				CustConfig.getSQLPW());
		
		Twitter = new TwitMain(CustConfig.getToken(), CustConfig.getToken_Secret(), CustConfig.getAPIKey(),
				CustConfig.getAPI_Secret());
		Sorter.Sorting();
		Twitter.Build();
		Twitter.Tweet(CustConfig.getOpenMessage());
	}

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(new PlayerBackEnd(), this);
		Bukkit.getPluginManager().registerEvents(new WorldEnvirSys(), this);
		Bukkit.getPluginManager().registerEvents(new BombSet(), this);
		
		// Specialrecipe
		new TNTBomb(BombType.Bomb, this);
		new TNTBomb(BombType.Nuclear, this);
		new TNTBomb(BombType.Howitzer, this);
	}
}
