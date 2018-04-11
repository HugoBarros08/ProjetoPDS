package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.EquipmentHistoric;

@Repository
public interface EquipmentHistoricRepository extends JpaRepository<EquipmentHistoric,Long>{

}
