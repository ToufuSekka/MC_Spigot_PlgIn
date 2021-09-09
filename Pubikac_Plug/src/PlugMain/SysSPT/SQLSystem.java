package PlugMain.SysSPT;

import java.util.ArrayList;
import java.sql.*;

public class SQLSystem {
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private StringBuilder QueryBuild = new StringBuilder();
	private StringBuilder ViewCoder = new StringBuilder();
	private String Query="";
	
	private Object[] DatOrigin = {};
	//
	public void Rigister(String UUID) {
		INIT();
		Query = "INSERT INTO MCUserData(UUID, LeftTime) VALUE (?,?);";
		try {
			ppst=con.prepareStatement(Query);
			ppst.setString(0, UUID);
			ppst.setInt(1, 3000000);
			ppst.execute();			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		TheClose();
	}
	
	public ArrayList<Object[]> Searcher(String TableName, String[] LookSelector, String[] CondCulom, Object[] CondData) {
		ArrayList<Object[]> LisObj = new ArrayList<Object[]>();
		
		if(CondCulom.length != CondData.length)
			new IllegalArgumentException("같은 Cond의 갯수를 맞춰주십시오.");
		
		Query = QueryCreator(LookSelector, CondCulom);
		
		INIT();
		
		try {
			ppst = con.prepareStatement(Query);
			for(int r = 0;r < CondData.length;r++) {
				ppst.setObject(r, CondData[r]);
			}
			Res = ppst.executeQuery();
			while(Res.next()) {
				for(int y = 0;y < LookSelector.length;y++) {
					DatOrigin[y]= Res.getObject(y);
				}
			}
			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		
		TheClose();
		
		return LisObj;
	}
	
	public void Modifier(String TableNme) {
		INIT();
		TheClose();
	}
	
	public void Creater(String TableNme, String[] SetCulom, Object[] Values) {
		INIT();
		TheClose();
	}
	
	public void Deleter(String TableNme) {
		INIT();
		TheClose();
	}
	
	private void INIT() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://wint0719.ipdisk.co.kr:3306/test","root","vonrk08217!");
			
		}catch(ClassNotFoundException CNFe) {
			CNFe.printStackTrace();
		}catch (SQLException SQLe) {
			SQLe.printStackTrace();
		}
	}
	
	private void TheClose() {
		try {
			if(!Res.isClosed())
				Res.close();
			if(!ppst.isClosed())
				ppst.close();
			if(!con.isClosed())
				con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private String QueryCreator(String[] SelectLooker, String[] ConditionCulomm) {
		QueryBuild.setLength(0);
		
		if(SelectLooker.length == 0 || SelectLooker.equals(null)) {
			QueryBuild.append("SELECT * FROM");
		}else {
			QueryBuild.append("SELECT ("+String.join(",",SelectLooker)+") FROM WHERE");
		}
		
		for(int x= 0;x < ConditionCulomm.length;x++) {
			if(x == ConditionCulomm.length-1) {
				QueryBuild.append(ConditionCulomm[x]+"=?;");
			}else {
				QueryBuild.append(ConditionCulomm[x]+"=? AND ");
			}
		}
		return QueryBuild.toString();
	}
	
	private char Translator(Object Type) {
		
		if(Type instanceof Integer)
			return 'i';
		else if(Type instanceof String)
			return 's';
		else
			return 'o';
	}
}
