package org.spigotmc.spigot.EventSys;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class WorldEnvirSys implements Listener{
	Player P;
	
	@EventHandler
	public void FlyingStall(PlayerMoveEvent PMe) {
		this.P = PMe.getPlayer();
		
		if(this.P.getLocation().getY() > 384 && this.P.isGliding()) {
			this.P.setGliding(false);
		}
	}
}