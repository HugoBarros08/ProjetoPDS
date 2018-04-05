package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="registration")
	private String registration;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	public Administrator(String registration, String name, String username, String password, String email)
	{
		this.registration = registration;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getRegistration()
	{
		return this.registration;
	}
	
	public void set(String registration)
	{
		this.registration = registration;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
}
