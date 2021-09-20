package PlugMain.SysSPT;

import java.sql.*;

public class SQLSystem {
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private String Query="";
	private int TimeData=0;
		
	public boolean Reserv_(SQLCMD_Reserved ReserveType, String[] Data) {
		boolean Checker = false;
		this.Query="";
		this.TimeData=0;
		this.Query = ReserveType.GetQuery();

		INIT();		
		try {
			this.ppst = this.con.prepareStatement(this.Query);
			
			switch(ReserveType){
			case SearchUser:
				this.ppst.setString(1, Data[0]);
				this.Res = this.ppst.executeQuery();
				Checker = this.Res.first();
				break;
			case TimeLimiter:
				this.ppst.setString(1, Data[0]);
				this.Res = this.ppst.executeQuery();
				while(Res.next()) {
					this.TimeData = this.Res.getInt(1);
					}
				if(this.TimeData > 0)
					Checker = true;
				break;
			case TimeCulcurateor:
				this.TimeData = Integer.parseInt(Data[0]);
				this.ppst.setInt(1, this.TimeData);
				this.ppst.setString(2, Data[1]);
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case Rigist:
				this.ppst=this.con.prepareStatement(this.Query);
				this.ppst.setString(1, Data[0]);
				this.ppst.setInt(2, 3000000);
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
			
		}
		TheClose();
		return false;
	}
			
	private void INIT() {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mctotalsys","root",null);
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
