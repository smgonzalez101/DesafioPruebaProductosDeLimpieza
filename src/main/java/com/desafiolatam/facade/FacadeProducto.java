package com.desafiolatam.facade;

import java.util.ArrayList;

import com.desafiolatam.daos.CategoriaDAOImpl;
import com.desafiolatam.daos.ProductoDAOImpl;
import com.desafiolatam.modelsDTO.Categoria;
import com.desafiolatam.modelsDTO.Producto;

public class FacadeProducto {

	public int crearProducto(Producto producto) {
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int retornoCrear = productoDAOImpl.crearProducto(producto);// capturamos

		return retornoCrear; // Se retorna un int
	}

	public Producto mostrarProducto(int id_producto) {
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		Producto retornoMostrar = productoDAOImpl.mostrarProducto(id_producto);

		return retornoMostrar;
	}

	public int modificarProducto(Producto producto) {
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int retornoModificar = productoDAOImpl.modificarProducto(producto);

		return retornoModificar; // Se retorna un int

	}

	public int eliminarProducto(int id_producto) {
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		int retornoEliminar = productoDAOImpl.eliminarProducto(id_producto);

		return retornoEliminar; // Se retorna un int

	}

	public ArrayList<Producto> obtenerListarProductos() {
		ProductoDAOImpl productoDAOImpl = new ProductoDAOImpl();
		ArrayList<Producto> productos = productoDAOImpl.obtenerListarProductos();

		System.out.println("FacadeProducto" + productos);

		return productos; // Se retorna una lista
	}

	public ArrayList<Categoria> obtenerListaCategorias() {
		CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
		ArrayList<Categoria> categorias = categoriaDAOImpl.obtenerListaCategorias();

		return categorias;
	}

}
