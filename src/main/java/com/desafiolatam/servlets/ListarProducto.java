package com.desafiolatam.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.desafiolatam.facade.FacadeProducto;
import com.desafiolatam.modelsDTO.Categoria;
import com.desafiolatam.modelsDTO.Producto;

@WebServlet("/listarProducto")
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Producto> productos;
		List<Categoria> categorias;
		FacadeProducto facadeProducto = new FacadeProducto();

		productos = facadeProducto.obtenerListarProductos();
		request.setAttribute("productos", productos);

		categorias = facadeProducto.obtenerListaCategorias();
		request.setAttribute("categorias", categorias);

		// Se envia el request a la pagina jsp
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
