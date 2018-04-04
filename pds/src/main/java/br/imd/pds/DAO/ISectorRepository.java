package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Sector;

public interface ISectorRepository extends JpaRepository<Sector,Long>{
	public void createSector();
	public void deleteSector();
	public void updateSector();
	public Sector searchSector();
	public void schedule();
	public void reschedule();
}
