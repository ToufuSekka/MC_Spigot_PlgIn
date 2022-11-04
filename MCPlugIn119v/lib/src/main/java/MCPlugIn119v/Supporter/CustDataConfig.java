package MCPlugIn119v.Supporter;

import java.io.*;

public class CustDataConfig {

	private FileReader ConfFile;
	private BufferedReader BffRead;
	private String Line, BigSort;

	public CustDataConfig(String FilePath) {
		try {
			ConfFile = new FileReader("CstCnfFile.txt");
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
		String Spliter;

		if (ReadData.startsWith("$SQLServer")) {
			BigSort = "SQLServer";
		} else if (ReadData.startsWith("ServerAdress") && BigSort.equalsIgnoreCase("SQLServer")) {

		} else if (ReadData.startsWith("UserName") && BigSort.equalsIgnoreCase("SQLServer")) {

		} else if (ReadData.startsWith("Password") && BigSort.equalsIgnoreCase("SQLServer")) {

		} else if (ReadData.startsWith("$Twitter")) {
			BigSort = "Twitter";
		} else if (ReadData.startsWith("AccessToken") && BigSort.equalsIgnoreCase("Twitter")) {

		} else if (ReadData.startsWith("AccessToken_Secret") && BigSort.equalsIgnoreCase("Twitter")) {

		} else if (ReadData.startsWith("ComsumeAPIKey") && BigSort.equalsIgnoreCase("Twitter")) {

		} else if (ReadData.startsWith("ComsumeAPI_Secret") && BigSort.equalsIgnoreCase("Twitter")) {

		} else if (ReadData.startsWith("$PlayerDataFile")) {

		} else
			return;
	}
}
