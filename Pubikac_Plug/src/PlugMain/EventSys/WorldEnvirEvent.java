package PlugMain.EventSys;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class WorldEnvirEvent implements Listener{
	
	Player p;
	World w;
	/**
	 * ����, Ȱ���Ҷ� ���� ���̸� �����ϴ� ����.</br>
	 * �ð��� ������ ���� "������"�ø�����
	 */
	@EventHandler
	public void Aero(PlayerMoveEvent PMe) {
		p = PMe.getPlayer();
		
		if(p.getLocation().getY() > 256 && p.isGliding()) {
			p.setGliding(false);
		}
	}
	
	
}
