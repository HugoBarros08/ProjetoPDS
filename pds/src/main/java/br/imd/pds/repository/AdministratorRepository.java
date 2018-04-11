package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Long>{
	
		@Query("select a from Administrator a where a.cpf = ?1")
		public Administrator findByCpf(String cpf);		
}
