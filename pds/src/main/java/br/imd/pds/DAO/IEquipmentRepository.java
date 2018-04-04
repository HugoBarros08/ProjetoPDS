package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Equipment;

public interface IEquipmentRepository extends JpaRepository<Equipment,Long>{
	
	public void createEquipment();
	public void deleteEquipment();
	public void updateEquipment();
	public Equipment searchEquipment();	
}