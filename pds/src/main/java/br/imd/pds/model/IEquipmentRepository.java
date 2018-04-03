package br.imd.pds.model;

public interface IEquipmentRepository {
	public void createEquipment();
	public void deleteEquipment();
	public void updateEquipment();
	public Equipment searchEquipment();	
}