package br.imd.pds.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Equipment;
import br.imd.pds.repository.EquipmentRepository;

/**
 * Classe responsável por gerenciar Equipamentos
 */
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
	
	/**
	 * Inserindo um equipamento no repositório.
	 */
	public void insertEquipment(Equipment equipment, boolean defaultScheduling) throws ExistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty()) {
			if (repository.findBySerialNumber(equipment.getSerialNumber()) == null) {
				if(defaultScheduling) {
					scheduling(equipment);
				}
				repository.save(equipment);
			} else {
				throw new ExistentObjectException("Já existe um equipamento registrado com esse número de serial.");
			}
		}
	}
	
	/**
	 * Removendo um equipamento do repositório.
	 */
	public void deleteEquipment(Equipment equipment) throws InexistentObjectException {
		if (equipment != null && !equipment.getSerialNumber().isEmpty()) {
			Equipment toBeDeleted = this.searchEquipmentBySerialNumber(equipment.getSerialNumber());
			repository.delete(toBeDeleted);
		}
	}
	
	/**
	 * Atualizando um equipamento do repositório.
	 */
	public void updateEquipment(Equipment equipment, String serialNumber) throws InexistentObjectException {
		Equipment foundEquipment = searchEquipmentBySerialNumber(serialNumber);
		foundEquipment.setSerialNumber(equipment.getSerialNumber());
		foundEquipment.setTumberNumber(equipment.getTumberNumber());
		foundEquipment.setRegistrationDate(equipment.getRegistrationDate());
		foundEquipment.setLastMaintenance(equipment.getLastMaintenance());
		
	}
	
	/**
	 * Buscando um equipamento no repositório através do Número de Tombo.
	 */
	public Equipment searchEquipmentByTumberNumber(String tumberNumber) throws InexistentObjectException {
		Equipment foundEquipment = repository.findByTumberNumber(tumberNumber);
		if(foundEquipment!=null) {
			return foundEquipment;
		} else {
			throw new InexistentObjectException("Equipamento não encontrado.");
		}
	}
	
	/**
	 * Buscando um equipamento no repositório através do Número Serial.
	 */
	public Equipment searchEquipmentBySerialNumber(String serialNumber) throws InexistentObjectException {
		Equipment foundEquipment = repository.findBySerialNumber(serialNumber);
		if(foundEquipment!=null) {
			return foundEquipment;
		} else {
			throw new InexistentObjectException("Equipamento não encontrado.");
		}
	}
	
	/**
	 * Agenda a próxima manutenção do equipamento
	 * @param
	 * @return
	 */
	public void scheduling(Equipment equipment) {
		int year = Integer.parseInt(equipment.getTumberNumber().substring(0,3));
		Date lastMaintenance = equipment.getLastMaintenance();
		
		if(year >= 2008 && year <= 2010) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 2);
			equipment.setNextMaintenance(calendar.getTime());
		} else if(year == 2011 || year == 2012) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 4);
			equipment.setNextMaintenance(calendar.getTime());			
		} else if(year == 2013 || year == 2014) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 6);
			equipment.setNextMaintenance(calendar.getTime());			
		} else if(year == 2015 || year == 2016) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 8);
			equipment.setNextMaintenance(calendar.getTime());			
		} else if(year == 2017 || year == 2018) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastMaintenance);
			calendar.add(Calendar.MONTH, 10);
			equipment.setNextMaintenance(calendar.getTime());			
		}
	}
	
//	/**
//	 * Agenda a próxima manutenção do equipamento
//	 * @param numberOfMonths
//	 * @return
//	 */
//	public void scheduling(Equipment equipment, int numberOfMonths) {
//		Date lastMaintenance = equipment.getLastMaintenance();
//		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(lastMaintenance);
//		calendar.add(Calendar.MONTH, numberOfMonths);
//		equipment.setNextMaintenance(calendar.getTime());
//	}
}
