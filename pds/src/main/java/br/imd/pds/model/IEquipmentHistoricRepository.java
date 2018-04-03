package br.imd.pds.model;

public interface IEquipmentHistoricRepository {
	public void createEquipmentHistoric();
	public void deleteEquipmentHistoric();
	public void updateEquipmentHistoric();
	public EquipmentHistoric searchEquipmentHistoric();	
}
