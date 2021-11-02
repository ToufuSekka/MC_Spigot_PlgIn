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
	 * 내장되있는 쿼리 내용을 끌어온다. 모든 데이터에 UUID는 필수다.<br/>
	 * Rigist -> 신규 유저를 등록함.<br/>
	 * SearchUser -> 유저가 존재하는지 검색함.<br/>
	 * LoginDate -> 로그인 일시를 기록함. 들어온 시간이 추가로 필요함 .<br/>
	 * GameLeft -> 떠난 일시를 기록함. 떠난 시간이 추가로 필요함.
	
	 * @return 한줄짜리 쿼리가 문자열로 변환됨.
	 */
	public String GetQuery() {
		return this.Type;
	}
}
