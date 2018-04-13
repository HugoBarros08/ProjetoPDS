package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.EquipmentCharacteristic;
import br.imd.pds.model.Sector;
import br.imd.pds.repository.EquipmentCharacteristicRepository;

@Service
public class ManagementEquipmentCharacteristicService {
	
	@Autowired
	private EquipmentCharacteristicRepository repository;
	
	public ManagementEquipmentCharacteristicService(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
	}
	
	public void insertEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic) throws ExistentObjectException {
		if (equipmentCharacteristic != null && !equipmentCharacteristic.getName().isEmpty()) {
			if (repository.findByName(equipmentCharacteristic.getName()) == null) {
				repository.save(equipmentCharacteristic);
			} else {
				throw new ExistentObjectException("Já existe uma característica resgistrada com esse nome.");
			}
		}
	}
	
	public void removeEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic) throws InexistentObjectException {
		if (equipmentCharacteristic != null && !equipmentCharacteristic.getName().isEmpty()) {
			EquipmentCharacteristic toBeDeleted = repository.findByName(equipmentCharacteristic.getName());
			if (toBeDeleted != null) {
				repository.delete(toBeDeleted);
			} else {
				throw new InexistentObjectException("Característica não encontrada.");
			}
		}
	}
	
	public void updateEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic, String name) throws InexistentObjectException {
		EquipmentCharacteristic equipmentCharacteristicFound = searchEquipmentCharacteristic(name);
		equipmentCharacteristicFound.setName(equipmentCharacteristic.getName());
	}
	
	public EquipmentCharacteristic searchEquipmentCharacteristic(String name) throws InexistentObjectException {
		EquipmentCharacteristic equipmentCharacteristicFound = repository.findByName(name);
		if(equipmentCharacteristicFound!=null) {
			return equipmentCharacteristicFound;
		} else {
			throw new InexistentObjectException("Característica não encontrada.");
		}
	}

	public EquipmentCharacteristicRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
	}
}
