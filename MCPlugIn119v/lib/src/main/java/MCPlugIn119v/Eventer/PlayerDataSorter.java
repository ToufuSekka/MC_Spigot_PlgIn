package MCPlugIn119v.Eventer;

import java.io.*;

import MCPlugIn119v.Supporter.*;

/**
 * @since 2022-02-28
 * @author ToufuSekka.
 */
public class PlayerDataSorter {

	public void Sorting() {
		// That is Linux Ubuntu
		File LinuxStatFiles = new File("/minecraftserver/world/stats");
		File LinuxDataFiles = new File("/minecraftserver/world/playerdata");

		// That is Windows
		// File WinStatFiles = new
		// File("E:/Minecraft/MineCraftSoloTestWorld/world/stats");
		// File WinDataFiles = new
		// File("E:/Minecraft/MineCraftSoloTestWorld/world/playerdata");

		// Stat Data
		FileChecker(LinuxStatFiles.listFiles(), ".json");

		// FullData
		FileChecker(LinuxDataFiles.listFiles(), ".dat_old");
		FileChecker(LinuxDataFiles.listFiles(), ".dat");

	}

	private void FileChecker(File[] FileList, String Excepter) {

		for (File f : FileList) {
			String FileName = f.getName();
			SQLMain UserSearcher = new SQLMain(FileName.replace(Excepter, ""));

			if (FileName.endsWith(Excepter)) {
				System.out.print("read :: " + FileName + ", ");
				if (UserSearcher.UserCheck()) {
					System.out.println("Exist -> " + FileName);
				} else {
					System.out.println("Deleted -> " + FileName);
					f.delete();
				}
			}
		}
	}
}
