package MCPlugIn119v.Commander;

import org.bukkit.command.*;

/**
 * @since 2022-03-26
 * @author ToufuSekka
 */
public class CMDForConsole implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender CMDsender, Command cmnd, String MainCMD, String[] SubCMDs) {

		if (CMDsender instanceof ConsoleCommandSender && MainCMD.equalsIgnoreCase("Maintanace")) {
			
		}
		return false;
	}
}
