package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {
	
	@Query("select u from Sector u where u.name = ?1")
	public Sector findByName(String name);
}
