package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.EquipmentCharacteristic;

@Repository
public interface EquipmentCharacteristicRepository extends JpaRepository<EquipmentCharacteristic,Long> {

	public EquipmentCharacteristic findByName(String name);
}
