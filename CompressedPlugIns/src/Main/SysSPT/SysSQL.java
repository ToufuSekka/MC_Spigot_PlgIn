package Main.SysSPT;
import java.sql.*;

/**
 * 
 */
public class SysSQL {
	static final private String ServerIP="http://localhost:3306/Test?useSSL=false";
	static final private String UserName="root";
	static final private String Password="";
	
	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet rs;
	
	private String Query;
	
	private void INIT() {
		try {
			conn = DriverManager.getConnection(ServerIP, UserName, Password);
		}catch (Exception e) {
			//
		}
	}
}
