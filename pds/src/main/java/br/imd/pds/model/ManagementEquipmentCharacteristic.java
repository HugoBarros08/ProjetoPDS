package br.imd.pds.model;

import br.imd.pds.DAO.IEquipmentCharacteristicRepository;
import br.imd.pds.exceptions.*;


public class ManagementEquipmentCharacteristic {
	
	private IEquipmentCharacteristicRepository equipCharacRepository;
	
	public ManagementEquipmentCharacteristic(IEquipmentCharacteristicRepository i) {
		equipCharacRepository = i;
	}
	
	public void createEquipmentCharacteristic(EquipmentCharacteristic equipmentCharac) throws InexistentObjectException, ExistentObjectException {

		
	}
	
	public void removeEquipmentCharacteristic(int id) throws InexistentObjectException {

	}
	
	public void updateEquipmentCharacteristic(int id) throws InexistentObjectException {

	}
	
	public EquipmentCharacteristic searchEquipmentCharacteristic() throws InexistentObjectException {
		
		EquipmentCharacteristic eqCharac = null;
		return eqCharac;
	}
}
