package fr.eni.javaee.projetQCM.dal.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Proposition;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;
import fr.eni.javaee.projetQCM.dal.ConnectionProvider;

public class QuestionDAOJdbcImpl implements QuestionDAO {

	private static String SELECT_PARTIAL_BY_THEME = "SELECT * FROM question q INNER JOIN proposition p ON p.idQuestion=q.idQuestion WHERE q.idQuestion IN (SELECT TOP (?) idQuestion FROM QUESTION WHERE idTheme=? ORDER BY NEWID()) ORDER BY q.idQuestion;";

	public List<Question> selectQuestionsByTheme(int nbQuestion, int idTheme) {

		List<Question> listeQuestions = new ArrayList<>();
		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_PARTIAL_BY_THEME);
			pstmt.setInt(1, nbQuestion);
			pstmt.setInt(2, idTheme);
			ResultSet rs = pstmt.executeQuery();
			Question questionCourante = null;
			while (rs.next()) {
				if (questionCourante == null || questionCourante.getId() != rs.getInt("idQuestion")) {
					questionCourante = new Question();
					questionCourante.setId(rs.getInt("idQuestion"));
					questionCourante.setEnonce(rs.getString("enonce"));
					questionCourante.setPoints(rs.getInt("points"));
					listeQuestions.add(questionCourante);
				}

				Proposition prop = new Proposition();
				prop.setId(rs.getInt("idProposition"));
				prop.setEnonce(rs.getString(7));
				if (rs.getInt("estBonne") == 0) {
					prop.setEstBonne(false);
				} else {
					prop.setEstBonne(true);
				}
				questionCourante.addProposition(prop);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listeQuestions;
	}

}
