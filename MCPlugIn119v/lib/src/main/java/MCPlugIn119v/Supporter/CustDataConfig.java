package MCPlugIn119v.Supporter;

import java.io.*;

/**
 * &since 2022-11-19 &author TouhuSekka
 **/
public class CustDataConfig {

	private FileReader ConfFile;
	private BufferedReader BffRead;
	private String Line;

	private String SQLAdre, UserName, SQLPW;
	private String Token, Token_Secret, APIKey, API_Secret;
	private String UserDataPath;

	public CustDataConfig(String FilePath) {
		try {
			ConfFile = new FileReader(FilePath);
			BffRead = new BufferedReader(ConfFile);

			do {
				Line = BffRead.readLine();
				Parsing(Line);

			} while (!Line.equals(null));
		} catch (Exception e) {
			//
		}
	}

	private void Parsing(String ReadData) {
		String[] Divider;

		if (ReadData.startsWith("&")) {
			Divider = ReadData.split("=");
			switch (Divider[0]) {
			case "&ServerAdress":
				SQLAdre = Divider[1];
				break;
			case "&UserName":
				UserName = Divider[1];
				break;
			case "&Password":
				SQLPW = Divider[1];
				break;
			case "&AccessToken":
				Token = Divider[1];
				break;
			case "&AccessToken_Secret":
				Token_Secret = Divider[1];
				break;
			case "&ComsumeAPIKey":
				APIKey = Divider[1];
				break;
			case "&ComsumeAPI_Secret":
				API_Secret = Divider[1];
				break;
			case "&PlayerDataFile":
				UserDataPath = Divider[1];
				break;
			default:
				return;
			}
		}

	}

	public String getSQLAdre() {
		return SQLAdre;
	}

	public String getUserName() {
		return UserName;
	}

	public String getSQLPW() {
		return SQLPW;
	}

	public String getToken() {
		return Token;
	}

	public String getToken_Secret() {
		return Token_Secret;
	}

	public String getAPIKey() {
		return APIKey;
	}

	public String getAPI_Secret() {
		return API_Secret;
	}

	public String getUserDataPath() {
		return UserDataPath;
	}

}
