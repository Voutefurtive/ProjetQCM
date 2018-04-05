package fr.eni.javaee.projetQCM.dal.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.projetQCM.bo.User;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;


public class UserDAOJdbcImpl implements UserDAO {

	public static final String SELECT = "SELECT * FROM UTILISATEUR WHERE nom=?;";
	public static final String SELECTBYPROMO = "SELECT * FROM UTILISATEUR WHERE codePromo=?;";
	public static final String SELECTBYNAME = "SELECT * FROM UTILISATEUR WHERE nom=?;";
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
	public List<User> selectByPromo(String codePromo) {
		
		Connection conn = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<User> promo = new ArrayList<User>();

		try {
			conn = ConnectionProvider.getConnection();
			rqt = conn.prepareStatement(SELECTBYPROMO);
			rqt.setString(1, codePromo);

			rs = rqt.executeQuery();

			while (rs.next()) {
				 User userPromo = new User(rs.getInt("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"), rs.getInt("codeProfil"),
						rs.getString("codePromo"));
				promo.add(userPromo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return promo ;
	}
	
	@Override
	public List<User> selectByName(String nom) {
		
		Connection conn = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<User> name = new ArrayList<User>();

		try {
			conn = ConnectionProvider.getConnection();
			rqt = conn.prepareStatement(SELECTBYPROMO);
			rqt.setString(1, nom);

			rs = rqt.executeQuery();

			while (rs.next()) {
				 User userName= new User(rs.getInt("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"), rs.getInt("codeProfil"),
						rs.getString("codePromo"));
				name.add(userName);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return name ;
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