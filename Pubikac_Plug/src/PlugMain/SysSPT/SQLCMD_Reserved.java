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
	
	
	/**
	 * ������ִ� ���� ������ ����´�. ��� �����Ϳ� UUID�� �ʼ���.<br/>
	 * Rigist -> �ű� ������ �����.<br/>
	 * SearchUser -> ������ �����ϴ��� �˻���.<br/>
	 * LoginDate -> �α��� �Ͻø� �����. ���� �ð��� �߰��� �ʿ��� .<br/>
	 * GameLeft -> ���� �Ͻø� �����. ���� �ð��� �߰��� �ʿ���.
	
	 * @return ����¥�� ������ ���ڿ��� ��ȯ��.
	 */
	public String GetQuery() {
		return this.Type;
	}
}
