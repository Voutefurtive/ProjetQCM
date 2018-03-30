package fr.eni.javaee.projetQCM.dal;

public abstract class DAOFactory {
	
	public static UserDAO getUserDAO() {
		
		return new UserDAOJdbcImpl();
	}

}
