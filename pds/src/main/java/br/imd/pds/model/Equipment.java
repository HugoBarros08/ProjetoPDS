package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="tumber_number")
	private String tumberNumber;
	
	@Column(name="registration_date")
	private Date registrationDate;
	
	@Column(name="last_maintenance")
	private Date lastMaintenance;
	
	@Column(name="status")
	private String status;
	
//	@OneToMany
	@Transient
	private ArrayList<EquipmentCharacteristic> characteristics;
	
//	@OneToMany
	@Transient
	private ArrayList<EquipmentHistoric> historic;
	
	public static final String green = "green";
	public static final String orange = "orange";
	public static final String red = "red";
	
	public Equipment() {
	}
	
	public Equipment(long id, String serial, String tumber, Date registration, Date lastMaintenance)
	{
		this.id = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = registration;
		this.lastMaintenance = lastMaintenance;
		this.status = green;
		
		this.characteristics = new ArrayList<EquipmentCharacteristic>();
		this.historic = new ArrayList<EquipmentHistoric>();
	}

	public Equipment(long id, String serial, String tumber, Date product, Date lastMaintenance, ArrayList<EquipmentCharacteristic> characteristics, ArrayList<EquipmentHistoric> historic)
	{
		this.id = id;
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = product;
		this.lastMaintenance = lastMaintenance;
		this.characteristics = characteristics;
		this.historic = historic;
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setEquipmentId(int id)
	{
		this.id = id;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setCharacteristics(ArrayList<EquipmentCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public void setHistoric(ArrayList<EquipmentHistoric> historic) {
		this.historic = historic;
	}
}
