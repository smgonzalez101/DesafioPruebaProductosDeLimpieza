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

@WebServlet("/modificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FacadeProducto facadeProducto = new FacadeProducto();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_producto = request.getParameter("id_producto");
		Producto producto = facadeProducto.mostrarProducto(Integer.parseInt(id_producto));
		request.setAttribute("producto", producto);

		List<Categoria> categorias = facadeProducto.obtenerListaCategorias();
		request.setAttribute("categorias", categorias);
		request.setAttribute("producto", producto);

		request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Captura de datos desde formulario
		String id_producto = request.getParameter("id_producto");
		String nombre_producto = request.getParameter("nombre_producto");
		String precio_producto = request.getParameter("precio_producto");
		String descripcion_producto = request.getParameter("descripcion_producto");
		String categoriaId = request.getParameter("id_categoria");

		Categoria categoria = new Categoria();
		categoria.setId_categoria(Integer.parseInt(categoriaId));

		Producto producto = new Producto(Integer.parseInt(id_producto), nombre_producto,
				Integer.parseInt(precio_producto), descripcion_producto, categoria);

		if (nombre_producto != null && precio_producto != null && categoriaId != null && descripcion_producto != null
				&& !nombre_producto.isEmpty() && !precio_producto.isEmpty() && !descripcion_producto.isEmpty()) {

			// se llama al metodo en el facadeProducto
			int resultado = facadeProducto.modificarProducto(producto);
			if (resultado == 1) {
				request.setAttribute("msgExito", "Se modificó correctamente los datos del producto.");
			} else {
				request.setAttribute("msgError", "Error al modificar la información del producto.");
			}
		}
		doGet(request, response);
	}

}
