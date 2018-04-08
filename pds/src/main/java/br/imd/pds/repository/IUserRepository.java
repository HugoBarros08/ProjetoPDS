package br.imd.pds.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

}
