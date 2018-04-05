/**
 * 
 */
package fr.eni.javaee.projetQCM.bll;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Epreuve;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;
import fr.eni.javaee.projetQCM.bo.epreuves.SectionTest;
import fr.eni.javaee.projetQCM.bo.epreuves.Test;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAO;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAO;
import fr.eni.javaee.projetQCM.dal.test.TestDAO;

/**
 * @author vhersant2017
 *
 */
public class EpreuveManager {
	
	QuestionDAO questionDAO;
	EpreuveDAO epreuveDAO;
	TestDAO testDAO;
	
	public EpreuveManager() {
		questionDAO = DAOFactory.getQuestionDAO();
		epreuveDAO = DAOFactory.getEpreuveDAO();
		testDAO = DAOFactory.getTestDAO();
	}
	
	public List<SectionTest> getSections(int idTest){
		return testDAO.getSections(idTest);
	}
	
	public List<Question> getSectionByTheme(int nbQuestion, int idTheme){
		return questionDAO.selectQuestionsByTheme(nbQuestion, idTheme);
	}

	public List<Epreuve> getEpreuvesByUser(int idUser){
		return epreuveDAO.selectEpreuvesByUser(idUser);
	}
	
	public Test getTestById(int idTest) {
		return testDAO.getTest(idTest);
	}
	
	public void saveQuestionnaire(List<Question> questionnaire, int idEpreuve) {
		epreuveDAO.saveQuestionnaire(questionnaire, idEpreuve);
	}
}
