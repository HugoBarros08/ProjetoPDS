package br.imd.pds.model;

import br.imd.pds.exceptions.*;
import java.io.InvalidObjectException;

public class ManagementSector
{
	
	public void createSector(Sector sector) throws ExistentObjectException {

	}
	
	public void deleteSector(String name) throws InexistentObjectException {
	
	}
	
	public void updateSector() throws ExistentObjectException, InexistentObjectException
	{
		
	}
	
	public Sector searchSector(String name) throws InexistentObjectException {
		
		Sector sec = null;
		
		return sec;
	}
	
	public void schedule() {
		
	}
	
	public void reschedule() {
		
	}
}
