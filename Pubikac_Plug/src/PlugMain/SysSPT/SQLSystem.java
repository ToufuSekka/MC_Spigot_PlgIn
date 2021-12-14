package PlugMain.SysSPT;

public class SQLSystem {

	public boolean Reserv_() {

		INIT();		
		try {
			this.ppst = this.con.prepareStatement(this.Query);
			
			switch(ReserveType){
			case Rigist:
				this.ppst=this.con.prepareStatement(this.Query);
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case SearchUser:
				this.ppst.setString(1, Data[0]);//UUID
				this.Res = this.ppst.executeQuery();
				Checker = this.Res.first();
				break;
			case Login:
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			case GameLeft:
				this.ppst.setString(1, Data[0]);//UUID
				this.ppst.executeUpdate();
				Checker = true;
				break;
			default:
				Checker = false;
				break;
			}
			
		}catch(SQLException SQLe) {
			SQLe.printStackTrace();
		}
		TheClose();
		return Checker;
	}
	
	public boolean ServerChecker(){
		INIT();
		try {
			if(con.isValid(60)) {
				//
			}
		}catch(SQLException SQLe) {
			//
		}
		TheClose();
		return false;
	}
			
	private void INIT() {
		try {
			this.con = DriverManager.getConnection(SERVER,"root",null);
			//this.con = DriverManager.getConnection(SERVER,"mcplayer","vonrk08217");
		}catch (SQLException SQLe) {
			SQLe.printStackTrace();
		}
	}
	
	private void TheClose() {
		try {
			if(!this.Res.isClosed())
				this.Res.close();
			if(!this.ppst.isClosed())
				this.ppst.close();
			if(!this.con.isClosed())
				this.con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
