
public class User {
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private UserType role;

	public User(int id, String name, String email, String username, String password, UserType role){
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return name;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setRole(UserType role){
		this.role = role;
	}

	public UserType role(){
		return role;
	}

}
