package MCPlugIn119v.Supporter;

public enum RigistUser {
	UnRigisted(0), Blocked(1), UnListed(2), Rigisted(3);
	
	private int Nums;
	
	 RigistUser(int Values) {
		 this.Nums = Values;
	}
	 
	 public int getValues() {
		 return Nums;
	 }
}
