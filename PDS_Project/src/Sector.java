import java.util.ArrayList;

public class Sector {
	private String name;
	private ArrayList<Equipments> equipments;
	private ArrayList<User> leader;
	
	public Sector(String name, ArrayList<Equipments> equipments, ArrayList<User> leader) {
		this.name = name;
		this.equipments = equipments;
		this.leader = leader;
	}
	
	public Sector(String name) {
		this.name = name;
		this.equipments = new ArrayList<Equipments>();
		this.leader = new ArrayList<User>();
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public ArrayList<Equipments> getEquipments(){
		return equipments;
	}
		
}
