package fr.eni.javaee.projetQCM.servlet;

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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAuthentification.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String log;
		String mdp;
		int roles = 0;
		log = req.getParameter("nom");
		mdp = req.getParameter("password");
		
		// création d'une session avec HttpSession
		HttpSession session = req.getSession();
		// passage des attributs
		session.setAttribute("nom", log);
        

		UserManager userManager = new UserManager();
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
