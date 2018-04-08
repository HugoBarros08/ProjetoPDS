package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Sector;

public interface ISectorRepository extends JpaRepository<Sector,Long> {
	
	public void insertSector();
	public void deleteSector();
	public void updateSector();
	public Sector searchSector();
	public void schedule();
	public void reschedule();
}
