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

/**
 * Classe responsável por realizar teste do Equipamento
*/
public class EquipmentRepositoryTest {

	EquipmentRepository repository;
	
	@Test
	public void testRepository(){
		
		repository.save(new Equipment("BRT852RFTQ", "2012005412", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
		repository.save(new Equipment("BRT852RFTF", "2012005415", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
		repository.save(new Equipment("BRT852RFTB", "2012005413", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
	
		final List<Equipment> equipments = repository.findAll();
		System.out.println(equipments);
		
		assertEquals(3, equipments.size());
	}
}
