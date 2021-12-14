package org.spigotmc.spigot.SysSpt;

import java.sql.*;

public class SQLSystem {
	
	//That is Inly Test Server. Do not Delete it!
	private static String SERVER= "jdbc:mysql://localhost:3306/mctotalsys";
	
	//Tha is RealServer
	//private static String SERVER= "jdbc:mysql://wint0719.codns.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";
	
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private String Query;
	
	public boolean Reserve(SQLCMD_Reserved Type, String[] Datas) {
		boolean Checker = false;
		this.Query="";
		this.Query = Type.GetQuery();
		
		return Checker;
	};
	
	private void INIT() {
		
	}
	
	private void CloseAll() {}
}
