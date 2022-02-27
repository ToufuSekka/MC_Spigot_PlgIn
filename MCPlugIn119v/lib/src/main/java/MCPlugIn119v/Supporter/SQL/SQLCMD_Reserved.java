package MCPlugIn119v.Supporter.SQL;

public enum SQLCMD_Reserved {
	Rigist("INSERT INTO userdata(UUID) VALUE (?);"),
	SearchUser("SELECT 'UUID' FROM userdata WHERE UUID=?;"),
	Login("UPDATE userdata SET LogInTime= CURRENT_TIMESTAMP WHERE UUID = ?;"),
	GameLeft("UPDATE userdata SET LogOutTime= CURRENT_TIMESTAMP WHERE UUID = ?;");
	
	private final String Type;
	
	SQLCMD_Reserved(String Type){
		this.Type = Type;
	};
	
	public String GetQuery() {
		return this.Type;
	}
}
