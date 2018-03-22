import java.util.ArrayList;
import java.util.Date;

public class Equipments {
	
	private int equipmentId;
	private String serialNumber;
	private String tumberNumber;
	private Date productDate;
	private Date lastMaintenance;
	private ArrayList<EquipmentCharacteristic> characteristics;
	private ArrayList<EquipmentHistoric> historic;
	
	public Equipments(int id, String serial, String tumber, Date product, Date lastMaintenance)
	{
		this.equipmentId = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.productDate = product;
		this.lastMaintenance = lastMaintenance;
		
		this.characteristics = new ArrayList<EquipmentCharacteristic>();
		this.historic = new ArrayList<EquipmentHistoric>();
	}

	public Equipments(int id, String serial, String tumber, Date product, Date lastMaintenance, ArrayList<EquipmentCharacteristic> characteristics, ArrayList<EquipmentHistoric> historic)
	{
		this.equipmentId = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.productDate = product;
		this.lastMaintenance = lastMaintenance;
		this.characteristics = characteristics;
		this.historic = historic;
	}
	
	public int getEquipmentId()
	{
		return this.equipmentId;
	}
	
	public void setEquipmentId(int id)
	{
		this.equipmentId = id;
	}
	
	public String getSerialNumber()
	{
		return this.serialNumber;
	}
	
	public void setSerialNumber(String number)
	{
		this.serialNumber = number;
	}
	
	public String getTumberNumber()
	{
		return this.tumberNumber;
	}
	
	public void setTumberNumber(String number)
	{
		this.tumberNumber = number;
	}
	
	public ArrayList<EquipmentCharacteristic> getCharacteristics()
	{
		return this.characteristics;
	}
	
	public ArrayList<EquipmentHistoric> getHistoric()
	{
		return this.historic;
	}
}
