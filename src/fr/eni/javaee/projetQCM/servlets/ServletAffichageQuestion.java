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

import fr.eni.javaee.projetQCM.bll.EpreuveManager;
import fr.eni.javaee.projetQCM.bo.epreuves.Question;

/**
 * Servlet implementation class ServletAffichageQuestion
 */
@WebServlet("/question")
public class ServletAffichageQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EpreuveManager mger = new EpreuveManager();
		List<Question> questionnaire = new ArrayList<Question>();
		
		request.setAttribute("questionnaire", mger.getSectionByTheme(2,1));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/affichageQuestion.jsp");
		rd.forward(request, response);
	}
}
