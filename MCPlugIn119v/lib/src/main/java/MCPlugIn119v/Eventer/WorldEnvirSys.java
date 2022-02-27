package MCPlugIn119v.Eventer;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;;

public class WorldEnvirSys implements Listener{
	Player P;
	
	@EventHandler
	public void FlyingStall(PlayerMoveEvent PMe) {
		P = PMe.getPlayer();
		
		if(P.getLocation().getY() > 384 && P.isGliding()) {
			P.setGliding(false);
		}
	}
}
