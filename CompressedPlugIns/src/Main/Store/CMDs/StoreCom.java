package Main.Store.CMDs;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Main.Store.Recipes.*;

public class StoreCom implements CommandExecutor {
	Player user;
	StoreRes StoNor;
	EVT_StoreRes EVT_Sto;

	@Override
	public boolean onCommand(CommandSender cs, Command cmnd, String cmds, String[] subcmds) {

		if (cs instanceof Player && cmds.equalsIgnoreCase("store")) {
			this.user = (Player) cs;
			StoNor = new StoreRes();
			switch (subcmds[0]) {
			case "bank":
				user.openMerchant(StoNor.Bank(), true);
				break;
			case "deal":
				user.openMerchant(StoNor.Deal(), true);
				break;
			case "evt":
				user.openMerchant(StoNor.Event(), true);
				break;
			default:
				cs.sendMessage("해당하는 상점이 존재하지 않습니다.");
				break;
			}
			StoNor = null;
		}

		if (cs instanceof Player && cmds.equalsIgnoreCase("evt")) {
			this.user = (Player) cs;
			EVT_Sto = new EVT_StoreRes();

			switch (subcmds[0]) {
			case "orb":
				user.openMerchant(EVT_Sto.OrbEvent(), true);
				break;

			default:
				cs.sendMessage("해당하는 상점이 존재하지 않습니다.");
				break;
			}
			EVT_Sto = null;
		}
		return false;
	}
}