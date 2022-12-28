package MCPlugIn119v.Eventer;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

/**@since 2022-12-28
 * @author TouhuSekka
 * */
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