package org.spigotmc.spigot.SysSpt;

import java.sql.*;

public class SQLSystem {
	
	//That is Inly Test Server. Do not Delete it!
	private static String SERVER_local= "jdbc:mysql://localhost:3306/mctotalsys";
	
	//That is RealServer
	//private static String SERVER= "jdbc:mysql://wint0719.codns.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";
	
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private String Query;
	
	public boolean ReservedSQL(SQLCMD_Reserved Type, String[] Datas) {
		boolean Checker = false;
		this.Query=Type.GetQuery();
		
		INIT();
		
		try {
			this.ppst = this.con.prepareStatement(Query);
			
			switch (Type) {
			case Rigist:
				this.ppst.setString(1, Datas[0]);//UUID
				this.ppst.executeUpdate();
				break;
			case Login:
				this.ppst.setString(1, Datas[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case SearchUser:
				this.ppst.setString(1, Datas[0]);//UUID
				this.Res = this.ppst.executeQuery();
				Checker = this.Res.first();
				break;
			case GameLeft:
				this.ppst.setString(1, Datas[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
				default :
					Checker = false;
				break;
			}
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		CloseAll();
		return Checker;
	};
	
	private void INIT() {
		try {
			//This is just TESTSERVER VERSION!
			//DO NOT use for public mc_Server
			this.con = DriverManager.getConnection(SERVER_local,"root",null);
			
			
			//this.con = DriverManager.getConnection(SERVER,"mcplayer","vonrk08217");
		}catch(SQLException SQLe){
			SQLe.printStackTrace();
		}
	}
	
	private void CloseAll() {
		try {
			if(!this.Res.isClosed())
				this.Res.close();
			if(!this.ppst.isClosed())
				this.ppst.close();
			if(!this.con.isClosed())
				this.con.close();
		
		}catch(SQLException SQLe) {
			// To Something?
		}
	}
}
