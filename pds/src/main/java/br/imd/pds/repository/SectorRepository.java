package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.stereotype.Repository;
>>>>>>> d96cd5757951d590b732959dbc337968c5c6d236

import br.imd.pds.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {
	
	@Query("select u from Sector u where u.name = ?1")
	public Sector findByName(String name);
}
