package br.imd.pds.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.EquipmentHistoric;

@Repository
public interface EquipmentHistoricRepository extends JpaRepository<EquipmentHistoric,Long>{

	@Query("select u from EquipmentHistoric u where u.date = ?1")
	public EquipmentHistoric findByDate(Date date);
}
