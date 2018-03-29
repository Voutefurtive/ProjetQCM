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
		
		UserManager userManager = new UserManager();
		boolean user = userManager.authentification(log, mdp);
		
		int role = userManager.roles(log);
		System.out.println(role);
		
		if (user == true) {
			
		//	switch (role) {
		//	case 1: if ( role == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/AccueilAdmin.jsp");
				rd.forward(req, resp);
	/*		}
				break;	

			default:
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/AccueilNoob.jsp");
				rd.forward(req, resp);
				break;
			}
			*/
		} else {
			doGet(req, resp);
		}
	}
}
