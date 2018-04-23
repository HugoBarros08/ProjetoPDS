package br.imd.pds.service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.Sector;
import br.imd.pds.repository.SectorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por gerenciar Setores
 */
@Service
public class ManagementSectorService {
	
	@Autowired
	private SectorRepository repository;
	
	public List<Sector> listSector() {
		return repository.findAll();
	}
	
	public ManagementSectorService(SectorRepository repository) {
		this.repository = repository;
	}
	
	public SectorRepository getRepository() {
		return repository;
	}

	public void setRepository(SectorRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Inserindo um setor no repositório.
	 */
	public void insertSector(Sector sector) throws ExistentObjectException {
		if (sector != null && !sector.getName().isEmpty()) {
			if (repository.findByName(sector.getName()) == null) {
				repository.save(sector);
			} else {
				throw new ExistentObjectException("Já existe um departamento registrado com esse nome.");
			}
		}
	}
	
	/**
	 * Removendo um setor.
	 */
	public void deleteSector(Sector sector) throws InexistentObjectException {
		if (sector != null && !sector.getName().isEmpty()) {
			Sector toBeDeleted = this.searchSector(sector.getName());
			repository.delete(toBeDeleted);
		}
	}
	
	/**
	 * Atualizando um setor do repositório.
	 */
	public void updateSector(Sector sector, String name) throws InexistentObjectException
	{
		Sector foundSector = searchSector(name);
		foundSector.setName(sector.getName());
	}
	
	/**
	 * Buscando um setor no repositório.
	 */
	public Sector searchSector(String name) throws InexistentObjectException {		
		Sector foundSector = repository.findByName(name);
		if(foundSector!=null) {
			return foundSector;
		} else {
			throw new InexistentObjectException("Setor não encontrado.");
		}
	}
	
	/**
	 * Agenda data de manutenção
	 */
	public void schedule() {
		
	}
	
	/**
	 * Atualiza data de manutenção
	 */
	public void reschedule() {
		
	}
}
