package br.imd.pds.model;

import br.imd.pds.helpers.*;
import br.imd.pds.repository.IEquipmentCharacteristicRepository;


public class ManagementEquipmentCharacteristic {
	
	private IEquipmentCharacteristicRepository equipCharacRepository;
	
	public ManagementEquipmentCharacteristic(IEquipmentCharacteristicRepository equipCharacRepository) {
		this.equipCharacRepository = equipCharacRepository;
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
