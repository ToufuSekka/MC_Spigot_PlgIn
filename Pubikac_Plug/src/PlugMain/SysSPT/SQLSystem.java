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
		
		if(LookSelector.length == 0 || CondCulom.equals(null)) 
			this.QueryBuild.append("SELECT * FROM "+TableName);
		else 
			this.QueryBuild.append("SELECT ("+String.join(",",LookSelector)+") FROM "+TableName+" WHERE");
		
		for(int x= 0;x < CondCulom.length;x++) {
			if(x == CondCulom.length-1) 
				this.QueryBuild.append(CondCulom[x]+"=?;");
			else 
				this.QueryBuild.append(CondCulom[x]+"=? AND ");
		}
		
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
		this.Query = "";
		return LisObj;
	}
	
	
	public void Modifier(String TableName, String[][] Mdf_ColumNDDatas, String[][] Cond_CulomANDDatas) {
		if(Mdf_ColumNDDatas[0].length != Mdf_ColumNDDatas[1].length)
			new IllegalArgumentException("CondCulom와 CondCulom의 갯수를 맞춰 주십시오.");
		
		this.QueryBuild.append("UPDATE "+TableName+" SET ");
		
		for(int x= 0;x < Mdf_ColumNDDatas[0].length;x++) {
			if(x == Mdf_ColumNDDatas[0].length-1) 
				this.QueryBuild.append(Mdf_ColumNDDatas[0][x]+"=?;");
			else 
				this.QueryBuild.append(Mdf_ColumNDDatas[0][x]+"=? AND ");
		}
		
		this.QueryBuild.append(" WHERE ");
		
		for(int x= 0;x < Cond_CulomANDDatas[0].length;x++) {
			if(x == Cond_CulomANDDatas[0].length-1) 
				this.QueryBuild.append(Cond_CulomANDDatas[0][x]+"=?;");
			else 
				this.QueryBuild.append(Cond_CulomANDDatas[0][x]+"=? AND ");
		}
		
		INIT();
		try {
			this.ppst = this.con.prepareStatement(this.Query);
		}catch(SQLException SQLe) {
			
		}
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
}
