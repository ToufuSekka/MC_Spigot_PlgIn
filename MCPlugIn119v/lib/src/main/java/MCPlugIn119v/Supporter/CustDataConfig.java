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
	private String OpenMessage, CloseMessage;

	public CustDataConfig(String FilePath) {
		try {
			ConfFile = new FileReader(FilePath);
			BffRead = new BufferedReader(ConfFile);

			do {
				Line = BffRead.readLine();
				Parsing(Line);
			} while (!Line.equals(null));
			System.out.print("End of Initialization : Server Data Config");
		} catch (Exception e) {
			//
		}
	}

	private void Parsing(String ReadData) {
		String[] Divider;

		if (ReadData.startsWith("&")) {
			Divider = ReadData.split("=", 2);
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
			case "&ServerOpenMSG":
				OpenMessage = Divider[1];
				break;
			case "&ServerCloseMSG":
				CloseMessage = Divider[1];
				break;
			default:
				return;
			}
		}
	}

	private String enterer(String str) {
		String result = "";
		String[] Divs = str.split("</br>");

		StringBuilder SB = new StringBuilder();
		for (String forstr : Divs) {
			SB.append(forstr);
			SB.append(System.lineSeparator());
		}

		result = SB.toString();
		return result;
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

	// 이 두놈은 개행버그 있음. 고쳐야함 ㅅㅂ;;
	public String getOpenMessage() {
		return enterer(OpenMessage);
	}

	public String getCloseMessage() {
		return enterer(CloseMessage);
	}
}
