package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Sector;

public interface SectorRepository extends JpaRepository<Sector,Long> {
	

}
