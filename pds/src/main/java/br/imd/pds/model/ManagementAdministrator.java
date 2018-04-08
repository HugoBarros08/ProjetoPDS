package br.imd.pds.model;

import br.imd.pds.repository.IAdministratorRepository;

public class ManagementAdministrator {

	private IAdministratorRepository admRepository;

	public ManagementAdministrator(IAdministratorRepository admRepository) {
		this.admRepository = admRepository;
	}
}
