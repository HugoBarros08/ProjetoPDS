package br.imd.pds.model;

import br.imd.pds.repository.IUserRepository;

public class ManagementUser {
	
	private IUserRepository userRepository;

	public ManagementUser(IUserRepository userRepository) {
	 this.userRepository = userRepository;
	}
	
	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	
}
