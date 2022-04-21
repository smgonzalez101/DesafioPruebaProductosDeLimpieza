package com.desafiolatam.modelsDTO;

public class Producto {

	private int id_producto;
	private String nombre_producto;
	private int precio_producto;
	private String descripcion_producto;
	private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(int id_producto, String nombre_producto, int precio_producto, String descripcion_producto,
			Categoria categoria) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precio_producto = precio_producto;
		this.descripcion_producto = descripcion_producto;
		this.categoria = categoria;
	}

	public Producto(String nombre_producto, int precio_producto, String descripcion_producto, Categoria categoria) {
		super();
		this.nombre_producto = nombre_producto;
		this.precio_producto = precio_producto;
		this.descripcion_producto = descripcion_producto;
		this.categoria = categoria;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
