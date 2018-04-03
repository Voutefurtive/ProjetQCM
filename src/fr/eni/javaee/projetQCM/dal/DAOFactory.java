package fr.eni.javaee.projetQCM.dal;

import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAO;
import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAOJdbcImpl;
import fr.eni.javaee.projetQCM.dal.login.LoginDAO;
import fr.eni.javaee.projetQCM.dal.login.LoginDAOJdbcImpl;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAO;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAOJdbcImpl;

public abstract class DAOFactory {
	
	public static UserDAO getUserDAO() {
		
		return new UserDAOJdbcImpl();
	}
	
	public static QuestionDAO getQuestionDAO() {
		return new QuestionDAOJdbcImpl();
	}
	
	public static EpreuveDAO getEpreuveDAO() {
		return new EpreuveDAOJdbcImpl();
	}

}
