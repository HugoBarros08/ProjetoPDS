package br.imd.pds.service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Sector;
import br.imd.pds.model.User;
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
	
	public void insertSector(Sector sector) throws ExistentObjectException {
		if (sector != null && !sector.getName().isEmpty()) {
			if (repository.findByName(sector.getName()) == null) {
				repository.save(sector);
			} else {
				throw new ExistentObjectException("Já existe um departamento registrado com esse nome.");
			}
		}
	}
	
	public void deleteSector(Sector sector) throws InexistentObjectException {
		if (sector != null && !sector.getName().isEmpty()) {
			Sector toBeDeleted = repository.findByName(sector.getName());
			if (toBeDeleted != null) {
				repository.delete(toBeDeleted);
			} else {
				throw new InexistentObjectException("Setor não encontrado.");
			}
		}
	}
	
	public void updateSector(Sector sector, String name) throws InexistentObjectException
	{
		Sector foundSector = searchSector(name);
		foundSector.setName(sector.getName());
	}
	
	public Sector searchSector(String name) throws InexistentObjectException {		
		Sector foundSector = repository.findByName(name);
		if(foundSector!=null) {
			return foundSector;
		} else {
			throw new InexistentObjectException("Setor não encontrado.");
		}
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
