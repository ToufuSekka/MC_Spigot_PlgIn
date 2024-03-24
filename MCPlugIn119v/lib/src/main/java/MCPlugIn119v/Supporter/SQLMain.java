package MCPlugIn119v.Supporter;

import java.sql.*;

/**
 * @since 2022-2-27
 * @author TouhuSekka
 */
public class SQLMain {
	// private static String SERVER_local =
	// "jdbc:mysql://wint0719.ipdisk.co.kr:3306/mctotalsys";
	
	// Getter And Setter
	private String SERVER;
	public void SetServerAdress(String Adress) {
		this.SERVER = Adress;
	}
	
	private String DBUser;
	public void SetUser(String DBUser) {
		this.DBUser = DBUser;
	}
	
	private String Password;
	public void SetPassword(String Password) {
		this.Password = Password;
	}
	
	// SQL
	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;

	// IN_Class
	private String UUID;
	public void SetUUID(String MC_UUID) {
		this.UUID = MC_UUID;
	}

	private int PlayTime, LeftTime;
	public void SetPlayTime(int PlayTime_SCD) {
		this.PlayTime = PlayTime_SCD;
	};
	
	public SQLMain(String Server, String UserID, String UserPW) {
		this.SERVER = Server;
		this.DBUser = UserID;
		this.Password = UserPW;
	}
	
	@Deprecated
	public boolean Rigist() {
		boolean checker = false;

		INIT();
		try {
			this.ppst = con.prepareStatement("INSERT INTO userdata(UUID,Lifetime) VALUE (?,3000000);");
			this.ppst.setString(1, this.UUID);// UUID
			int ErrorChker = this.ppst.executeUpdate();

			if (ErrorChker == 1)
				checker = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return checker;
	}

	/***
	 * That is Recording Signing time.
	 * 
	 * @return true - Has UUID and Recorded TimeStemps<br/>
	 *         false - Not having UUID
	 ***/
	public boolean Sign(boolean Listed) {
		boolean checker = false;
		String Query;

		if (Listed)
			Query = "UPDATE userdata SET LogInTime= CURRENT_TIMESTAMP WHERE UUID = ?;";
		else
			Query = "UPDATE userdata SET LogInTime= CURRENT_TIMESTAMP, Listed=3 WHERE UUID = ?;";

		INIT();
		try {
			this.ppst = con.prepareStatement(Query);
			this.ppst.setString(1, this.UUID);// UUID
			int ErrorChker = this.ppst.executeUpdate();

			if (ErrorChker == 2)
				checker = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return checker;
	}

	public boolean UserCheck() {
		boolean checker = false;
		INIT();
		try {
			this.ppst = con.prepareStatement("SELECT 'UUID' FROM userdata WHERE UUID=?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.Res = this.ppst.executeQuery();
			checker = Res.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll();
		return checker;
	}

	public RigistUser UserCheck2() {
		RigistUser Result = null;

		INIT();
		try {
			this.ppst = con.prepareStatement("SELECT Listed, UUID FROM userdata WHERE UUID=?;");
			this.ppst.setString(1, this.UUID);// UUID
			this.Res = this.ppst.executeQuery();

			if (Res.next())
				Result = RigistUser.values()[Res.getInt(1)];
			else
				Result = RigistUser.UnRigisted;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
	}

	public boolean GameLeave() {
		boolean checker = false;

		if (this.PlayTime < 0)
			throw new NullPointerException("Insert User PlayTime(Seconds)");

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
		return checker;
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
			con = DriverManager.getConnection(SERVER, DBUser, Password);
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
