package MCPlugIn119v.Supporter.Twitters;

import io.github.redouane59.twitter.*;
import io.github.redouane59.twitter.dto.tweet.*;
import io.github.redouane59.twitter.signature.*;

/**
 * @author TouhuSekka
 */
public class TwitMain {
	private final String AccessToken = "1407844909-bOF1ArPMBEhOBA0q8daDU8ebUxp6SBBGvanGYps";
	private final String AccessToken_Secret = "eBmLhpuM8k3jiNFJtPeBfPJxlN6NDCn7haEmyMgeujzEq";
	private final String ComsumeAPIKey = "XVI8QfK56nZf0hRr3JeOhfUnU";
	private final String ComsumeAPI_Secret = "iv2uMjLK7SgU3aijV2ydUkbZN24KisNPaavt21qBClOj27JUt2";
	
	
	@SuppressWarnings("unused")
	public void OpenServerTwit(String TweetText) {

		TwitterClient TwitClie = new TwitterClient(TwitterCredentials.builder().accessToken(AccessToken)
				.accessTokenSecret(AccessToken_Secret).apiKey(ComsumeAPIKey).apiSecretKey(ComsumeAPI_Secret).build());

		Tweet twt = TwitClie.postTweet(TweetText);
	}
}