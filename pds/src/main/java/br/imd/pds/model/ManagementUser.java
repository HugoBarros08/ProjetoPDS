package br.imd.pds.model;

import br.imd.pds.DAO.IUserRepository;

public class ManagementUser {
	
	private IUserRepository userRepository;

	public ManagementUser(IUserRepository userRepository) {
	 this.userRepository = userRepository;
	}
}
