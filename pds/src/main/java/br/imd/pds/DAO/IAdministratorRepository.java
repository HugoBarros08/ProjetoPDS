package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.Administrator;

public interface IAdministratorRepository extends JpaRepository<Administrator,Long>{
	public void insertAdministrator();
	public void deleteAdministrator();
	public void updateAdministrator();
	public Administrator searchAdministrator();	
}
