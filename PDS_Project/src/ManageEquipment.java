import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import exceptions.ExistentEquipmentException;
import exceptions.InexistentEquipmentException;

public class ManageEquipment
{	
	public void createEquipment(ArrayList<Equipment> equipments, int id, String serial, String tumber) throws ExistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(serial))
			{
				throw new ExistentEquipmentException("Já existe uma máquina registrada com esse número de série");
			}
		}
		
		Date registrationAndLastMaintenance = Calendar.getInstance().getTime();
		
		Equipment newEquipment = new Equipment(id, serial, tumber, registrationAndLastMaintenance, registrationAndLastMaintenance);
		
		equipments.add(newEquipment);
	}
	
	public void deleteEquipment(ArrayList<Equipment> equipments, String serial) throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(serial))
			{
				equipments.remove(index);
				return;
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	public void updateEquipment(ArrayList<Equipment> equipments, String serial, int newId, String newSerial, String newTumber, Date newRegistrationDate, Date newLastMaintenance, String newStatus)
	throws InexistentEquipmentException, ExistentEquipmentException
	{
		Equipment foundOne = null;
		
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == newId)
			{
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo id");	
			
			} else if(equipments.get(index).getSerialNumber().equalsIgnoreCase(newSerial)){
				
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo serial");
			
			} else if(equipments.get(index).getTumberNumber().equalsIgnoreCase(newTumber)){
				
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo tombo");
			
			} else if(equipments.get(index).getSerialNumber().equalsIgnoreCase(serial)){
				
				foundOne = equipments.get(index);
			}
			
		}
		
		if(foundOne != null)
		{
			foundOne.setEquipmentId(newId);
			foundOne.setSerialNumber(newSerial);
			foundOne.setTumberNumber(newTumber);
			foundOne.setRegistrationDate(newRegistrationDate);
			foundOne.setLastMaintenance(newLastMaintenance);
			foundOne.setStatus(newStatus);
			
		} else {
			
			throw new InexistentEquipmentException("Equipamento inexistente");
		}
	}
	
	public Equipment searchEquipment(ArrayList<Equipment> equipments, String serial) throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(serial))
			{
				return equipments.get(index);
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	
}
