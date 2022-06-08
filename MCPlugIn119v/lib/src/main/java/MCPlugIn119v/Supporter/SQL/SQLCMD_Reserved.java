package MCPlugIn119v.Supporter.SQL;

public enum SQLCMD_Reserved {
	Rigist, SearchUser, Login, GameLeft("UPDATE userdata SET LogOutTime= CURRENT_TIMESTAMP WHERE UUID = ?;"),
	GameLeft_New("UPDATE userdata SET (LogOutTime,Lifetime)= (CURRENT_TIMESTAMP,?) WHERE UUID = ?;"),
	TimeLimit("SELECT 'Lifetime' FROM userdata WHERE UUID=?;");
}