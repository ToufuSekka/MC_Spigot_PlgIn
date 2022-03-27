package MCPlugIn119v.Commander;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import MCPlugIn119v.Recipe.Merchant.*;

/**
 * @since 2022-03-26
 * @author ToufuSekka
 */
public class CMDMain implements CommandExecutor {

	Player P;
	@Override
	public boolean onCommand(CommandSender CMDsender, Command cmnd, String MainCMD, String[] SubCMDs) {

		if (CMDsender instanceof Player && MainCMD.equalsIgnoreCase("store")) {
			P = (Player) CMDsender;
			switch (SubCMDs[0]) {
			case "exch":
				P.openMerchant(new Bank().ExchangerBanks(), true);
				break;
			default:
				P.sendMessage("You're unable to open :: Nothing");
				break;
			}
		}
		return false;
	}
}
