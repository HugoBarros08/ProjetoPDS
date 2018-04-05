package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Equipment;

public interface IEquipmentRepository extends JpaRepository<Equipment,Long> {
	
	public Equipment findBySerialNumber(String serialNumber);
	
	public Equipment findByTumberNumber(String tumberNumber);

}