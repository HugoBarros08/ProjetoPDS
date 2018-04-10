package br.imd.pds.DAO;

import org.junit.Test;

import br.imd.pds.model.User;
import br.imd.pds.repository.UserRepository;

public class UserRepositoryTest {

	UserRepository repository;
	
	@Test
	public void testRepository() {
		
		User user01 = new User("78945612302","adsadffff1","adfasdffff1@asd.com");
		User user02 = new User("12345678925","adsadfff232","adsfsadg@a.rsyt");
		User user03 = new User("45678913252","sdgzsdfh j h4","sdgasdfh@rrr.rgsd");
	
		repository.save(user01);
		repository.save(user02);
		repository.save(user03);
	}
}
