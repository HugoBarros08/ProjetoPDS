package br.imd.pds.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Classe responsável por moldar Setores
*/
@Entity
public class Sector {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="name")
	private String name;
	
//	@OneToMany(mappedBy = “sector”, targetEntity = Equipment.class)
	@Transient
	private ArrayList<Equipment> equipments;
	
//	@OneToMany(mappedBy = “sector”, targetEntity = User.class)
	@Transient
	private ArrayList<User> leaders;
	
	public Sector() {
		
	}
	
	public Sector(String name, ArrayList<Equipment> equipments, ArrayList<User> leaders)
	{
		this.name = name;
		this.equipments = equipments;
		this.leaders = leaders;
	}
	
	public Sector(long id, String name)
	{
		this.id = id;
		this.name = name;
		this.equipments = new ArrayList<Equipment>();
		this.leaders = new ArrayList<User>();
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
		return equipments;
	}
	
	public void setEquipments(ArrayList<Equipment> equipment) {
		this.equipments = equipment;
	}

	public ArrayList<User> getLeader() {
		return leaders;
	}

	public void setLeaders(ArrayList<User> leaders) {
		this.leaders = leaders;
	}
}
