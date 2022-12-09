package MCPlugIn119v.Eventer;

import java.io.*;

import MCPlugIn119v.Supporter.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka.
 */
public class PlayerDataSorter {

	private SQLMain sqlmain;
	private File StatFiles, DataFiles;

	public PlayerDataSorter(String ServerDirectory, SQLMain SQLData) {
		sqlmain = SQLData;
		StatFiles = new File(ServerDirectory + "/world/stats");
		DataFiles = new File(ServerDirectory + "/world/playerdata");
	}

	public PlayerDataSorter(String ServerDirectory, String SQLAdre, String UserName, String SQLPW) {
		sqlmain = new SQLMain(SQLAdre, UserName, SQLPW);
		StatFiles = new File(ServerDirectory + "/world/stats");
		DataFiles = new File(ServerDirectory + "/world/playerdata");
	}

	public void Sorting() {
		FileChecker(StatFiles.listFiles(), ".json");
		FileChecker(DataFiles.listFiles(), ".dat_old");
		FileChecker(DataFiles.listFiles(), ".dat");
	}

	private void FileChecker(File[] FileList, String Excepter) {

		if (FileList.equals(null) || FileList.length == 0)
			return;

		for (File f : FileList) {
			String FileName = f.getName();
			sqlmain.SetUUID(FileName.replace(Excepter, ""));

			if (FileName.endsWith(Excepter)) {
				System.out.print("read :: " + FileName + ", ");
				if (sqlmain.UserCheck()) {
					System.out.println("Exist->" + FileName);
				} else {
					System.out.println("Deleted=>" + FileName);
					f.delete();
				}
			}
		}
	}
}
