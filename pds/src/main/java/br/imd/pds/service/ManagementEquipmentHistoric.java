package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.EquipmentHistoric;
import br.imd.pds.repository.EquipmentHistoricRepository;

@Service
public class ManagementEquipmentHistoric {
	
	@Autowired
	private EquipmentHistoricRepository repository;
	
	public ManagementEquipmentHistoric(EquipmentHistoricRepository repository) {
		this.repository = repository;
	}

	public void createEquipmentHistoric(EquipmentHistoric equipmentHistoric) throws InexistentObjectException {
	
	}

	public EquipmentHistoricRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentHistoricRepository repository) {
		this.repository = repository;
	}
}
