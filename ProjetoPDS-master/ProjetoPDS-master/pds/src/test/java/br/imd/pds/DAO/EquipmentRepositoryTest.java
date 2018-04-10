package br.imd.pds.DAO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import br.imd.pds.controllers.UserController;
import br.imd.pds.model.Equipment;
import br.imd.pds.model.User;
import br.imd.pds.repository.EquipmentRepository;
import br.imd.pds.repository.UserRepository;

public class EquipmentRepositoryTest {

	EquipmentRepository repository;
	UserRepository rep;
	
	@Test
	public void testRepository(){
		
		UserController t = new UserController();
		t.newUser(new User("sadasda", "dsadsada", "sdadsada"));
		//rep.save(new User("sadasda", "dsadsada", "sdadsada"));
		//repository.save(new Equipment(501, "BRT852RFTQ", "2012005412", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
		//repository.save(new Equipment(502, "BRT852RFTF", "2012005415", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
		//repository.save(new Equipment(503, "BRT852RFTB", "2012005413", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
	
		final List<User> equipments = rep.findAll();
		System.out.println(equipments);
		
		assertEquals(1, equipments.size());
	}
}
