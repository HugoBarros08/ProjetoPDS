package br.imd.pds.DAO;

import org.junit.Test;

import br.imd.pds.model.User;
import br.imd.pds.repository.UserRepository;

/**
 * Classe responsável por realizar teste do Usuário
*/
public class UserRepositoryTest {

	UserRepository repository;
	
	@Test
	public void testRepository() {
		
		User user01 = new User("78945612302","Pedro","pedro@asd.com");
		User user02 = new User("12345678925","João","joao@a.rsyt");
		User user03 = new User("45678913252","Maria","maria@rrr.rgsd");
	
		repository.save(user01);
		repository.save(user02);
		repository.save(user03);
	}
}
