package MCPlugIn119v.Supporter.Discord;

import discord4j.core.*;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.event.domain.message.MessageCreateEvent;

/**
 * µðÄÚ¿ë
 * 
 * @author ToufuSekka
 *
 */
public class DscdMain {

	private final String Token = "OTY0MDYyNzM0NDE5MzkwNDk1.YlfLYw.qPiUGHcvzlou9PN6tEv-FTT_us0";
	
	private DiscordClient Client;
	private GatewayDiscordClient GateClient;
	private Message MSG;
	private MessageChannel MSGChe;
	
	public DscdMain(String MessageData) {
		Client = DiscordClient.create(Token);
		GateClient = Client.login().block();
		
		GateClient.on(MessageCreateEvent.class).subscribe(MSGCriEV ->{
			MSG = MSGCriEV.getMessage();
			MSGChe = MSG.getChannel().block();
			MSGChe.createMessage(MessageData);
		});
		
		GateClient.onDisconnect();
	}
}
