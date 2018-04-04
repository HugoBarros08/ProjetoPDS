package br.imd.pds.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.io.InvalidObjectException;
import br.imd.pds.exceptions.*;

public class ManageEquipment
{	
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
