package MCPlugIn119v.Supporter;

import java.sql.*;

/**
 * 데이터베이스 관련 보조 시스탬
 * 
 * @since 2022-2-27
 * @author TouhuSekka
 */
public class SQLMain {
	// private static String SERVER_local =
	// "jdbc:mysql://wint0719.ipdisk.co.kr:3306/mctotalsys";
	private static String SERVER = "jdbc:mysql://mc-neptuneserver.servegame.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";

	// SQL
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;

	// IN_Class
	private String UUID;

	private int PlayTime, LeftTime;

	public SQLMain(String UUID) {
		if (UUID.isEmpty())
			throw new IllegalArgumentException("UUID is Empty!");

		this.UUID = UUID;
	}

	// UUID
	public void SetUUID(String MC_UUID) {
		this.UUID = MC_UUID;
	}

	public void SetPlayTime(int PlayTime_SCD) {
		this.PlayTime = PlayTime_SCD;
	};

	public boolean Rigist() {
		INIT();
		try {
			this.ppst = con.prepareStatement("INSERT INTO userdata(UUID,Lifetime) VALUE (?,3000000);");
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

		if (this.PlayTime < 0) {
			throw new NullPointerException("Insert User PlayTime(Seconds)");
		}

		// 시간을 제고-> 시간을 빼고-> 저장한다.
		LeftTime = GetLeftTime();
		int TotalTime = LeftTime - PlayTime;

		INIT();
		try {
			this.ppst = con
					.prepareStatement("UPDATE userdata SET LogOutTime=CURRENT_TIMESTAMP, Lifetime=? WHERE UUID=?;");
			this.ppst.setInt(1, TotalTime);
			this.ppst.setString(2, this.UUID);
			this.ppst.executeUpdate();
			this.ppst.close();

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
			this.ppst = con.prepareStatement("SELECT Lifetime FROM userdata WHERE UUID=?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.Res = this.ppst.executeQuery();

			if (Res.next()) {
				Result = Res.getInt(1);
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
			// con = DriverManager.getConnection(SERVER_local, "root", "vonrk08217!");
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
