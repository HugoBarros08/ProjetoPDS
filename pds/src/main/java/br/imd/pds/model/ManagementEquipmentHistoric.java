package br.imd.pds.model;

import br.imd.pds.helpers.*;
import br.imd.pds.repository.IEquipmentHistoricRepository;

public class ManagementEquipmentHistoric {
	
	private IEquipmentHistoricRepository equipHistRepository;
	
	public ManagementEquipmentHistoric(IEquipmentHistoricRepository equipHistRepository) {
		this.equipHistRepository = equipHistRepository;
	}

	public void createEquipmentHistoric(EquipmentHistoric equipmentHistoric) throws InexistentObjectException {
	
	}
}
