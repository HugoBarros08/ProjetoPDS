
public class User
{
	private String registration;
	private String name;
	private String email;

	public User(String registration, String name, String email)
	{
		this.registration = registration;
		this.name = name;
		this.email = email;
	}
	
	public void setRegistration(String registration)
	{
		this.registration = registration;
	}

	public String getRegistration()
	{
		return registration;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

}
