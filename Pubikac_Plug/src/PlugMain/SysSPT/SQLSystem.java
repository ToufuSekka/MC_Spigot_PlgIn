package PlugMain.SysSPT;

import java.sql.*;

public class SQLSystem {
	
	//private static String SERVER= "jdbc:mysql://localhost:3306/mctotalsys";
	private static String SERVER= "jdbc:mysql://wint0719.codns.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;

	private String Query="";

	/**
	 * 
	 * @param ReserveType
	 * @param Data
	 * @return if Data Collect true.
	 */
	public boolean Reserv_(SQLCMD_Reserved ReserveType, String[] Data) {
		boolean Checker = false;
		this.Query="";
		this.Query = ReserveType.GetQuery();

		INIT();		
		try {
			this.ppst = this.con.prepareStatement(this.Query);
			
			switch(ReserveType){
			case Rigist:
				this.ppst=this.con.prepareStatement(this.Query);
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case SearchUser:
				this.ppst.setString(1, Data[0]);//UUID
				this.Res = this.ppst.executeQuery();
				Checker = this.Res.first();
				break;
			case Login:
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case GameLeft:
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			default:
				Checker = false;
				break;
			}
			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		TheClose();
		return Checker;
	}
	
	public boolean ServerChecker(){
		INIT();
		try {
			if(con.isValid(60)) {
				//
			}
		}catch(SQLException SQLe) {
			//
		}
		TheClose();
		return false;
	}
			
	private void INIT() {
		try {
			//this.con = DriverManager.getConnection(SERVER,"root",null);
			this.con = DriverManager.getConnection(SERVER,"mcplayer","vonrk08217");
		}catch (SQLException SQLe) {
			SQLe.printStackTrace();
		}
	}
	
	private void TheClose() {
		try {
			if(!this.Res.isClosed())
				this.Res.close();
			if(!this.ppst.isClosed())
				this.ppst.close();
			if(!this.con.isClosed())
				this.con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
