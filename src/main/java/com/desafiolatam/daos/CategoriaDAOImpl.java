package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.modelsDTO.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	BaseDatos conexionBD = new BaseDatos();
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	@Override
	public ArrayList<Categoria> obtenerListaCategorias() {

		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		String query = "SELECT * FROM CATEGORIA";

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				// captura de datos
				int id_categoria = resultado.getInt(1);
				String nombre_categoria = resultado.getString(2);

				// llenar objeto
				Categoria categoria = new Categoria(id_categoria, nombre_categoria);

				listaCategorias.add(categoria); // se llena la lista
			}

		} catch (Exception e) {

		}
		return listaCategorias;

	}
}
