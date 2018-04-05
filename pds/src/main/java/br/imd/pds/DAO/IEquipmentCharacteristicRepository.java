package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.EquipmentCharacteristic;

public interface IEquipmentCharacteristicRepository extends JpaRepository<EquipmentCharacteristic,Long> {
	public void insertEquipmentCharacteristic();
	public void deleteEquipmentCharacteristic();
	public void updateEquipmentCharacteristic();
	public EquipmentCharacteristic searchEquipmentCharacteristic();
}
