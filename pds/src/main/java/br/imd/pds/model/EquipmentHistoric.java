package br.imd.pds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe responsável por moldar Histórico de Equipamento
*/
@Entity
public class EquipmentHistoric {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="log")
	private String log;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="equipment_id")
	Equipment equipment;

	public EquipmentHistoric() {
	}
	
	public EquipmentHistoric(String log, Date date)
	{
		this.log = log;
		this.date = date;
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getLog()
	{
		return this.log;
	}
	
	public void setLog(String log)
	{
		this.log = log;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
}
