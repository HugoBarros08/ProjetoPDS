package br.imd.pds.service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Sector;
import br.imd.pds.repository.SectorRepository;

import java.io.InvalidObjectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementSectorService {
	
	@Autowired
	private SectorRepository repository;
	
	public ManagementSectorService(SectorRepository repository) {
		this.repository = repository;
	}
	
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

	public SectorRepository getRepository() {
		return repository;
	}

	public void setRepository(SectorRepository repository) {
		this.repository = repository;
	}
}
