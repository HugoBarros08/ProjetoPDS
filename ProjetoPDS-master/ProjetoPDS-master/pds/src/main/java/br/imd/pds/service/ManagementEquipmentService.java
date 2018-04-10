package br.imd.pds.service;

import java.io.InvalidObjectException;

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
	
	private void validade(Equipment equipment) throws InvalidObjectException {
		
		throw new InvalidObjectException("");
	}
	
	public boolean validateObjEquipment() throws InvalidObjectException {
		
		return false;
	}
	
	public void createEquipment(Equipment equipment) throws ExistentObjectException {
		
	}
	
	public void deleteEquipment(int id) throws InexistentObjectException {
		
	}
	
	public void updateEquipment(Equipment equipment) throws InexistentObjectException, ExistentObjectException {
		
	}
	
	public Equipment searchEquipment(int id) throws InexistentObjectException {
		Equipment eq = null;
		return eq;
	}

	public EquipmentRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentRepository repository) {
		this.repository = repository;
	}
	
}
