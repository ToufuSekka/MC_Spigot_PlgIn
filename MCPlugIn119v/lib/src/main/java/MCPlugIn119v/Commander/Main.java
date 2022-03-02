package MCPlugIn119v.Commander;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Main implements CommandExecutor {

	Player P;

	@Override
	public boolean onCommand(CommandSender CMDsender, Command cmnd, String MainCMD, String[] SubCMDs) {

		if (CMDsender instanceof Player && MainCMD.equalsIgnoreCase("Store")) {
			P = (Player) CMDsender;

			switch (SubCMDs[0]) {
			case "":
				P.openMerchant(null, true);
				break;
			default:
				P.sendMessage("You unable to open :: Nothing");
				break;
			}
		}
		return false;
	}

}
