package org.spigotmc.spigot.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class StoreSet implements CommandExecutor {
	private Player User;
	
	
	public boolean onCommand(CommandSender ComSender, Command arg1, String MainCMD, String[] SubCMDs) {
		if(ComSender instanceof Player && MainCMD.equalsIgnoreCase("Store")) {
			User = (Player) ComSender;

			switch (SubCMDs[0]) {
			case "bank":
				User.openMerchant(null, true);
				break;
			default:
				User.sendMessage("Not Found STORE");
				break;
			}
		}
		return false;
	}
}
