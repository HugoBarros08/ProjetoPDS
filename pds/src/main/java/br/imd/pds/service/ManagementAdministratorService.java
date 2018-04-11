package br.imd.pds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.helpers.InexistentObjectException;
import br.imd.pds.model.Administrator;
import br.imd.pds.model.User;
import br.imd.pds.repository.AdministratorRepository;
import br.imd.pds.repository.UserRepository;

@Service
public class ManagementAdministratorService {

	@Autowired
	private AdministratorRepository repository;

	public AdministratorRepository getRepository() {
		return repository;
	}

	public void setRepository(AdministratorRepository repository) {
		this.repository = repository;
	}

	public ManagementAdministratorService(AdministratorRepository repository) {
		 this.repository = repository;
		}

	public void insertAdministrator(Administrator administrator) throws ExistentObjectException {
		if (administrator != null && !administrator.getCpf().isEmpty()) {
			if (repository.findByCpf(administrator.getCpf()) == null) {
				repository.save(administrator);
			}
		}
	}

	public void deleteAdministrator(Administrator administrator) throws InexistentObjectException {
		if (administrator != null && !administrator.getCpf().isEmpty()) {
			if (repository.findByCpf(administrator.getCpf()) != null) {
				repository.delete(administrator);
			}
		}
	}

	public Administrator searchAdministrator(String cpf) throws InexistentObjectException {
		Administrator administrator = repository.findByCpf(cpf);
		if (administrator != null) {
			return administrator;
		} else {
			throw new InexistentObjectException("Administrador não encontrado.");
		}
	}

	public void updateAdministrator(Administrator administrator, String cpf) throws InexistentObjectException, ExistentObjectException {
		Administrator foundAdministrator = searchAdministrator(cpf);
		deleteAdministrator(foundAdministrator);
		insertAdministrator(administrator);
	}

}