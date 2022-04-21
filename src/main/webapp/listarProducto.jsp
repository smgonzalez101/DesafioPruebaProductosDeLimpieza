<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.desafiolatam.modelsDTO.Producto"%>
<%@ page import="com.desafiolatam.modelsDTO.Categoria"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>ListarProductos</title>
<!-- <link rel="shortcut icon" type="image/png"
	src="https://freesvg.org/img/cwt-Bleach-bottle.png"> -->

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<!-- Bootstrap CSS 5.1.3-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<style>
body {
	background-color: olive;
}
</style>


</head>

<%
List<Producto> productos;
//se captura info que viene desde el request
productos = (List) request.getAttribute("productos");
List<Categoria> categorias;
categorias = (List) request.getAttribute("categorias");
%>


<body>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #3e4e4e;">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link text-white"
						aria-current="page" href="/DesafioPruebaProductosDeLimpieza">Página
							Inicial</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="login">Credenciales</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="crearProducto">Agregar Producto</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="listarProducto">Listar/Modificar/Eliminar Productos</a>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container text-center pt-4">
		<h2>Listado de Productos</h2>
		<br> <br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Precio</th>
					<th scope="col">Descripcion</th>
					<th scope="col">Categoria</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Producto dto : productos) {
				%>
				<tr>
					<td><%=dto.getId_producto()%></td>
					<td><%=dto.getNombre_producto()%></td>
					<td><%=dto.getPrecio_producto()%></td>
					<td><%=dto.getDescripcion_producto()%></td>
					<td><%=dto.getCategoria().getNombre_categoria()%></td>

					<td><a class="btn btn-outline-dark"
						href="modificarProducto?id_producto=<%=dto.getId_producto()%>"
						role="button">Modificar</a></td>
					<td><a class="btn btn-outline-danger"
						href="eliminarProducto?id_producto=<%=dto.getId_producto()%>"
						role="button">Eliminar</a></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
	<br>
	<div class="container text-center pt-4">
		<h5>Ir a Página Inicial, para salir del sistema.</h5>

		<!-- Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
			crossorigin="anonymous "></script>
</body>
</html>