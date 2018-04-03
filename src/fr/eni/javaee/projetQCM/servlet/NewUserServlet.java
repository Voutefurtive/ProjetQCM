package fr.eni.javaee.projetQCM.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projetQCM.bll.UserManager;


@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// déclaration des variable de la fonction d'insertion d'un nouvel utilisateur.
		String nom;
		String prenom;
		String email;
		String password;
		int codeProfil = 1;
		String codePromo;
		
		// récupération des données saisies de l'utilisateur
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		codeProfil = Integer.parseInt(request.getParameter("codeProfil"));
		codePromo = request.getParameter("codePromo");
		
		//password en dur à créer automatiquement
		password = "tonton";
		
		// instantiation d'un userManager
		
		UserManager userManager = new UserManager();
		
		if ( !"".equals(nom) && !"".equals(prenom) && !"".equals(email) && codeProfil != 0) {
			
			userManager.createCount(nom, prenom, email, password, codeProfil, codePromo);
		}
		
	
		
		
		doGet(request, response);
	}

}
