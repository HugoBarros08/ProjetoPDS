package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="registration")
	private String registration;
	
	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;
	
	public User() {
		
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", registration=" + registration + ", name=" + name + ", email=" + email + "]";
	}

}
