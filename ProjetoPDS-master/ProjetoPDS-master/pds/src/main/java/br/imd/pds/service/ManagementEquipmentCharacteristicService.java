package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.EquipmentCharacteristic;
import br.imd.pds.repository.EquipmentCharacteristicRepository;

@Service
public class ManagementEquipmentCharacteristicService {
	
	@Autowired
	private EquipmentCharacteristicRepository repository;
	
	public ManagementEquipmentCharacteristicService(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
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

	public EquipmentCharacteristicRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
	}
}
