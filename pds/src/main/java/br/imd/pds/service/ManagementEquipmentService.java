package br.imd.pds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Equipment;
import br.imd.pds.repository.EquipmentRepository;

@Service
public class ManagementEquipmentService {
	
	@Autowired
	private EquipmentRepository repository;
	
	public List<Equipment> listEquipment() {
		return repository.findAll();
	}
	
	public ManagementEquipmentService(EquipmentRepository repository) {
		this.repository = repository;
	}
	
	public EquipmentRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentRepository repository) {
		this.repository = repository;
	}
		
	public void insertEquipment(Equipment equipment) throws ExistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty()) {
			if (repository.findBySerialNumber(equipment.getSerialNumber()) == null) {
				repository.save(equipment);
			} else {
				throw new ExistentObjectException("Já existe um equipamento registrado com esse número de serial.");
			}
		}
	}
	
	public void deleteEquipment(Equipment equipment) throws InexistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty()) {
			Equipment toBeDeleted = this.searchEquipmentBySerialNumber(equipment.getSerialNumber());
			repository.delete(toBeDeleted);
		}
	}
	
	public void updateEquipment(Equipment equipment, String serialNumber) throws InexistentObjectException {
		Equipment foundEquipment = searchEquipmentBySerialNumber(serialNumber);
		foundEquipment.setSerialNumber(equipment.getSerialNumber());
		foundEquipment.setTumberNumber(equipment.getTumberNumber());
		foundEquipment.setRegistrationDate(equipment.getRegistrationDate());
		foundEquipment.setLastMaintenance(equipment.getLastMaintenance());
		
	}
	
	public Equipment searchEquipmentByTumberNumber(String tumberNumber) throws InexistentObjectException {
		Equipment foundEquipment = repository.findByTumberNumber(tumberNumber);
		if(foundEquipment!=null) {
			return foundEquipment;
		} else {
			throw new InexistentObjectException("Equipamento não encontrado.");
		}
	}
	
	public Equipment searchEquipmentBySerialNumber(String serialNumber) throws InexistentObjectException {
		Equipment foundEquipment = repository.findBySerialNumber(serialNumber);
		if(foundEquipment!=null) {
			return foundEquipment;
		} else {
			throw new InexistentObjectException("Equipamento não encontrado.");
		}
	}	
}
