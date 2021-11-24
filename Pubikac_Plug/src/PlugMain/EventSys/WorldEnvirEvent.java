package PlugMain.EventSys;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class WorldEnvirEvent implements Listener{
	
	Player p;
	World w;
	/**
	 * 대충, 활공할때 나는 높이를 제한하는 것임.</br>
	 * 시간이 지남에 따라 "언젠간"늘릴거임
	 */
	@EventHandler
	public void Aero(PlayerMoveEvent PMe) {
		p = PMe.getPlayer();
		
		if(p.getLocation().getY() > 256 && p.isGliding()) {
			p.setGliding(false);
		}
	}
	
	
}
