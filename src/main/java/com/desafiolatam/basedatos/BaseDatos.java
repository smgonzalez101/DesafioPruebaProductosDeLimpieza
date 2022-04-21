package com.desafiolatam.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

	private String sServidor = "localhost"; // es igual a 127.0.0.1 //Datos para conectarse al servidor (Se puede
											// colocar la ip
	private String sUsuario = "root";
	private String sPassword = "kame2008"; // clave de base de datos
	private int iPuerto = 3306;
	private String sBaseDatos = "productos_limpieza";

	private String sServer = "";

	private static Connection conexion = null;

	public BaseDatos() {
		super();
	}

	public Connection datos() {
		// this.sBaseDatos = baseDatos;
		// recibimos el nombre de la base de datos
		this.sServer = "jdbc:mysql://" + this.sServidor + ":" + this.iPuerto + "/" + sBaseDatos;
		// jdbc:mysql://localhost:3306/javag6

		// registremos el driver mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");// Mysql
			// Class.forName("com.mysql.cj.jdbc.Driver");//MariaDB

		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.err.println("Error al registrar el driver Mysql: " + e);
			// Al detectar error termina el flujo

		}

		// conexion a mysql establecida

		try {
			conexion = DriverManager.getConnection(this.sServer, this.sUsuario, this.sPassword);
		} catch (SQLException e) {
			System.err.println("Error al conectar a Mysql: " + e);
			// Al detectar error termina el flujo

		}
		System.out.println("Nos hemos conectado a la base de datos: " + sBaseDatos);
		return conexion;

	}
}
