package br.imd.pds.model;

import br.imd.pds.DAO.IEquipmentHistoricRepository;
import br.imd.pds.helpers.*;

public class ManagementEquipmentHistoric {
	
	private IEquipmentHistoricRepository equipHistRepository;
	
	public ManagementEquipmentHistoric(IEquipmentHistoricRepository equipHistRepository) {
		this.equipHistRepository = equipHistRepository;
	}

	public void createEquipmentHistoric(EquipmentHistoric equipmentHistoric) throws InexistentObjectException {
	
	}
}
