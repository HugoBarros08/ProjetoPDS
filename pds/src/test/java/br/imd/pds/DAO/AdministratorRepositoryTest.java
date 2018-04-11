package br.imd.pds.DAO;

import org.junit.Test;

import br.imd.pds.model.Administrator;
import br.imd.pds.repository.AdministratorRepository;


public class AdministratorRepositoryTest {
	
	AdministratorRepository repository;
	
	@Test
	public void testRepository() {
		
		Administrator admin1 = new Administrator("14256987563","Pedro", "Pedro123", "12345678", "pedro@asd.com");
		Administrator admin2 = new Administrator("45876321585","João", "João234", "12345678","joao@a.rsyt");
		Administrator admin3 = new Administrator("25567894258","Maria", "Maria111", "12345678","maria@rrr.rgsd");
	
		repository.save(admin1);
		repository.save(admin2);
		repository.save(admin3);
	}
}
