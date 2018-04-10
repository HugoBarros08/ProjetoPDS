package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.imd.pds.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator,Long>{
	
		@Query("select u from Administrator u where u.registration = ?1")
		public Administrator findByCpf(String cpf);		
}
