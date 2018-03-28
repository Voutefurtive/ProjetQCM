/**
 * 
 */
package fr.eni.javaee.projetQCM.bll;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.Question;
import fr.eni.javaee.projetQCM.dal.QuestionDAO;

/**
 * @author vhersant2017
 *
 */
public class QuestionManager {
	private static List<Question> questionnaire;
	
	QuestionDAO questionDAO = DAOFactory.getQuestionDAO();
	
	public List<Question> getQuestionnaire(int idTheme){
		questionnaire = questionDAO.selectQuestionsByTheme(idTheme);
	}

}
