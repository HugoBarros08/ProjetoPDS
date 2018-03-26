import java.util.ArrayList;
import java.util.Date;

public class Equipment {
	
	private int equipmentId;
	private String serialNumber;
	private String tumberNumber;
	private Date registrationDate;
	private Date lastMaintenance;
	private String status;
	private ArrayList<EquipmentCharacteristic> characteristics;
	private ArrayList<EquipmentHistoric> historic;
	
	public static final String green = "green";
	public static final String orange = "orange";
	public static final String red = "red";
	
	public Equipment(int id, String serial, String tumber, Date registration, Date lastMaintenance)
	{
		this.equipmentId = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = registration;
		this.lastMaintenance = lastMaintenance;
		this.status = green;
		
		this.characteristics = new ArrayList<EquipmentCharacteristic>();
		this.historic = new ArrayList<EquipmentHistoric>();
	}

	public Equipment(int id, String serial, String tumber, Date product, Date lastMaintenance, ArrayList<EquipmentCharacteristic> characteristics, ArrayList<EquipmentHistoric> historic)
	{
		this.equipmentId = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = product;
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
	
	public Date getRegistrationDate()
	{
		return this.registrationDate;
	}
	
	public void setRegistrationDate(Date registration)
	{
		this.registrationDate = registration;
	}
	
	public Date getLastMaintenance()
	{
		return this.lastMaintenance;
	}
	
	public void setLastMaintenance(Date lastMaintenance)
	{
		this.lastMaintenance = lastMaintenance;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
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
