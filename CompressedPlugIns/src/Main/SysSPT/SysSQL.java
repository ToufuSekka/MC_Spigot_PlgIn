package Main.SysSPT;

import java.util.HashMap;
import java.util.Date;
import java.sql.*;

/**
 * SQLServer에 관한 클래스.
 * @author ToufuSekka
 */
public class SysSQL {
	static final private String ServerIP="http://localhost:3306/Test?useSSL=false";
	static final private String UserName="root";
	static final private String Password="";
	
	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet ReS;
	
	private HashMap<String, Object>Datas;
	private String Query= "";
	private String DatType="";
	
	public void LogInFunc(String UUID, Date LogTime) {
		INIT();
		
		Query = "SLECT * FROM 'MCUserData' WHERE UUID=?";
		
		try{
			ppst = conn.prepareStatement(Query);
			ppst.setString(0, UUID);
			ppst.setDate(1, (java.sql.Date) LogTime);
			ppst.execute();
			ReS = ppst.getResultSet();
			while(ReS.next()) {
				if(true);
			}
			
		}catch(SQLException SQLe) {
			//
		}
		END();
	}
	
	protected void Searcher(String Table, HashMap<String, Object>DataSets) {
		INIT();
		Query = "SLECT * FROM ? WHERE ";
		for(String keys : DataSets.keySet()) {
			Query += " "+keys+"=?";
			//DataSets.get(keys);
		}
		
		try {
			ppst = conn.prepareStatement("");
			ppst.setObject(0, DataSets.get(""));
		}catch(SQLException SQLe) {
			//
		}
		END();
	}
	
	private void END() {
		try {
			if(!ReS.isClosed())
				ReS.close();
			if(!ppst.isClosed())
				ppst.close();
			if(!conn.isClosed())
				conn.close();
			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
	}
	
	private void INIT() {
		try {
			conn = DriverManager.getConnection(ServerIP, UserName, Password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String TypeDivder(Object Data) {
		if(Data instanceof String) {
			//
		}else if(Data instanceof Integer) {
			//
		}else if(Data instanceof Float) {
			
		}
		
		return null;
	}
}
