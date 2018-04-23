package br.imd.pds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.imd.pds.model.UserRole;

@Repository("roleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	
	UserRole findByRole(String role);
}
