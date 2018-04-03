package fr.eni.javaee.projetQCM.dal;

import fr.eni.javaee.projetQCM.bo.User;

public interface UserDAO {

	public User selectUser(String nom);
	
	public void insertUser(User newUser);
	
}
