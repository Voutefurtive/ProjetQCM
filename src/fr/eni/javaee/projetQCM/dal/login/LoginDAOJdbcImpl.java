package fr.eni.javaee.projetQCM.dal.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;

public class LoginDAOJdbcImpl implements LoginDAO {

	
	public static final String SELECT="SELECT * FROM UTILISATEUR(id, nom, prenom, email, password, codeProfil);";
	
	
		public void User(int id, String nom, String prenom, String email, String password, int codeProfil, String codePromo) {
			Connection conn = null;
			User user;
			PreparedStatement rqt = null;
			ResultSet rs;

			try { 
				conn = ConnectionProvider.getConnection();
				rqt = conn.prepareStatement(SELECT);
				rqt.setInt(1, id);
				rqt.setString(2, nom);
				rqt.setString(3, prenom);
				rqt.setString(4, email);
				rqt.setString(5, password);
				rqt.setInt(6, codeProfil);
				rqt.setString(7, codePromo);
				
				rs = rqt.executeQuery();

				if (rs.next()) {

					user = new User(rs.getInt("id"),
							rs.getString("Nom"), rs.getString("Prenom"),
							rs.getString("email"),rs.getString("password"),
							rs.getInt("codeProfil"), rs.getString("codePromo"));
					
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return user;
		}


		@Override
		public void User() {
			// TODO Auto-generated method stub
			
		}
	
	
	
}
