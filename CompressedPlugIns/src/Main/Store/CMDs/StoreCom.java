package Main.Store.CMDs;

import Main.Store.Recipes.*;

public class StoreCom implements CommandExecutor {
	Player user;
	StoreRes StoNor;

	@Override
	public boolean onCommand(CommandSender cs, Command cmnd, String cmds, String[] subcmds) {

		if (cs instanceof Player && cmds.equalsIgnoreCase("store")) {
			this.user = (Player) cs;
			StoNor = new StoreRes();
			switch (subcmds[0]) {
			case "bank":
				user.openMerchant(StoNor.Bank(), true);
				break;
			default:
				cs.sendMessage("Not Found Store");
				break;
			}
			StoNor = null;
		}
		return false;
	}
}