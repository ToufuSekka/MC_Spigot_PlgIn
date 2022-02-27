package MCPlugIn119v.Supporter.SQL;

import java.sql.*;

/**
 * 데이터베이스 관련 보조 시스탬
 * @since 2022-2-27
 * @author TouhuSekka
 */
public class SQLMain {
	// private static String SERVER_local= "jdbc:mysql://localhost:3306/mctotalsys";
	private static String SERVER = "jdbc:mysql://wint0719.codns.com:3306/mctotalsys?allowPublicKeyRetrieval=true&useSSL=false";

	private Connection con;
	private PreparedStatement ppst;
	private ResultSet Res;

	private String Query;

	/**
	 * 이미 지정된 것에 관한 시스탬
	 * @param Type Rigist, Login, SearchUser, GameLeft중 하나의 선택
	 * @param Datas 상세 데이터
	 * @return 성공하면 true, 아니면 false
	 */
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
				this.ppst.setString(1, Datas[0]);// UUID
				this.ppst.executeUpdate();
				Checker = true;
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
