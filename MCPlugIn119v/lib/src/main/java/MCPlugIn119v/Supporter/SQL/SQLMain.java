package MCPlugIn119v.Supporter.SQL;

import java.sql.*;

/**데이터베이스 관련 보조 시스탬
 * @since 2022-2-27
 * @author TouhuSekka*/
public class SQLMain {
	// private static String SERVER_local= "jdbc:mysql://localhost:3306/mctotalsys";
	private static String SERVER = "jdbc:mysql://mc-neptuneserver.servegame.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";
	
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;
	
	private SQLCMD_Reserved ReservedType;
	private String UUID;
	
	private String Query;

	public SQLMain(SQLCMD_Reserved Reserve, String UUID) {
		INIT();
		Query = Reserve.GetQuery();
		try {
			ppst = con.prepareStatement(Query);

			this.ppst.setString(1, UUID);// UUID
			
			switch (Reserve) {
			case Rigist:
				this.ppst.executeUpdate();
				break;
			case Login:
				this.ppst.executeUpdate();
				break;
			case SearchUser:
				this.Res = this.ppst.executeQuery();//SoloSearcher
				break;
			case GameLeft:
				this.ppst.executeUpdate();
				break;
			default:
				break;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		CloseAll();
	}
	
	public SQLMain() {
		INIT();
		Query = ReservedType.GetQuery();
		try {
			ppst = con.prepareStatement(Query);

			this.ppst.setString(1, UUID);// UUID
			
			switch (ReservedType) {
			case Rigist:
				this.ppst.executeUpdate();
				break;
			case Login:
				this.ppst.executeUpdate();
				break;
			case SearchUser:
				this.Res = this.ppst.executeQuery();//SoloSearcher
				break;
			case GameLeft:
				this.ppst.executeUpdate();
				break;
			default:
				break;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		
		CloseAll();
	}
	
	public void SetReserve(SQLCMD_Reserved Type) {
		this.ReservedType = Type;
	}
	
	public SQLCMD_Reserved GetReserve() {
		return this.ReservedType;
	}
	
	
	public boolean ReservedSQL(SQLCMD_Reserved Type, String[] Datas) {
		boolean Checker = false;
		this.Query = Type.GetQuery();

		INIT();
		try {
			ppst = con.prepareStatement(Query);

			switch (Type) {
			case Rigist:
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				break;
			case Login:
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case SearchUser:
				this.ppst.setString(1, Datas[0]);// UUID
				this.Res = this.ppst.executeQuery();
				Checker = this.Res.next();
				break;
			case GameLeft:
				this.ppst.setString(1, Datas[0]);// UUID, LiftTime
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case TimeChecker:
				this.ppst.setString(1, Datas[0]);// UUID
				this.Res = this.ppst.executeQuery();
				int Timer = this.Res.getInt(1);
				if(Timer > 0)
					Checker = true;
					else Checker = false;
				break;
			default:
				Checker = false;
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		CloseAll();
		return Checker;
	}

	
	
	private void INIT() {
		try {
			// This is just TESTSERVER VERSION!
			// DO NOT use for public mc_Server
			// con = DriverManager.getConnection(SERVER_local,"root",null);
			con = DriverManager.getConnection(SERVER, "mcplayer", "vonrk08217");
		} catch (SQLException SQLe) {
			SQLe.printStackTrace();
		}
	}

	private void CloseAll() {
		try {
			if (!this.Res.isClosed())
				this.Res.close();
			if (!this.ppst.isClosed())
				this.ppst.close();
			if (!this.con.isClosed())
				this.con.close();

		} catch (SQLException SQLe) {
			// To Something?
		}
	}	
}
