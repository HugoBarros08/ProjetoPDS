import java.util.ArrayList;

import exceptions.InexistentCharacteristicException;
import exceptions.InexistentEquipmentException;

public class ManageEquipmentCharacteristic
{
	public void createEquipmentCharacteristic(ArrayList<Equipment> equipments, int equipmentId, int characteristicId, String characteristicName, String characteristicValue)
	throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				EquipmentCharacteristic characteristic = new EquipmentCharacteristic(characteristicId, characteristicName, characteristicValue);
				equipments.get(index).getCharacteristics().add(characteristic);
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
	{
		
	}
}
