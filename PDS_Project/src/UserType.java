
public class UserType {
	private int admin;
	private int user;
	
	public UserType(int admin, int user) {
		this.admin = admin;
		this.user = user;
	}
	
	public void setAdmin(int admin){
		this.admin = admin;
	}

	public int getAdmin(){
		return admin;
	}
	
	public void setUser(int user){
		this.user = user;
	}

	public int getUser(){
		return user;
	}

}