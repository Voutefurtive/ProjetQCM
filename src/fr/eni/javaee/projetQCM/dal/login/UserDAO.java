package fr.eni.javaee.projetQCM.dal.login;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.User;

public interface UserDAO {

	public User selectUser(String nom);
	
	public void insertUser(User newUser);

	public List<User> selectByPromo(String codePromo);
	
	public List<User> selectByName(String nom);
	
}
