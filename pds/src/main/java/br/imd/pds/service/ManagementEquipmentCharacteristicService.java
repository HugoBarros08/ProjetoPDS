package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.EquipmentCharacteristic;
import br.imd.pds.repository.EquipmentCharacteristicRepository;

/**
 * Classe responsável por gerenciar as Características dos Equipamentos
 */
@Service
public class ManagementEquipmentCharacteristicService {
	
	@Autowired
	private EquipmentCharacteristicRepository repository;
	
	public ManagementEquipmentCharacteristicService(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
	}
	
	public EquipmentCharacteristicRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentCharacteristicRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Insere características de um equipamento no repositório.
	 */
	public void insertEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic) throws ExistentObjectException {
		if (equipmentCharacteristic != null && !equipmentCharacteristic.getName().isEmpty()) {
			if (repository.findByName(equipmentCharacteristic.getName()) == null) {
				repository.save(equipmentCharacteristic);
			} else {
				throw new ExistentObjectException("Já existe uma característica resgistrada com esse nome.");
			}
		}
	}
	
	/**
	 * Remove características de um equipamento do repositório.
	 */
	public void removeEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic) throws InexistentObjectException {
		if (equipmentCharacteristic != null && !equipmentCharacteristic.getName().isEmpty()) {
			EquipmentCharacteristic toBeDeleted = searchEquipmentCharacteristic(equipmentCharacteristic.getName());
			repository.delete(toBeDeleted);
		}
	}
	
	/**
	 * Atualiza características de um equipamento do repositório.
	 */
	public void updateEquipmentCharacteristic(EquipmentCharacteristic equipmentCharacteristic, String name) throws InexistentObjectException {
		EquipmentCharacteristic foundEquipmentCharacteristic = searchEquipmentCharacteristic(name);
		foundEquipmentCharacteristic.setName(equipmentCharacteristic.getName());
	}
	
	/**
	 * Busca características de um equipamento no repositório.
	 */
	public EquipmentCharacteristic searchEquipmentCharacteristic(String name) throws InexistentObjectException {
		EquipmentCharacteristic foundEquipmentCharacteristic = repository.findByName(name);
		if(foundEquipmentCharacteristic!=null) {
			return foundEquipmentCharacteristic;
		} else {
			throw new InexistentObjectException("Característica não encontrada.");
		}
	}
}