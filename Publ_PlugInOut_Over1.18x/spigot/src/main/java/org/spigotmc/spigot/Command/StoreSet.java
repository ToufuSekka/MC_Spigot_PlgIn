package org.spigotmc.spigot.Command;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import org.spigotmc.spigot.RecipeSet.Merchant.*;

public class StoreSet implements CommandExecutor {

	private Player User;

	Banks bank;
	public boolean onCommand(CommandSender ComSender, Command arg1, String MainCMD, String[] SubCMDs) {
		if(ComSender instanceof Player && MainCMD.equalsIgnoreCase("Store")) {
			User = (Player) ComSender;
			bank = new Banks();
			
			switch (SubCMDs[0]) {
			case "bank":				
				User.openMerchant(bank.ExchangerBank(), true);
				break;
			default:
				User.sendMessage("존제하지 않음.");
				break;
			}
		}
		return false;
	}
}
