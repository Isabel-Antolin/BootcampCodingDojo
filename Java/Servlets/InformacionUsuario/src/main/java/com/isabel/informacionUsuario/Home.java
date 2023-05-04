package com.isabel.informacionUsuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("nombre") == null ? "Unknown" : request.getParameter("nombre");
		String lastName = request.getParameter("apellido") == null ? "Unknown" : request.getParameter("apellido");
		String favoriteLanguage = request.getParameter("lenguaje") == null ? "Unknown"
				: request.getParameter("lenguaje");
		String city = request.getParameter("ciudad") == null ? "Unknown" : request.getParameter("ciudad");

		String contenido = String.format("<h1>Welcome, %s %s</h1>" + 
		                                 "<h2>Your favorite language is : %s</h2>"+ 
				                         "<h2>Your favorite hometown is : %s</h2>", firstName, lastName, favoriteLanguage, city);
//		respuesta
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write(contenido);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
