package fr.eni.javaee.projetQCM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projetQCM.bll.UserManager;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAuthentification.jsp");
		rd.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String log;
		String mdp;
	
		log = req.getParameter("nom");
		mdp = req.getParameter("password");
		
		System.out.println(log+" - "+mdp);
		
		UserManager userManager = new UserManager();
		boolean user = userManager.authentification(log, mdp);
		//System.out.println(user);

		if (user == true) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(req, resp);
		} else {
			doGet(req, resp);
		}
	}
}
