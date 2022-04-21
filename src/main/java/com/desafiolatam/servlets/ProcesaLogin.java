package com.desafiolatam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String admin = "admin";
		String contrasena = "admin";
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// Validar los parámetros
		if (login.isEmpty() || login == null || password.equals("") || password == null) {

			request.setAttribute("msgError", "Ingrese nuevamente, datos incompletos.");
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (admin.equals(login) && contrasena.equals(password)) {
				// usuario logeado/SESSION guardar
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("Nombre", login);

				Cookie cookie = new Cookie("nombre", admin);
				cookie.setMaxAge(9000);
				cookie.setComment("Cookie nombre de usuario");
				response.addCookie(cookie);

				request.getRequestDispatcher("homeUsuario.jsp").forward(request, response);
			} else {
				request.setAttribute("msgError", "Ingrese nuevamente, datos incorrectos.");
				request.getRequestDispatcher("/login").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
