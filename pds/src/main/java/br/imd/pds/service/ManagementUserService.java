package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.helpers.InexistentObjectException;
import br.imd.pds.model.User;
import br.imd.pds.repository.UserRepository;

@Service
public class ManagementUserService {
	
	@Autowired
	private UserRepository repository;

	public ManagementUserService(UserRepository repository) {
	 this.repository = repository;
	}
	
	public void insertUser(User user) throws ExistentObjectException {
		if (user != null && !user.getRegistration().isEmpty()) {
			if (repository.findByRegistration(user.getRegistration()) == null) {
				repository.save(user);
			}
		}
	}
	
	public void deleteUser(User user) throws InexistentObjectException {
		if (user != null && !user.getRegistration().isEmpty()) {
			if (repository.findByRegistration(user.getRegistration()) != null) {
				repository.delete(user);
			}
		}
	}
	
	
}
