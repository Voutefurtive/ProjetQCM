/**
 * 
 */
package fr.eni.javaee.projetQCM.dal.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.SectionTest;
import fr.eni.javaee.projetQCM.bo.epreuves.Test;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;

/**
 * @author vhersant2017
 *
 */
public class TestDAOJdbcImpl implements TestDAO {

	private static String SELECT_BY_THEME = "SELECT t.*, s.idTheme, th.libelle, s.nbQuestionsATirer FROM TEST t INNER JOIN SECTION_TEST s ON t.idTest=s.idTest INNER JOIN THEME th ON s.idTheme=th.idTheme WHERE t.idTest=?;";
	private static String SELECT_BY_ID = "SELECT * FROM TEST WHERE idTest=?";
	/* (non-Javadoc)
	 * @see fr.eni.javaee.projetQCM.dal.test.TestDAO#getSections(int)
	 */
	@Override
	public List<SectionTest> getSections(int idTest) {
		
		List<SectionTest> sections = new ArrayList<SectionTest>();
		
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_THEME);
			pstmt.setInt(1, idTest);
			rs = pstmt.executeQuery();
			
			SectionTest sectionCourante = null;
			Test testCourant = null;
			
			while (rs.next()) {
				if(sectionCourante == null) {
					testCourant = new Test(rs.getInt("idTest"), rs.getString("libelle"), rs.getString("description"), rs.getInt("duree"), rs.getInt("seuil_haut"), rs.getInt("seuil_bas"));
				}
				sectionCourante = new SectionTest(rs.getInt("nbQuestionsATirer"),rs.getInt("idTheme"), testCourant);
				sections.add(sectionCourante);
			}
			testCourant.setSections(sections);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				cnx.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return sections;
	}
	
	@Override
	public Test getTest(int idTest) {
		Connection cnx;
		PreparedStatement pstmt;
		ResultSet rs;
		Test testCourant = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, idTest);
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				testCourant = new Test(rs.getInt("idTest"), rs.getString("libelle"), rs.getString("description"), rs.getInt("duree"), rs.getInt("seuil_haut"), rs.getInt("seuil_bas"));
			}
			
		} catch (Exception e) {

		}
		
		return testCourant;
	}

}
