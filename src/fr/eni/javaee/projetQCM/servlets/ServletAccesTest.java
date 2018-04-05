package fr.eni.javaee.projetQCM.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.projetQCM.bll.EpreuveManager;

/**
 * Servlet implementation class ServletAccesTest
 */
@WebServlet("/detailTest")
public class ServletAccesTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EpreuveManager mger = new EpreuveManager();
		HttpSession session = request.getSession();

		// List<SectionTest> sections =
		// mger.getSections(Integer.parseInt(request.getParameter("id")));

		session.setAttribute("test", mger.getTestById(Integer.parseInt(request.getParameter("id"))));

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accesTest.jsp");
		rd.forward(request, response);
	}

}
