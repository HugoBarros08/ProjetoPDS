package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.repository.AdministratorRepository;

@Service
public class ManagementAdministrator {

	@Autowired
	private AdministratorRepository repository;

	public AdministratorRepository getRepository() {
		return repository;
	}

	public void setRepository(AdministratorRepository repository) {
		this.repository = repository;
	}

}
