package MCPlugIn119v.Supporter.SQL;

import java.sql.*;

/**
 * 데이터베이스 관련 보조 시스탬
 * 
 * @since 2022-2-27
 * @author TouhuSekka
 */
public class SQLMain {
	// private static String SERVER_local= "jdbc:mysql://localhost:3306/mctotalsys";
	private static String SERVER = "jdbc:mysql://mc-neptuneserver.servegame.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";

	// SQL
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;

	// IN_Class
	private SQLCMD_Reserved ReservedType;
	private String UUID;
	private String MainQuery;
	private Boolean Checing;

	private int PlayTime, LestTime;

	public SQLMain(String UUID) {
		if (UUID.isEmpty())
			throw new IllegalArgumentException("UUID is Empty!");

		this.UUID = UUID;
	}

	public SQLMain(SQLCMD_Reserved Reserve) {

	}

	// Reserver
	public void SetReserve(SQLCMD_Reserved Type) {
		this.ReservedType = Type;
	}

	public SQLCMD_Reserved GetReserve() {
		return this.ReservedType;
	}

	// UUID
	public void SetUUID(String MC_UUID) {
		this.UUID = MC_UUID;
	}

	// BooleanChecker
	public Boolean SQLChecker() {
		return this.Checing;
	}

	public void SetPlayTime(int PlayTime_SCD) {
		this.PlayTime = PlayTime_SCD;
	};

	public Boolean ExecuteReserve() {
		if (ReservedType == null)
			throw new NullPointerException("Set ReserveSQL Type");
		boolean Fincheck = false;

		switch (ReservedType) {
		case Rigist:
			Fincheck = Rigist();
			break;
		case Login:
			Fincheck = Sign();
			break;
		case SearchUser:
			Fincheck = UserCheck();
			break;
		case TimeLimit:
			break;
		case GameLeft:
			Fincheck = GameLeave();
			break;
		default:
			break;
		}
		return Fincheck;
	}

	@Deprecated
	public void ReservedSQL(SQLCMD_Reserved Type, String[] Datas) {
		INIT();
		try {
			ppst = con.prepareStatement(MainQuery);

			switch (Type) {
			case Rigist:
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				break;
			case Login:
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				break;
			case SearchUser:
				this.ppst.setString(1, Datas[0]);// UUID
				this.Res = this.ppst.executeQuery();
				break;
			case GameLeft:
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				break;
			case TimeLimit:
				this.ppst.setString(1, Datas[0]);// UUID
				this.Res = this.ppst.executeQuery();
				int Timer = this.Res.getInt(1);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		CloseAll();
	}

	public boolean Rigist() {
		INIT();
		try {
			this.ppst = con.prepareStatement("INSERT INTO userdata(UUID) VALUE (?);");
			this.ppst.setString(1, this.UUID);// UUID
			int ErrorChker = this.ppst.executeUpdate();

			if (ErrorChker != 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return false;
	}

	public boolean Sign() {
		INIT();
		try {
			this.ppst = con.prepareStatement("UPDATE userdata SET LogInTime= CURRENT_TIMESTAMP WHERE UUID = ?;");
			this.ppst.setString(1, this.UUID);// UUID
			int ErrorChker = this.ppst.executeUpdate();

			if (ErrorChker != 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return false;
	}

	public boolean UserCheck() {
		INIT();
		try {
			this.ppst = con.prepareStatement("SELECT 'UUID' FROM userdata WHERE UUID=?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.Res = this.ppst.executeQuery();
			return Res.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return false;
	}

	public boolean GameLeave() {
		//시간을 제고-> 시간을 빼고-> 저장한다.
		LestTime = GetLeftTime();

		if (this.PlayTime < 0) {
			throw new NullPointerException("Insert User PlayTime(Seconds)");
		}

		INIT();
		try {
			this.ppst = con.prepareStatement("UPDATE userdata SET (LogOutTime,Lifetime)= (CURRENT_TIMESTAMP,?) WHERE UUID = ?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.ppst.executeQuery();
			this.ppst.close();
			
			this.ppst = con.prepareStatement("UPDATE userdata SET LogOutTime= CURRENT_TIMESTAMP WHERE UUID = ?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.ppst.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return false;
	}

	public int GetLeftTime() {
		int Result = 0;

		INIT();
		try {
			// Search
			this.ppst = con.prepareStatement("SELECT 'Lifetime' FROM userdata WHERE UUID=?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.Res = this.ppst.executeQuery();

			if (Res.next()) {
				Result = Res.getInt(1);
			} else {
				//
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return Result;
	}

	// Base
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
