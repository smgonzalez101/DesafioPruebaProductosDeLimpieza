package com.desafiolatam.daos;

import java.util.ArrayList;

import com.desafiolatam.modelsDTO.Producto;

public interface ProductoDAO {

	public int crearProducto(Producto producto);

	public Producto mostrarProducto(int id_producto);

	public int modificarProducto(Producto producto);

	public int eliminarProducto(int id_producto);

	public ArrayList<Producto> obtenerListarProductos();

}
