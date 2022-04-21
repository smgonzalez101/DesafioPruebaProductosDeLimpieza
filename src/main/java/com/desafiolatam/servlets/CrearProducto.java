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

@WebServlet("/crearProducto")
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FacadeProducto facadeProducto = new FacadeProducto();

	// doGet, //creando variable llamada categorias
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categoria> categorias = facadeProducto.obtenerListaCategorias();
		request.setAttribute("categorias", categorias);//
		request.getRequestDispatcher("crearProducto.jsp").forward(request, response);

	}

	// Captura la información
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Captura de datos desde formulario
		String nombre_producto = request.getParameter("nombre_producto");
		String precio_producto = request.getParameter("precio_producto");
		String descripcion_producto = request.getParameter("descripcion_producto");
		String categoriaId = request.getParameter("id_categoria");

		if (nombre_producto == null || nombre_producto.equals("") || precio_producto.equals("")
				|| precio_producto == null || categoriaId == null || categoriaId.equals("")
				|| descripcion_producto.equals("") || descripcion_producto == null) {
			request.setAttribute("msgError", "Error en la creación,  faltan datos.");

		} else {
			Categoria categoria = new Categoria();
			categoria.setId_categoria(Integer.parseInt(categoriaId));

			Producto producto = new Producto(nombre_producto, Integer.parseInt(precio_producto), descripcion_producto,
					categoria);

			// se llama al metodo en el facadeProducto
			int resultado = facadeProducto.crearProducto(producto);
			if (resultado == 1) {
				request.setAttribute("msgExito",
						"Producto ingresado, para modificar o eliminar ir a Listar/Modificar/Eliminar Productos");
			} else {
				request.setAttribute("msgError", "Error al crear el nuevo producto");
			}
		}
		doGet(request, response);
	}
}
