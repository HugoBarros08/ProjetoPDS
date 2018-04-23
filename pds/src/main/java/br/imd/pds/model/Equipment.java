package br.imd.pds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe responsável por moldar Equipamento
*/
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
	
	@Column(name="next_maintenance")
	private Date nextMaintenance;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="sector_id")
	private Sector sector;
	
//	@OneToMany(mappedBy = “equipment”, targetEntity = EquipmentCharacteristc.class)
	@Transient
	private ArrayList<EquipmentCharacteristic> characteristics;
	
//	@OneToMany(mappedBy = “equipment”, targetEntity = EquipmentHistoric.class)
	@Transient
	private ArrayList<EquipmentHistoric> historic;
	
	public static final String green = "green";
	public static final String orange = "orange";
	public static final String red = "red";
	
	public Equipment() {
	}
	
	public Equipment(String serial, String tumber, Date registration, Date lastMaintenance)
	{
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = registration;
		this.lastMaintenance = lastMaintenance;
		this.status = green;
		this.characteristics = new ArrayList<EquipmentCharacteristic>();
		this.historic = new ArrayList<EquipmentHistoric>();
		this.scheduling();
	}

	public Equipment(String serial, String tumber, Date product, Date lastMaintenance, ArrayList<EquipmentCharacteristic> characteristics, ArrayList<EquipmentHistoric> historic)
	{
		this.serialNumber = serial;
		this.tumberNumber = tumber;
		this.registrationDate = product;
		this.lastMaintenance = lastMaintenance;
		this.characteristics = characteristics;
		this.historic = historic;
		
		this.scheduling();
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(int id)
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
	
	public Date getNextMaintenance() {
		return nextMaintenance;
	}

	public void setNextMaintenance(Date nextMaintenance) {
		this.nextMaintenance = nextMaintenance;
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
	
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	/**
	 * Agenda a próxima manutenção do equipamento
	 * @param
	 * @return
	 */
	public void scheduling() {
		int year = Integer.parseInt(this.getTumberNumber().substring(0,3));
		Date lastMaintenance = this.getLastMaintenance();
		
		if(year >= 2008 && year <= 2010) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 2);
			this.setNextMaintenance(calendar.getTime());
		} else if(year == 2011 || year == 2012) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 4);
			this.setNextMaintenance(calendar.getTime());			
		} else if(year == 2013 || year == 2014) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 6);
			this.setNextMaintenance(calendar.getTime());			
		} else if(year == 2015 || year == 2016) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 8);
			this.setNextMaintenance(calendar.getTime());			
		} else if(year == 2017 || year == 2018) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 10);
			this.setNextMaintenance(calendar.getTime());			
		}
	}
	
	/**
	 * Agenda a próxima manutenção do equipamento
	 * @param numberOfMonths
	 * @return
	 */
	public void scheduling(int numberOfMonths) {
		Date lastMaintenance = this.getLastMaintenance();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lastMaintenance);
		calendar.add(Calendar.MONTH, numberOfMonths);
		this.setNextMaintenance(calendar.getTime());
	}
}
