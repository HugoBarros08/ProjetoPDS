package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByCpf(String cpf);
	
	@Query("select u from User u left join fetch u.roles where lower(u.username) = lower(:username) ")
	public User findByUsername(@Param("username") String username);
}
