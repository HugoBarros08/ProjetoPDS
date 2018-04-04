package br.imd.pds.model;

import br.imd.pds.DAO.IAdministratorRepository;

public class ManagementAdministrator {

	private IAdministratorRepository admRepository;

	public ManagementAdministrator(IAdministratorRepository i) {
		admRepository = i;
	}
}
