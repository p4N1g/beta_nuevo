package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import models.UserDAO;

@WebServlet(name = "UserLoginController", urlPatterns = "/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserLoginView.jsp");
		dispatcher.forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		if(UserDAO.validationUser(user, password)==true) {
			response.sendRedirect("index");
		}
		else {
			 JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			 response.sendRedirect("login");
		}
		
	}

}