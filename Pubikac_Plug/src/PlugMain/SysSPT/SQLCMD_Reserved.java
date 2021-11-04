package PlugMain.SysSPT;

public enum SQLCMD_Reserved {
	Rigist("INSERT INTO userdata(UUID) VALUE (?);"),
	SearchUser("SELECT 'UUID' FROM userdata WHERE UUID=?;"),
	LoginDate("UPDATE userdata SET LastLogInTime = ? WHERE UUID=?;"),
	GameLeft("UPDATE userdata SET LeftTime = ? WHERE UUID=?;");
	
	private final String Type;
	
	SQLCMD_Reserved(String Type){
		this.Type = Type;
	};
	
	public String GetQuery() {
		return this.Type;
	}
}
