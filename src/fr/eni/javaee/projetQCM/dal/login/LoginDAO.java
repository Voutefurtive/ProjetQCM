package fr.eni.javaee.projetQCM.dal.login;

import fr.eni.javaee.projetQCM.bo.User;

public interface LoginDAO {

	public User selectUser(String nom);
		
	
}
