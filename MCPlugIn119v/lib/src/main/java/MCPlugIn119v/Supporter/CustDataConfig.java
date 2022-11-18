package MCPlugIn119v.Supporter;

import java.io.*;

public class CustDataConfig {

	private FileReader ConfFile;
	private BufferedReader BffRead;
	private String Line, BigSort;

	private String SQLAdre, UserName, SQLPW;
	private String Token, Token_Secret, APIKey, API_Secret;
	
	public CustDataConfig(String FilePath) {
		try {
			ConfFile = new FileReader(FilePath + "CstCnfFile.txt");
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

		if (ReadData.startsWith("$SQLServer")) {
			BigSort = "SQLServer";
		} else if (ReadData.startsWith("ServerAdress")
				&& BigSort.equals("SQLServer")) {
			SQLAdre = ReadData.split("=")[1];

		} else if (ReadData.startsWith("UserName")
				&& BigSort.equals("SQLServer")) {
			UserName = ReadData.split("=")[1];
		} else if (ReadData.startsWith("Password")
				&& BigSort.equals("SQLServer")) {
			SQLPW = ReadData.split("=")[1];
		} else if (ReadData.startsWith("$Twitter")) {
			BigSort = "Twitter";
		} else if (ReadData.startsWith("AccessToken")
				&& BigSort.equals("Twitter")) {
			SQLAdre = ReadData.split("=")[1];
		} else if (ReadData.startsWith("AccessToken_Secret")
				&& BigSort.equals("Twitter")) {
			Token_Secret = ReadData.split("=")[1];
		} else if (ReadData.startsWith("ComsumeAPIKey")
				&& BigSort.equals("Twitter")) {
			APIKey = ReadData.split("=")[1];
		} else if (ReadData.startsWith("ComsumeAPI_Secret")
				&& BigSort.equals("Twitter")) {
			API_Secret = ReadData.split("=")[1];
		} else if (ReadData.startsWith("$PlayerDataFile")) {

		} else
			return;
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

}
