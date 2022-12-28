package MCPlugIn119v.Eventer;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;


/**
 * @since 2022-12-28
 * @author TouhuSekka
 * */
public class PlayerFrontEnd implements Listener{
	
	Player P;
	
	@EventHandler
	public void PlayerDeath(PlayerDeathEvent PDe) {
		P = PDe.getEntity().getPlayer();
		String DeathReason = PDe.getDeathMessage();

		ItemStack Head = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta MetaHead = (SkullMeta) Head.getItemMeta();

		MetaHead.setOwningPlayer(P);
		Head.setItemMeta(MetaHead);
		P.getWorld().dropItemNaturally(P.getLocation(), Head);
		PDe.setDeathMessage("");
		P.sendMessage(DeathReason);
	}
}