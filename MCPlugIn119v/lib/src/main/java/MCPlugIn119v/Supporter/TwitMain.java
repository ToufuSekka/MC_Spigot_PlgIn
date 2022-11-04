package MCPlugIn119v.Supporter;

import io.github.redouane59.twitter.*;
import io.github.redouane59.twitter.dto.tweet.*;
import io.github.redouane59.twitter.signature.*;

/**
 * @author TouhuSekka
 */
public class TwitMain {
	private String AccessToken;
	private String AccessToken_Secret;
	private String ComsumeAPIKey;
	private String ComsumeAPI_Secret;

	private TwitterClient TwitClie;

	public TwitMain(String TweetText) {
		Build();
		Tweet(TweetText);
	}

	public TwitMain(String Token, String Token_Secret, String Key, String Key_Secret) {
		this.AccessToken = Token;
		this.AccessToken_Secret = Token_Secret;
		this.ComsumeAPIKey = Key;
		this.ComsumeAPI_Secret = Key_Secret;
	}

	public void SetTokens(String Token, String Token_Secret) {
		this.AccessToken = Token;
		this.AccessToken_Secret = Token_Secret;
	}

	public void SetAPIKeys(String Key, String Key_Secret) {
		this.ComsumeAPIKey = Key;
		this.ComsumeAPI_Secret = Key_Secret;
	}

	public boolean Tweet(String Texts) {
		Tweet twt = TwitClie.postTweet(Texts);
		return false;
	}

	public boolean Build() {
		TwitClie = new TwitterClient(TwitterCredentials.builder().accessToken(AccessToken)
				.accessTokenSecret(AccessToken_Secret).apiKey(ComsumeAPIKey).apiSecretKey(ComsumeAPI_Secret).build());
		return false;
	}
}