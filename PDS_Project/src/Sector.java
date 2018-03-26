import java.util.ArrayList;

public class Sector {
	private String name;
	private ArrayList<Equipment> equipment;
	private ArrayList<User> leader;
	
	public Sector(String name, ArrayList<Equipment> equipment, ArrayList<User> leader) {
		this.name = name;
		this.equipment = equipment;
		this.leader = leader;
	}
	
	public Sector(String name) {
		this.name = name;
		this.equipment = new ArrayList<Equipment>();
		this.leader = new ArrayList<User>();
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
