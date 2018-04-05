/**
 * 
 */
package fr.eni.javaee.projetQCM.dal.epreuve;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Epreuve;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;

/**
 * @author vhersant2017
 *
 */
public interface EpreuveDAO {
	
	public List<Epreuve> selectEpreuvesByUser(int idUser);

	public void saveQuestionnaire(List<Question> questionnaire, int idEpreuve);
}
