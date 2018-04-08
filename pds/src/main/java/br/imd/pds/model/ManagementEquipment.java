package br.imd.pds.model;

import java.io.InvalidObjectException;

import br.imd.pds.helpers.*;
import br.imd.pds.repository.IEquipmentRepository;

public class ManagementEquipment {
	
	private IEquipmentRepository equipRepository;
	
	public ManagementEquipment(IEquipmentRepository equipRepository) {
		this.equipRepository = equipRepository;
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
	
}
