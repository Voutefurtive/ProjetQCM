package fr.eni.javaee.projetQCM.dal.question;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Question;

public interface QuestionDAO {
	
	public List<Question> selectQuestionsByTheme(int nbQuestion, int idTheme);

}
