package MCPlugIn119v.Eventer;

import java.io.*;

import MCPlugIn119v.Supporter.SQL.*;

public class PlayerDataSorter extends SQLMain {

	public void Sorting() {
		// That is Linux Ubuntu
		File LinuxStatFiles = new File("/minecraftserver/world/stats");
		File LinuxDataFiles = new File("/minecraftserver/world/playerdata");

		// That is Windows
		// File WinStatFiles = new
		// File("E:/Minecraft/MineCraftSoloTestWorld/world/stats");
		// File WinDataFiles = new
		// File("E:/Minecraft/MineCraftSoloTestWorld/world/playerdata");

		File[] DataFileList = LinuxDataFiles.listFiles();

		FileChecker(LinuxStatFiles.listFiles(), ".json");
		FileChecker(LinuxDataFiles.listFiles(), ".dat_old");
		FileChecker(LinuxStatFiles.listFiles(), ".dat");

	}

	private void FileChecker(File[] FileList, String Excepter) {
		for (File f : FileList) {
			boolean BL = true;
			String FileName = f.getName();

			if (FileName.endsWith(Excepter)) {
				BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { FileName.replace(Excepter, "") });
				System.out.print("read  Data :: " + FileName);
			}

			if (BL) {
				System.out.println("Found : -> " + FileName);
			} else {
				System.out.println("Deleted : -> " + FileName);
				f.delete();
			}
		}
	}
}
