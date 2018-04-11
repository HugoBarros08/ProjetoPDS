package br.imd.pds.DAO;

import org.junit.Test;

import br.imd.pds.model.Sector;
import br.imd.pds.repository.SectorRepository;


public class SectorRepositoryTest {
	
	SectorRepository repository;
	
	@Test
	public void testRepository() {
		
		Sector s1 = new Sector(23, "suporte");
		Sector s2 = new Sector(55, "financeiro");
		Sector s3 = new Sector(10, "administrativo");
	
		repository.save(s1);
		repository.save(s2);
		repository.save(s3);
		
		
	}
}

