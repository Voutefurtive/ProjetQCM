package fr.eni.javaee.projetQCM.bll;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.login.UserDAO;

public class UserManager {

	private UserDAO userDAO;

	public UserManager() {
		this.userDAO = DAOFactory.getUserDAO();

	}

	public User authentification(String nom, String password) {

		User user = userDAO.selectUser(nom);

		if (user != null) {
			if (password.equals(user.getPassword()) == true) {
				return user;
			} else {
				return null;
			}
		}

		return user;
	}

	// TODO fonction de génération de mdp
	
	public void createCount(String nom, String prenom, String email, String password, int codeProfil, String codePromo) {
		
		User newUser = new User(nom, prenom, email, password, codeProfil, codePromo);
		
		userDAO.insertUser(newUser);
		 
		

	}
}
