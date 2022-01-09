package org.spigotmc.spigot.EventSys;

import java.io.*;

import org.spigotmc.spigot.SysSpt.*;

import com.google.common.annotations.*;

public class PlayerDataSorter extends SQLSystem {
	
	@VisibleForTesting
	public void Sorting() {
		File files = new File("/minecraftserver/worlds/userdata");

		File[] FileList = files.listFiles();
		
		for (File FileData : FileList) {
			String str = FileData.getName();
			boolean BL = ReservedSQL(SQLCMD_Reserved.SearchUser, new String[] { str.replace(".dat", "") });
			if(!BL){
				FileData.delete();
			}
		}
	}
}