package fr.eni.javaee.projetQCM.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.projetQCM.bo.Proposition;
import fr.eni.javaee.projetQCM.bo.Question;

public class QuestionDAOJdbcImpl implements QuestionDAO {

	private static String SELECT_BY_THEME="SELECT * FROM question q INNER JOIN proposition p ON p.idQuestion=q.idQuestion WHERE q.idTheme=? ORDER BY q.idQuestion;";
	
	public List<Question> selectQuestionsByTheme(int idTheme){
	
		List<Question> listeQuestions = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_THEME);
			pstmt.setInt(1, idTheme);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Question questionCourante = new Question();
				questionCourante.setId(rs.getInt("idQuestion"));
				questionCourante.setEnonce(rs.getString("enonce"));
				questionCourante.setPoints(rs.getInt("points"));
				
				while(rs.getInt("idQuestion")==questionCourante.getId()) {
					Proposition prop = new Proposition();
					prop.setId(rs.getInt("idProposition"));
					prop.setEnonce(rs.getString(7));
					if(rs.getInt("estBonne")==0) {
						prop.setEstBonne(false);
					} else {
						prop.setEstBonne(true);
					}
					questionCourante.addProposition(prop);
					rs.next();
				}
				rs.previous();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		return listeQuestions;
	}
	
}
