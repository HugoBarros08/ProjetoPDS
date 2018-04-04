package br.imd.pds.model;

import java.io.InvalidObjectException;

import br.imd.pds.DAO.IEquipmentRepository;
import br.imd.pds.exceptions.*;

public class ManagementEquipment
{
	IEquipmentRepository equipRepository;
	
	public ManagementEquipment(IEquipmentRepository i) {
		equipRepository = i;
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
