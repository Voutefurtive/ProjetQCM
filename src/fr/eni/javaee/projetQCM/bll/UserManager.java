package fr.eni.javaee.projetQCM.bll;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.LoginDAO;

public class UserManager {

	private LoginDAO loginDAO;
	
	
	public UserManager(){
		this.loginDAO=DAOFactory.getLoginDAO();
		
	}
	
	public User authentification(String nom, String password) {

		User user = loginDAO.selectUser(nom);
		
		if(user!=null) {
			if(password.equals(user.getPassword()) == true) {
				return user;
			} else {
				return null;
			}
		}
		
		return user;
	}
	

}
	
