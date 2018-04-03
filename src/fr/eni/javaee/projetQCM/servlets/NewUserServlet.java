package fr.eni.javaee.projetQCM.servlets;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projetQCM.bll.PasswordHashMD5;
import fr.eni.javaee.projetQCM.bll.RandomPassword;
import fr.eni.javaee.projetQCM.bll.UserManager;


@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilAdmin.jsp");
		rd.forward(request, response);
	}

	
	@SuppressWarnings("static-access")
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
		
		//password créer automatiquement 
		
		RandomPassword newUserPass = new RandomPassword(8, ThreadLocalRandom.current());
		PasswordHashMD5 testHash = new PasswordHashMD5();
		
		
		password = newUserPass.nextString() ;
		String passwordHash = testHash.cryptWithMD5(password);
		
		// instantiation d'un userManager
		
		UserManager userManager = new UserManager();
		
		if ( !"".equals(nom) && !"".equals(prenom) && !"".equals(email) && codeProfil != 0) {
			
			System.out.println("pass newUser hash = " + passwordHash);
			System.out.println("pass newUser clair = " + password);
			
			userManager.createCount(nom, prenom, email, passwordHash, codeProfil, codePromo);
		}
		
	
		
		
		doGet(request, response);
	}

}
