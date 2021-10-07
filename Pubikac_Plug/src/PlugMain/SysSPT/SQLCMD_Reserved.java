package PlugMain.SysSPT;

@SuppressWarnings("nls")
public enum SQLCMD_Reserved {
	Rigist("INSERT INTO userdata(UUID, LeftLifeTime) VALUE (?,?);"),
	SearchUser("SELECT 'UUID' FROM userdata WHERE UUID=?;"),
	TimeLimiter("SELECT LeftLifeTime FROM userdata WHERE UUID=?;"),
	LoginDate("UPDATE userdata SET LastLogInTime = ? WHERE UUID=?;"),
	TimeCulcurater("UPDATE userdata SET LeftLifeTime = LeftLifeTime - ?, WHERE UUID=?;");
	
	private final String Type;
	SQLCMD_Reserved(String Type){
		this.Type = Type;
	};
	
	public String GetQuery() {
		return this.Type;
	}
}
