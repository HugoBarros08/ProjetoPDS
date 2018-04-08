package br.imd.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.Equipment;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment,Long> {
	
	public Equipment findBySerialNumber(String serialNumber);
	
	public Equipment findByTumberNumber(String tumberNumber);

}