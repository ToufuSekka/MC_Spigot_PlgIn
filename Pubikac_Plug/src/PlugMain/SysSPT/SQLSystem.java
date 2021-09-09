package PlugMain.SysSPT;

import java.util.ArrayList;
import java.sql.*;

public class SQLSystem {
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private StringBuilder QueryBuild = new StringBuilder();
	private String Query="";
	
	private Object[] DatOrigin = {};
	
	public boolean ServerChecker(){
		INIT();
		return false;
	}
	
	public boolean Rigister(String UUID) {
		INIT();
		this.Query = "INSERT INTO MCUserData(UUID, LeftTime) VALUE (?,?);";
		try {
			this.ppst=this.con.prepareStatement(this.Query);
			this.ppst.setString(0, UUID);
			this.ppst.setInt(1, 3000000);
			this.ppst.execute();
			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
			return false;
		}finally {
			TheClose();
		}
		return true;
	}
	
	public ArrayList<Object[]> Searcher(String TableName, String[] LookSelector, String[] CondCulom, Object[] CondData) {
		ArrayList<Object[]> LisObj = new ArrayList<Object[]>();
		
		if(CondCulom.length != CondData.length)
			new IllegalArgumentException("CondCulom와 CondCulom의 갯수를 맞춰 주십시오.");
		
		this.Query = QueryCreator(LookSelector, CondCulom);
		INIT();
		try {
			this.ppst = this.con.prepareStatement(this.Query);
			for(int r = 0;r < CondData.length;r++) {
				this.ppst.setObject(r, CondData[r]);
			}
			this.Res = this.ppst.executeQuery();
			while(this.Res.next()) {
				for(int y = 0;y < LookSelector.length;y++) {
					this.DatOrigin[y]= this.Res.getObject(y);
				}
				LisObj.add(this.DatOrigin);
			}
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		TheClose();
		return LisObj;
	}
	
	
	protected void Modifier(String TableNme) {
		INIT();
		TheClose();
	}
	
	protected void Creater(String TableNme, String[] SetCulom, Object[] Values) {
		INIT();
		TheClose();
	}
	
	protected void Deleter(String TableNme) {
		INIT();
		TheClose();
	}
	
	private void INIT() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://wint0719.ipdisk.co.kr:3306/test","root","vonrk08217!");
		}catch(ClassNotFoundException CNFe) {
			CNFe.printStackTrace();
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
	
	private String QueryCreator(String[] SelectLooker, String[] ConditionCulomm) {
		this.QueryBuild.setLength(0);
		
		if(SelectLooker.length == 0 || SelectLooker.equals(null)) {
			this.QueryBuild.append("SELECT * FROM");
		}else {
			this.QueryBuild.append("SELECT ("+String.join(",",SelectLooker)+") FROM WHERE");
		}
		
		for(int x= 0;x < ConditionCulomm.length;x++) {
			if(x == ConditionCulomm.length-1) {
				this.QueryBuild.append(ConditionCulomm[x]+"=?;");
			}else {
				this.QueryBuild.append(ConditionCulomm[x]+"=? AND ");
			}
		}
		return this.QueryBuild.toString();
	}
}
