package fr.eni.javaee.projetQCM.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projetQCM.bll.UserManager;

/**
 * Servlet implementation class ServletInscriptionTest
 */
@WebServlet("/ServletInscriptionTest")
public class ServletInscriptionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// déclaration des variables
		
		String critereRecherche;
		
		// récupération de la demande utilisateur
		
		critereRecherche = request.getParameter("choixTypeInscription");
		
		// instantiation du userManager
		
		UserManager userManager = new UserManager();
		
		if("promo".equals(critereRecherche))	{
			userManager.selectPromo(request.getParameter("codePromo"));
		} else {
			userManager.selectPromo("");			
		} 

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InscriptionTest.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		doGet(request, response);
	}

}
