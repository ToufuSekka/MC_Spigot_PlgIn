package MCPlugIn119v.Supporter.Twitters;

import io.github.redouane59.twitter.*;
import io.github.redouane59.twitter.dto.tweet.*;
import io.github.redouane59.twitter.signature.*;

/**
 * @author TouhuSekka
 */
public class TwitMain {
	private final String AccessToken = "1483719714262388739-jTGfNQDkFZvMkJ09IUmNDYB1WUI0Di";
	private final String AccessToken_Secret = "2tawWcD8OtzdTH547JYpaUzqCqYNYIENfGYrIZg70Svh3";
	private final String ComsumeAPIKey = "whrrUAD92F19T0kpHM2PQnm6y";
	private final String ComsumeAPI_Secret = "IGbZONaY7rvTthNUHQc02Y6JsF9VJwznc7NWdUctyzWCNrMQeo";
	
	public void ServerMSGTwit(String TweetText) {

		TwitterClient TwitClie = new TwitterClient(TwitterCredentials.builder().accessToken(AccessToken)
				.accessTokenSecret(AccessToken_Secret).apiKey(ComsumeAPIKey).apiSecretKey(ComsumeAPI_Secret).build());

		Tweet twt = TwitClie.postTweet(TweetText);
	}
}