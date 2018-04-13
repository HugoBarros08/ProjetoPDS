package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Equipment;
import br.imd.pds.repository.EquipmentRepository;

@Service
public class ManagementEquipmentService {
	
	@Autowired
	private EquipmentRepository repository;
	
	public ManagementEquipmentService(EquipmentRepository repository) {
		this.repository = repository;
	}
		
	public void insertEquipment(Equipment equipment) throws ExistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty() && !equipment.getTumberNumber().isEmpty()) {
			if (repository.findByTumberNumber(equipment.getTumberNumber()) == null && repository.findBySerialNumber(equipment.getSerialNumber()) == null) {
				repository.save(equipment);
			} else {
				throw new ExistentObjectException("Já existe um equipamento registrado com o mesmo número de serial e/ou tombo.");
			}
		}
	}
	
	public void deleteEquipment(Equipment equipment) throws InexistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty() && !equipment.getTumberNumber().isEmpty()) {
			Equipment toBeDeleted = repository.findByTumberNumber(equipment.getTumberNumber());
			if (toBeDeleted != null && toBeDeleted.getSerialNumber() == equipment.getSerialNumber()) {
				repository.delete(toBeDeleted);
			} else {
				throw new InexistentObjectException("Equipamento não encontrado.");
			}
		}
	}
	
	public void updateEquipment(Equipment equipment, String tumberNumber) throws InexistentObjectException {
		Equipment foundEquipment = searchEquipmentByTumberNumber(tumberNumber);
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
	
	public EquipmentRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentRepository repository) {
		this.repository = repository;
	}
	
}
