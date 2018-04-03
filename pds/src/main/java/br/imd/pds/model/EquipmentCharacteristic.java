package br.imd.pds.model;

public class EquipmentCharacteristic
{
	private int characteristicId;
	private String name;
	private String value;
	
	public EquipmentCharacteristic(int id, String name, String value)
	{
		this.characteristicId = id;
		this.name = name;
		this.value = value;
	}
	
	public int getCharacteristicId()
	{
		return this.characteristicId;
	}
	
	public void setCharacteristicId(int id)
	{
		this.characteristicId = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
}
