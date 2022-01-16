package org.spigotmc.spigot.EventSys;

import java.io.*;

import org.spigotmc.spigot.SysSpt.*;

public class PlayerDataSorter extends SQLSystem {
	
	public void Sorting() {
		
		//That is Linux Ubuntu
		File LinuxStatFiles = new File("/minecraftserver/world/stats");
		File LinuxDataFiles = new File("/minecraftserver/world/playerdata");
		
		//That is Linux Ubuntu
		//File WinStatFiles = new File("E:/Minecraft/MineCraftSoloTestWorld/world/stats");
		//File WinDataFiles = new File("E:/Minecraft/MineCraftSoloTestWorld/world/playerdata");
		
		File[] StatFileList = LinuxStatFiles.listFiles();
		File[] DataFileList = LinuxDataFiles.listFiles();
		
		//this is .json
		for (File file : StatFileList) {
			String str = file.getName();
			boolean BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { str.replace(".json", "") });
			System.out.print("read new Data :: ");
			
			if(BL){
				System.out.println("Found JSON Data : -> "+str);
			}else {
				System.out.println("Deleted JSON : -> "+str);
				file.delete();
			}
		}
		
		//this is .dat
		for (File file : DataFileList) {
			boolean BL = true;
			
			String str = file.getName();
			if(str.endsWith(".dat_old")) {
				BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { str.replace(".dat_old", "") });
				System.out.print("read Old Data :: ");
			}else {
				BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { str.replace(".dat", "") });
				System.out.print("read new Data :: ");
			}
			
			if(BL){
				System.out.println("Found DAT Data : -> "+str);
			}else {
				System.out.println("Deleted DAT : -> "+str);
				file.delete();
			}
		}
	}
}