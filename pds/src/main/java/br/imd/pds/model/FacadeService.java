package br.imd.pds.model;

public class FacadeService {

	private ManageEquipment mEquipement;
	
	private ManageSector mSector;
	
	private ManageUser mUser;
	
	private ManageAdministrator mAdministrator;
	
	private ManageEquipmentCharacteristic mEquipCharac;
	
	private ManageEquipmentHistoric mEquipHistoric;
	
	public FacadeService(ManageEquipment mEquip, ManageSector mSector, ManageUser mUser, ManageAdministrator mAdm, 
			ManageEquipmentCharacteristic mEquipCharac, ManageEquipmentHistoric mEquipHistoric) {
		this.mEquipement = mEquip;
		this.mSector = mSector;
		this.mUser = mUser;
		this.mAdministrator = mAdm;
		this.mEquipCharac = mEquipCharac;
		this.mEquipHistoric = mEquipHistoric;
	}
	
}
