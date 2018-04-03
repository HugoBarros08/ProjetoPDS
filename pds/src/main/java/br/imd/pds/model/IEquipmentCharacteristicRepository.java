package br.imd.pds.model;

public interface IEquipmentCharacteristicRepository {
	public void createEquipmentCharacteristic();
	public void removeEquipmentCharacteristic();
	public void updateEquipmentCharacteristic();
	public EquipmentCharacteristic searchEquipmentCharacteristic();
}
