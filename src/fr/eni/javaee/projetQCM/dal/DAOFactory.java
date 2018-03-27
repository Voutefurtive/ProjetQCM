package fr.eni.javaee.projetQCM.dal;

public abstract class DAOFactory {
	
	public static LoginDAO getLoginDAO() {
		
		return new LoginDAOJdbcImpl();
	}

}
