package br.imd.pds.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sector
{
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany
	private ArrayList<Equipment> equipment;
	
	@OneToMany
	private ArrayList<User> leader;
	
	public Sector(long id, String name, ArrayList<Equipment> equipment, ArrayList<User> leader)
	{
		this.id = id;
		this.name = name;
		this.equipment = equipment;
		this.leader = leader;
	}
	
	public Sector(long id, String name)
	{
		this.id = id;
		this.name = name;
		this.equipment = new ArrayList<Equipment>();
		this.leader = new ArrayList<User>();
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public ArrayList<Equipment> getEquipments(){
		return equipment;
	}
		

	public void notfy() 
	{
		
	}
}
