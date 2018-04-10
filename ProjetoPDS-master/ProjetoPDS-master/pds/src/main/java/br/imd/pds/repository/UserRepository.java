package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("select u from User u where u.registration = ?1")
	public User findByCpf(String cpf);

}
