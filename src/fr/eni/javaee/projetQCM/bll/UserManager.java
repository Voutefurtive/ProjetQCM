package fr.eni.javaee.projetQCM.bll;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.LoginDAO;

public class UserManager {

	private LoginDAO loginDAO;
	
	
	public UserManager(){
		this.loginDAO=DAOFactory.getLoginDAO();
		
	}
	
	public boolean authentification(String nom, String password) {
		boolean autorisation = false;
		User user = loginDAO.selectUser(nom);
		System.out.println(user);
		if(user!=null) {
			autorisation = password.equals(user.getPassword());
		}
		
		return autorisation;
	}
}
