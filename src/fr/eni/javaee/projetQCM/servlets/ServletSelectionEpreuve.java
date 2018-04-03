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
import fr.eni.javaee.projetQCM.bo.User;

/**
 * Servlet implementation class ServletSelectionEpreuve
 */
@WebServlet("/epreuves")
public class ServletSelectionEpreuve extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Création d'un user pour le test, il devra être récupéré dans la session après l'authentification
			User utilisateur = new User();
			utilisateur.setNom("MLK");
			utilisateur.setPrenom("mlk");
			utilisateur.setId(1);
			
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
		//fin de la partie à supprimer
		
		EpreuveManager epreuveMger = new EpreuveManager();
		
		request.setAttribute("epreuves", epreuveMger.getEpreuvesByUser(utilisateur.getId()));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/selectionEpreuve.jsp");
		rd.forward(request,response);
		
	}

}
