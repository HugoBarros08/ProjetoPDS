import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import exceptions.ExistentEquipmentCharacteristicException;
import exceptions.ExistentEquipmentException;
import exceptions.InexistentEquipmentException;

public class ManageEquipment
{	
	public void createEquipment(ArrayList<Equipment> equipments, int id, String serial, String tumber) throws ExistentEquipmentException
	{
		for(int index = 0; index < equipments.size(); index++)
		{
			if(equipments.get(index).getTumberNumber().equalsIgnoreCase(tumber))
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
			if(equipments.get(index).getSerialNumber().equalsIgnoreCase(newSerial) && equipments.get(index).getEquipmentId() != id){
				
				throw new ExistentEquipmentException("Já existe um equipamento registrado com o novo serial");
			
			} else if(equipments.get(index).getTumberNumber().equalsIgnoreCase(newTumber) && equipments.get(index).getEquipmentId() != id){
				
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
	
	public void printEquipments(ArrayList<Equipment> equipments)
	{
		if(!equipments.isEmpty())
		{
			System.out.println("===============================================================");
			
			for(int j = 0; j < equipments.size(); j++)
			{
				System.out.println("Equipamento " + equipments.get(j).getEquipmentId() + ":");
				System.out.println("Número serial: " + equipments.get(j).getSerialNumber());
				System.out.println("Número de tombo:  " + equipments.get(j).getTumberNumber());
				System.out.println("Data de registro: " + equipments.get(j).getRegistrationDate());
				System.out.println("Data da última manutenção: " + equipments.get(j).getLastMaintenance());
				System.out.println("Status: " + equipments.get(j).getStatus());
				
				if(!equipments.get(j).getCharacteristics().isEmpty())
				{
					System.out.println("Características:");
					System.out.println("ID    | Nome    | Quantidade");
					for(int i = 0; i < equipments.get(j).getCharacteristics().size(); i++)
					{
						System.out.print(equipments.get(j).getCharacteristics().get(i).getCharacteristicId() + " | ");
						System.out.print(equipments.get(j).getCharacteristics().get(i).getName() + " | ");
						System.out.println(equipments.get(j).getCharacteristics().get(i).getValue());
					}		
				}
				
				System.out.println("");
			}
			
			System.out.println("===============================================================");
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Equipment> equipments = new ArrayList<Equipment>();
	
		ManageEquipment managerEquip = new ManageEquipment();
		ManageEquipmentCharacteristic managerCharac = new ManageEquipmentCharacteristic();
		
		try
		{
			managerEquip.createEquipment(equipments, 501, "BRT852RFTQ", "2012005412");
			managerEquip.createEquipment(equipments, 502, "BRT852RFTF", "2012005415");
			managerEquip.createEquipment(equipments, 503, "BRT852RFTB", "2012005413");
			managerEquip.createEquipment(equipments, 504, "BRT852RFTY", "2012005417");
			managerEquip.createEquipment(equipments, 505, "BRT852RFTU", "2012005420");
		
		} catch(ExistentEquipmentException e){
			
			System.out.println(e.getMessage());
		}
		
		try
		{
			managerCharac.createEquipmentCharacteristic(equipments, 502, 50201, "Monitor", "2");
			managerCharac.createEquipmentCharacteristic(equipments, 502, 50202, "Teclado", "1");
			managerCharac.createEquipmentCharacteristic(equipments, 502, 50203, "Mouse  ", "1");
			
			managerCharac.createEquipmentCharacteristic(equipments, 503, 50401, "Monitor", "1");
			managerCharac.createEquipmentCharacteristic(equipments, 503, 50402, "Teclado", "1");
			managerCharac.createEquipmentCharacteristic(equipments, 503, 50403, "Mouse  ", "1");
			
			managerCharac.createEquipmentCharacteristic(equipments, 504, 50401, "Monitor", "1");
			managerCharac.createEquipmentCharacteristic(equipments, 504, 50402, "Teclado", "1");
			managerCharac.createEquipmentCharacteristic(equipments, 504, 50403, "Mouse  ", "1");
			
		} catch(ExistentEquipmentCharacteristicException e){
			
			System.out.println(e.getMessage());
		
		} catch(InexistentEquipmentException e){
			
			System.out.println(e.getMessage());
		}
		
		managerEquip.printEquipments(equipments); //Listagem dos equipamentos registrados
	
		System.out.println("\n" + "Serão deletados os equipamentos 503 e 504" + "\n");
		
		try
		{
			managerEquip.deleteEquipment(equipments, 503);
			managerEquip.deleteEquipment(equipments, 504);
			
		} catch(InexistentEquipmentException e){
			
			System.out.println(e.getMessage());
		}
		
		managerEquip.printEquipments(equipments); //Listagem dos equipamentos registrados
	}
}
