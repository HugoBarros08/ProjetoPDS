package br.imd.pds.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.*;
import br.imd.pds.model.EquipmentHistoric;
import br.imd.pds.repository.EquipmentHistoricRepository;

/**
 * Classe responsável por gerenciar os Históricos dos Equipamentos
 */
@Service
public class ManagementEquipmentHistoricService {
	
	@Autowired
	private EquipmentHistoricRepository repository;
	
	public ManagementEquipmentHistoricService(EquipmentHistoricRepository repository) {
		this.repository = repository;
	}

	public EquipmentHistoricRepository getRepository() {
		return repository;
	}

	public void setRepository(EquipmentHistoricRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Insere histórico do equipamento no repositório.
	 */
	public void insertEquipmentHistoric(EquipmentHistoric equipmentHistoric) throws ExistentObjectException {
		if (equipmentHistoric != null && equipmentHistoric.getDate() != null && !equipmentHistoric.getLog().isEmpty()) {
			if (repository.findByDate(equipmentHistoric.getDate()) == null) {
				repository.save(equipmentHistoric);
			} else {
				throw new ExistentObjectException("Já existe um histórico resgistrada nessa data.");
			}
		}
	}
	
	/**
	 * Atualiza histórico do equipamento do repositório.
	 */
	public void updateEquipmentHistoric(EquipmentHistoric equipmentHistoric, Date date) throws InexistentObjectException {
		EquipmentHistoric foundEquipmentHistoric = searchEquipmentHistoric(date);
		foundEquipmentHistoric.setDate(equipmentHistoric.getDate());
		foundEquipmentHistoric.setLog(equipmentHistoric.getLog());
	}
	
	/**
	 * Busca histórico do equipamento no repositório através da data.
	 */
	public EquipmentHistoric searchEquipmentHistoric(Date date) throws InexistentObjectException {
		EquipmentHistoric foundEquipmentHistoric = repository.findByDate(date);
		if(foundEquipmentHistoric != null) {
			return foundEquipmentHistoric;
		} else {
			throw new InexistentObjectException("Não existe histórico registrado nessa data.");
		}
	}
}