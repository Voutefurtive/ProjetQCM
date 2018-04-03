package fr.eni.javaee.projetQCM.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.projetQCM.bll.UserManager;
import fr.eni.javaee.projetQCM.bo.Roles;
import fr.eni.javaee.projetQCM.bo.User;

@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAuthentification.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// déclaration des variable de la fonction d'authentification.
		String log;
		String mdp;
		int roles = 0;
		
		// récupération des données saisies de l'utilisateur
		log = req.getParameter("log");
		mdp = req.getParameter("mdp");
		
	
		// création d'une session avec HttpSession
		HttpSession session = req.getSession();
		
				// TODO le reste des sesssions
		
		// passage des attributs de log à la session pour l'authentification
		session.setAttribute("log", log);
	
		// instantiation d'un userManager
		UserManager userManager = new UserManager();
		
		// récupération de la fonction d'authentification du manager
		User user = userManager.authentification(log, mdp);
	
		
		if(user!=null) {
			roles = user.getCodeProfil();
			session.setAttribute("utilisateur", user); // spla
		
		}
		
		RequestDispatcher rd = null;
		switch (roles) {
		case Roles.ADMIN:
			rd = req.getRequestDispatcher("/WEB-INF/AccueilAdmin.jsp");
			break;
			
		case Roles.FORMATEUR:
			System.out.println("on est là !");
			rd = req.getRequestDispatcher("/WEB-INF/AccueilNoob.jsp");
			break;
			
		case Roles.RESPONSABLE_DE_FORMATION:
			break;

		case Roles.CELLULE_DE_RECRUTEMENT:

			break;
		case Roles.STAGIAIRE:
			break;
			
		case Roles.CANDIDAT:
			break;
			
		default:
			//req.setAttribute("erreur", "Login ou mot de passe incorrect");
			doGet(req, resp);
		}

	rd.forward(req,resp);
}}
