package MCPlugIn119v.Eventer;

import java.io.*;

import MCPlugIn119v.Supporter.SQL.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka 일단, 데이터 정리기.
 */
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

		FileChecker(LinuxStatFiles.listFiles(), ".json");
		FileChecker(LinuxDataFiles.listFiles(), ".dat_old");
		FileChecker(LinuxDataFiles.listFiles(), ".dat");

	}

	private void FileChecker(File[] FileList, String Excepter) {
		for (File f : FileList) {
			boolean BL = true;
			String FileName = f.getName();

			if (FileName.endsWith(Excepter)) {
				BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { FileName.replace(Excepter, "") });
				System.out.println("read  Data :: " + FileName);
			}

			if (BL) {
				System.out.println("Exist User : -> " + FileName);
			} else {
				System.out.println("Deleted : -> " + FileName);
				f.delete();
			}
		}
	}
}
