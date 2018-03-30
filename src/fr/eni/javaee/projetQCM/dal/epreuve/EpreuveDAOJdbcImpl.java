/**
 * 
 */
package fr.eni.javaee.projetQCM.dal.epreuve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Epreuve;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;

/**
 * @author vhersant2017
 *
 */
public class EpreuveDAOJdbcImpl implements EpreuveDAO {

	private static String SELECT_BY_USER = "SELECT e.*,t.libelle FROM EPREUVE e INNER JOIN TEST t ON e.idTest=t.idTest WHERE idUtilisateur=?;";
	
	/* (non-Javadoc)
	 * @see fr.eni.javaee.projetQCM.dal.EpreuveDAO#selectEpreuvesByUser(int)
	 */
	@Override
	public List<Epreuve> selectEpreuvesByUser(int idUser){
		List<Epreuve> epreuves = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_USER);
			pstmt.setInt(1, idUser);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Epreuve epreuveCourante = new Epreuve(
						rs.getInt("idEpreuve"),
						rs.getDate("dateDebutValidite"),
						rs.getDate("dateFinValidite"),
						rs.getInt("tempsEcoule"),
						rs.getString("etat"),
						rs.getFloat("note_obtenue"),
						rs.getString("niveau_obtenu"),
						rs.getInt("idUtilisateur"),
						rs.getInt("idTest"));
				
				epreuves.add(epreuveCourante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return epreuves;
	}
}
