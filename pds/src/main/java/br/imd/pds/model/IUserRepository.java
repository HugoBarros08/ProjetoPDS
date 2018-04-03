package br.imd.pds.model;

public interface IUserRepository {
	public void createUser();
	public void deleteUser();
	public void updateUser();
	public User searchUser();	
}
