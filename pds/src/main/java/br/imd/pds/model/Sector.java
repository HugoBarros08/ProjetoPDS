package br.imd.pds.model;

import java.util.ArrayList;

public class Sector
{
	private int sectorId;
	private String name;
	private ArrayList<Equipment> equipment;
	private ArrayList<User> leader;
	
	public Sector(int id, String name, ArrayList<Equipment> equipment, ArrayList<User> leader)
	{
		this.sectorId = id;
		this.name = name;
		this.equipment = equipment;
		this.leader = leader;
	}
	
	public Sector(int id, String name)
	{
		this.sectorId = id;
		this.name = name;
		this.equipment = new ArrayList<Equipment>();
		this.leader = new ArrayList<User>();
	}
	
	public int getSectorId()
	{
		return this.sectorId;
	}
	
	public void setSectorId(int id)
	{
		this.sectorId = id;
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
