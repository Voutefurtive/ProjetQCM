package fr.eni.javaee.projetQCM.dal;

import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAO;
import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAOJdbcImpl;
import fr.eni.javaee.projetQCM.dal.login.UserDAO;
import fr.eni.javaee.projetQCM.dal.login.UserDAOJdbcImpl;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAO;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAOJdbcImpl;
import fr.eni.javaee.projetQCM.dal.test.TestDAO;
import fr.eni.javaee.projetQCM.dal.test.TestDAOJdbcImpl;

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
	
	public static TestDAO getTestDAO() {
		return new TestDAOJdbcImpl();
	}

}
