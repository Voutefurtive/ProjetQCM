package fr.eni.javaee.projetQCM.dal;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.Question;

public interface QuestionDAO {
	
	public List<Question> selectQuestionsByTheme(int idTheme);

}
