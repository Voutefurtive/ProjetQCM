package fr.eni.javaee.projetQCM.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.projetQCM.bll.EpreuveManager;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;
import fr.eni.javaee.projetQCM.bo.epreuves.SectionTest;
import fr.eni.javaee.projetQCM.bo.epreuves.Test;

/**
 * Servlet implementation class ServletAffichageQuestion
 */
@WebServlet("/question")
public class ServletAffichageQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EpreuveManager mger = new EpreuveManager();
		
		HttpSession session = request.getSession();
		
		// Création de la liste de questions
		if (session.getAttribute("questionnaire")==null) {
			Test test = (Test)session.getAttribute("test");
			List<Question> questionnaire = new ArrayList<Question>();
			
			test.setSections(mger.getSections(test.getIdTest()));
			
			for (SectionTest sectionTest : test.getSections()) {
				questionnaire.addAll(mger.getSectionByTheme(sectionTest.getNbQuestion(),sectionTest.getIdTheme()));
			}
			
			int index = 0;
			for (Question question : questionnaire) {
				question.setNumOrdre(index);
				index++;
			}
			
			mger.saveQuestionnaire(questionnaire, (int)session.getAttribute("idEpreuve"));
			
			session.setAttribute("questionnaire", questionnaire);
			session.setAttribute("nbQuestions", questionnaire.size());
			session.setAttribute("questionCourante", questionnaire.get(0));
		}		
		
		System.out.println(request.getParameter("idQuestion"));
		
		if ("0".equals(request.getParameter("numOrdre")) || "1".equals(request.getParameter("numOrdre")) || "2".equals(request.getParameter("numOrdre"))) {
			session.setAttribute("questionCourante", ((List<Question>)session.getAttribute("questionnaire")).get(Integer.parseInt(request.getParameter("numOrdre"))));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichageQuestion.jsp");
		rd.forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Question> questionnaire = (List<Question>)session.getAttribute("questionnaire");
		if(request.getParameter("proposition")!=null) {
			((Question)session.getAttribute("questionCourante")).getPropositions().get(Integer.parseInt(request.getParameter("proposition"))-1).setCochee(true);			
		}
		int numQuestion = ((Question)session.getAttribute("questionCourante")).getNumOrdre();
		System.out.println(numQuestion);
		session.setAttribute("questionCourante", questionnaire.get(numQuestion+1));
		
		doGet(request, response);
		
	}
}
