package br.imd.pds.DAO;
import org.springframework.data.jpa.repository.JpaRepository;

import br.imd.pds.model.User;

public interface IUserRepository extends JpaRepository<User,Long> {
	public void insertUser();
	public void deleteUser();
	public void updateUser();
	public User searchUser();	
}
