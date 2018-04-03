package fr.eni.javaee.projetQCM.dal.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;


public class UserDAOJdbcImpl implements UserDAO {

	public static final String SELECT = "SELECT * FROM UTILISATEUR WHERE nom=?;";
	public static final String CREATE_COUNT = "INSERT INTO UTILISATEUR(nom, prenom, email, password, codeProfil) VALUES (?,?,?,?,?);";

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

				userLog = new User(rs.getInt("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"), rs.getInt("codeProfil"),
						rs.getString("codePromo"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userLog;
	}

	@Override
	public void insertUser(User newUser) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;

		if (newUser != null) {

			try {
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(CREATE_COUNT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, newUser.getNom());
				pstmt.setString(2, newUser.getPrenom());
				pstmt.setString(3, newUser.getEmail());
				pstmt.setString(4, newUser.getPassword());
				pstmt.setInt(5, newUser.getCodeProfil());
				//pstmt.setString(6, newUser.getCodePromo());

				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();

				if (rs.next()) {
					newUser.setId(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}