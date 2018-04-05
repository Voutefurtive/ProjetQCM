package fr.eni.javaee.projetQCM.bll;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.login.UserDAO;

public class UserManager {

	private UserDAO userDAO;

	public UserManager() {
		this.userDAO = DAOFactory.getUserDAO();

	}

	@SuppressWarnings({ "static-access", "unused" })
	
	public User authentification(String nom, String password) {
		
		PasswordHashMD5 pa = new PasswordHashMD5();
		
		User user = userDAO.selectUser(nom);
		
	//	String moche = "tonton";
	//	moche = pa.cryptWithMD5(password);
	//	String mdp = user.getPassword();
		String mdp = pa.cryptWithMD5(password);
		
//		System.out.println("le mdp base haché est : " + user.getPassword());
//		System.out.println("le mdp saisie est : " + password);
//		System.out.println("le mdp saisie puis steak est " + mdp);
		
		if (user != null) {
			if (mdp.equals(user.getPassword()) == true) {
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
	
	public List<User> selectPromo (String codePromo) {
		
		List<User> promo = userDAO.selectByPromo(codePromo);
		
		if (promo != null) {
			return promo;
			
			} else {
				return null;
			}
		
	}
	
	
}
