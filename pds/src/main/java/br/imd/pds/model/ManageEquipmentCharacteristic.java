package br.imd.pds.model;

import java.util.ArrayList;

import br.imd.pds.exceptions.ExistentEquipmentCharacteristicException;
import br.imd.pds.exceptions.InexistentCharacteristicException;
import br.imd.pds.exceptions.InexistentEquipmentException;

public class ManageEquipmentCharacteristic
{
	public void createEquipmentCharacteristic(ArrayList<Equipment> equipments, int equipmentId, int characteristicId, String characteristicName, String characteristicValue)
	throws InexistentEquipmentException, ExistentEquipmentCharacteristicException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				ArrayList<EquipmentCharacteristic> characteristics = equipments.get(index).getCharacteristics();
				
				for(int characIndex = 0; characIndex < characteristics.size(); characIndex++)
				{
					if(characteristics.get(characIndex).getCharacteristicId() == characteristicId)
					{
						throw new ExistentEquipmentCharacteristicException("Já existe uma característica registrada com esse id");
					}
				}
				
				EquipmentCharacteristic characteristic = new EquipmentCharacteristic(characteristicId, characteristicName, characteristicValue);
				characteristics.add(characteristic);
				return;
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
		
	}
	
	public void removeEquipmentCharacteristic(ArrayList<Equipment> equipments, int equipmentId, int characteristicId)
	throws InexistentEquipmentException, InexistentCharacteristicException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				ArrayList<EquipmentCharacteristic> characteristics = equipments.get(index).getCharacteristics();
				
				for(int characIndex = 0; characIndex < characteristics.size(); characIndex++)
				{
					if(characteristics.get(characIndex).getCharacteristicId() == characteristicId)
					{
						characteristics.remove(characIndex);
						return;
					}
				}
				
				throw new InexistentCharacteristicException("Característica inexistente");
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	public void updateEquipmentCharacteristic(ArrayList<Equipment> equipments, int equipmentId, int characteristicId, String newCharacName, String newCharacValue)
	throws InexistentCharacteristicException, InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				ArrayList<EquipmentCharacteristic> characteristics = equipments.get(index).getCharacteristics();
				
				for(int characIndex = 0; characIndex < characteristics.size(); characIndex++)
				{
					if(characteristics.get(characIndex).getCharacteristicId() == characteristicId)
					{
						characteristics.get(characIndex).setName(newCharacName);
						characteristics.get(characIndex).setValue(newCharacValue);
						return;
					}
				}
				
				throw new InexistentCharacteristicException("Característica inexistente");
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	public EquipmentCharacteristic searchEquipmentCharacteristic(ArrayList<Equipment> equipments, int equipmentId, int characteristicId)
	throws InexistentCharacteristicException, InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				ArrayList<EquipmentCharacteristic> characteristics = equipments.get(index).getCharacteristics();
				
				for(int characIndex = 0; characIndex < characteristics.size(); characIndex++)
				{
					if(characteristics.get(characIndex).getCharacteristicId() == characteristicId)
					{
						return characteristics.get(characIndex);
					}
				}
				
				throw new InexistentCharacteristicException("Característica inexistente");
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
}
