/**
 * 
 */
package fr.eni.javaee.projetQCM.bll;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Epreuve;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;
import fr.eni.javaee.projetQCM.dal.DAOFactory;
import fr.eni.javaee.projetQCM.dal.epreuve.EpreuveDAO;
import fr.eni.javaee.projetQCM.dal.question.QuestionDAO;

/**
 * @author vhersant2017
 *
 */
public class EpreuveManager {
	
	QuestionDAO questionDAO;
	EpreuveDAO epreuveDAO;
	
	public EpreuveManager() {
		questionDAO = DAOFactory.getQuestionDAO();
		epreuveDAO = DAOFactory.getEpreuveDAO();
	}
	
	public List<Question> getSectionByTheme(int nbQuestion, int idTheme){
		return questionDAO.selectQuestionsByTheme(nbQuestion, idTheme);
	}

	public List<Epreuve> getEpreuvesByUser(int idUser){
		return epreuveDAO.selectEpreuvesByUser(idUser);
	}
}
