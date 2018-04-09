package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.EquipmentCharacteristic;

public interface EquipmentCharacteristicRepository extends JpaRepository<EquipmentCharacteristic,Long> {
	public void insertEquipmentCharacteristic();
	public void deleteEquipmentCharacteristic();
	public void updateEquipmentCharacteristic();
	public EquipmentCharacteristic searchEquipmentCharacteristic();
}
