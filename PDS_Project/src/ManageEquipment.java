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
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(tumber))
			{
				throw new ExistentEquipmentException("Já existe uma máquina registrada com esse número de tombo");
			}
		}
		
		Date registrationAndLastMaintenance = Calendar.getInstance().getTime();
		
		Equipment newEquipment = new Equipment(id, serial, tumber, registrationAndLastMaintenance, registrationAndLastMaintenance);
		
		equipments.add(newEquipment);
	}
	
	public void deleteEquipment(ArrayList<Equipment> equipments, int id) throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == id)
			{
				equipments.remove(index);
				return;
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	public void updateEquipment(ArrayList<Equipment> equipments, int id, String newSerial, String newTumber, Date newRegistrationDate, Date newLastMaintenance, String newStatus)
	throws InexistentEquipmentException, ExistentEquipmentException
	{
		Equipment foundOne = null;
		
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(newSerial)){
				
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo serial");
			
			} else if(equipments.get(index).getTumberNumber().equalsIgnoreCase(newTumber)){
				
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo tombo");
			
			} else if(equipments.get(index).getEquipmentId() == id){
				
				foundOne = equipments.get(index);
			}
			
		}
		
		if(foundOne != null)
		{
			foundOne.setSerialNumber(newSerial);
			foundOne.setTumberNumber(newTumber);
			foundOne.setRegistrationDate(newRegistrationDate);
			foundOne.setLastMaintenance(newLastMaintenance);
			foundOne.setStatus(newStatus);
			
		} else {
			
			throw new InexistentEquipmentException("Equipamento inexistente");
		}
	}
	
	public Equipment searchEquipment(ArrayList<Equipment> equipments, int id) throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == id)
			{
				return equipments.get(index);
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}
	
	public void createEquipmentHistoric(ArrayList<Equipment> equipments, int equipmentId, int historicId, String historicLog, Date historicDate)
	throws InexistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getEquipmentId() == equipmentId)
			{
				EquipmentHistoric maintenanceHistoric = new EquipmentHistoric(historicId, historicLog, historicDate);
				equipments.get(index).getHistoric().add(maintenanceHistoric);
			}
		}
		
		throw new InexistentEquipmentException("Equipamento inexistente");
	}	
}
