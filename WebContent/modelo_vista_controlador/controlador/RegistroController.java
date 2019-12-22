package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserDAO;

@WebServlet(name = "RegistroController", urlPatterns = "/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/perfil.jsp");
		dispatcher.forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String nombre=request.getParameter("nombre");
		System. out. println(nombre);
		String apellidos=request.getParameter("apellidos");
		System. out. println(apellidos);
		String fechaNacimiento=request.getParameter("nacimiento");
		System. out. println(fechaNacimiento);
		String telefono=request.getParameter("telefono");
		System. out. println(telefono);
		String email=request.getParameter("email");
		System. out. println(email);
		String titulacion=request.getParameter("titulacion");
		System. out. println(titulacion);
		String descripcion=request.getParameter("descripcion");
		System. out. println(descripcion);
		
		UserDAO.register(nombre, apellidos, fechaNacimiento, telefono, email, titulacion, descripcion);
		
		
	}

}
