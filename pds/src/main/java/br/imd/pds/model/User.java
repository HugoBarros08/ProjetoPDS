package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@Column(name="flag_user")
	private boolean flag;

	public User() {
	}
	
	public User(String cpf, String name, String email)
	{
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.flag = true;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
