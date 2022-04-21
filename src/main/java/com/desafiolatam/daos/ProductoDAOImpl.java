package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.modelsDTO.Categoria;
import com.desafiolatam.modelsDTO.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	BaseDatos conexionBD = new BaseDatos();
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	@Override
	public int crearProducto(Producto producto) {

		int resultado = 0;

		String query = "INSERT INTO producto(nombre_producto, precio_producto, descripcion_producto, id_categoria) values('"
				+ producto.getNombre_producto() + "','" + producto.getPrecio_producto() + "','"
				+ producto.getDescripcion_producto() + "','" + producto.getCategoria().getId_categoria() + "')";
		System.out.println("query: " + query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);

			if (resultado == 1) {
				System.out.println("Producto insertado correctamente");
			} else {
				System.out.println("Error al insertar los datos del producto");
			}
		} catch (Exception e) {

		}
		return resultado;
	}

	@Override
	public Producto mostrarProducto(int id_producto) {
		Producto producto = null;
		String query = "SELECT * FROM producto WHERE ID_PRODUCTO= " + id_producto;
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				// Recorre para capturar los datos
				int producto_Id = resultado.getInt(1);
				String nombre_producto = resultado.getString(2);
				int precio_producto = resultado.getInt(3);
				String descripcion_producto = resultado.getString(4);
				int categoriaId = resultado.getInt(5);

				Categoria categoria = new Categoria();
				categoria.setId_categoria(categoriaId);
				// llenar el objeto nuevo por cada registro
				producto = new Producto(producto_Id, nombre_producto, precio_producto, descripcion_producto, categoria);

			}

		} catch (Exception e) {

		}
		return producto;
	}

	@Override
	public int modificarProducto(Producto producto) { // EDITAR
		int resultado = 0;
		String query = " UPDATE PRODUCTO SET nombre_producto='" + producto.getNombre_producto() + "', precio_producto='"
				+ producto.getPrecio_producto() + "', descripcion_producto='" + producto.getDescripcion_producto()
				+ "', id_categoria='" + producto.getCategoria().getId_categoria() + "' WHERE id_producto="
				+ producto.getId_producto();

		// System.out.println("query actualizar "+query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); // Debe ser int hay que modificar -> 1,0 o true o false

			if (resultado == 1) {
				System.out.println("Producto modificado correctamente");
			} else {
				System.out.println("Error al modificar los datos del producto");
			}

		} catch (Exception e) {

		}

		return resultado;
	}

	@Override
	public int eliminarProducto(int id_producto) {
		int resultado = 0;
		String query = "DELETE FROM PRODUCTO WHERE id_producto=" + id_producto;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); // Debe ser int hay que modificar -> 1,0 o true o false

			if (resultado == 1) {
				System.out.println("El producto seleccionado se eliminó correctamente.");
			} else {
				System.out.println("Error al eliminar el producto seleccionado.");
			}

		} catch (Exception e) {

		}

		return resultado;
	}

	@Override
	public ArrayList<Producto> obtenerListarProductos() {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();

		String query = "SELECT producto.id_producto, producto.nombre_producto, producto.precio_producto, producto.descripcion_producto, categoria.id_categoria, categoria.nombre_categoria "
				+ " from producto " + " inner join categoria on producto.id_categoria = categoria.id_categoria ";
		System.out.println(query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {

				// se recorre para capturar los datos
				int productoId = resultado.getInt(1);
				String nombre_producto = resultado.getString(2);
				int precio_producto = resultado.getInt(3);
				String descripcion_producto = resultado.getString(4);
				int categoriaId = resultado.getInt(5);
				String nombreCategoria = resultado.getString(6);
				// System.out.println("linea152");
				Categoria categoria = new Categoria(categoriaId, nombreCategoria);
				// llenar el objeto nuevo por cada registro
				Producto producto = new Producto(productoId, nombre_producto, precio_producto, descripcion_producto,
						categoria);

				listaProductos.add(producto);// llenando la lista

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaProductos;
	}

}
