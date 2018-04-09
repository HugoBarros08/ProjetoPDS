package br.imd.pds.model;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.helpers.InexistentObjectException;
import br.imd.pds.repository.IUserRepository;

public class ManagementUser {
	
	private IUserRepository userRepository;

	public ManagementUser(IUserRepository userRepository) {
	 this.userRepository = userRepository;
	}
	
	public void insertUser(User user) throws ExistentObjectException {
		if (user != null && !user.getRegistration().isEmpty()) {
			if (userRepository.findByRegistration(user.getRegistration()) == null) {
				userRepository.save(user);
			}
		}
	}
	
	public void deleteUser(User user) throws InexistentObjectException {
		if (user != null && !user.getRegistration().isEmpty()) {
			if (userRepository.findByRegistration(user.getRegistration()) != null) {
				userRepository.delete(user);
			}
		}
	}
	
	
}
