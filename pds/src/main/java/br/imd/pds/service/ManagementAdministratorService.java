package br.imd.pds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.helpers.InexistentObjectException;
import br.imd.pds.model.Administrator;
import br.imd.pds.repository.AdministratorRepository;

@Service
public class ManagementAdministratorService {

	@Autowired
	private AdministratorRepository repository;
	
	public List<Administrator> listAdministrator() {
		return repository.findAll();
	}

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
			} else {
				throw new ExistentObjectException("Já existe um administrador registrado com esse CPF");
			}
		}
	}

	public void deleteAdministrator(Administrator administrator) throws InexistentObjectException {
		if (administrator != null && !administrator.getCpf().isEmpty()) {
			Administrator toBeDeleted = this.searchAdministrator(administrator.getCpf());
			Administrator toBeChanged = toBeDeleted;
			repository.delete(toBeDeleted);
			toBeChanged.setFlag(false);
			repository.save(toBeChanged);
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

	public void updateAdministrator(Administrator administrator, String cpf) throws InexistentObjectException {
		Administrator foundAdministrator = searchAdministrator(cpf);
		foundAdministrator.setCpf(administrator.getCpf());
		foundAdministrator.setEmail(administrator.getEmail());
		foundAdministrator.setName(administrator.getName());
	}

}
