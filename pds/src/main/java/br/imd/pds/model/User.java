package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;

	public User(String cpf, String name, String email)
	{
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getCpf()
	{
		return cpf;
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
		return "User [id=" + id + ", cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}

}
