package fr.eni.javaee.projetQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.projetQCM.bo.User;

public class LoginDAOJdbcImpl implements LoginDAO {

	
	public static final String SELECT="SELECT * FROM UTILISATEUR WHERE nom=?;";
	
	@Override
	public User selectUser(String nom) {
			Connection conn = null;
			User userLog = null;
			PreparedStatement rqt = null;		
			ResultSet rs = null;

			try { 
				conn = ConnectionProvider.getConnection();
				rqt = conn.prepareStatement(SELECT);
				rqt.setString(1, nom);

				rs = rqt.executeQuery();

				if (rs.next()) {

					userLog = new User(rs.getInt("idUtilisateur"),
							rs.getString("nom"), rs.getString("prenom"),
							rs.getString("email"),rs.getString("password"),
							rs.getInt("codeProfil"), rs.getString("codePromo"));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return userLog;
		}

	/*	public User selectUser(int id) {
			Connection conn = null;
			User userLog = null;
			PreparedStatement rqt = null;		
			ResultSet rs = null;

			try { 
				conn = ConnectionProvider.getConnection();
				rqt = conn.prepareStatement(SELECT);
				rqt.setInt(1, id);

				rs = rqt.executeQuery();

				if (rs.next()) {

					userLog = new User(rs.getInt("idUtilisateur"),
							rs.getString("nom"), rs.getString("prenom"),
							rs.getString("email"),rs.getString("password"),
							rs.getInt("codeProfil"), rs.getString("codePromo"));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return userLog;
		}
*/
	
	
}
