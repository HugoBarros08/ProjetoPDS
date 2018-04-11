package br.imd.pds.service;

import java.util.List;

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
	
	
	public List<User> listUser() {
		return repository.findAll();
	}

	
	public void insertUser(User user) throws ExistentObjectException {
		if (user != null && !user.getCpf().isEmpty()) {
			if (repository.findByCpf(user.getCpf()) == null) {
				repository.save(user);
			} else {
				throw new ExistentObjectException("User found.");
			}
		}
	}
	
	public void deleteUser(User user) throws InexistentObjectException {
		if (user != null && !user.getCpf().isEmpty()) {
			if (repository.findByCpf(user.getCpf()) != null) {
				repository.delete(user);
			} else {
				throw new InexistentObjectException("User not found.");
			}
		}
	}
	
	public User searchUser(String cpf) throws InexistentObjectException {
		User user = repository.findByCpf(cpf);
			if (user != null) {
				return user;
			} else {
				throw new InexistentObjectException("User not found.");
			}
	}
	
	public void updateUser(User user, String cpf) throws InexistentObjectException {
		User foundUser = searchUser(cpf);
		foundUser.setCpf(user.getCpf());
		foundUser.setEmail(user.getEmail());
		foundUser.setName(user.getName());
	}
}
