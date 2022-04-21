<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.desafiolatam.modelsDTO.Producto"%>
<%@ page import="com.desafiolatam.modelsDTO.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Modificar Producto</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">



<!-- Bootstrap CSS 5.1.3-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
body {
	background-color: olive;
}
</style>


</head>
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
						href="Credenciales">Credenciales</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="crearProducto">Agregar Producto</a></li>
					<li class="nav-item"><a class="nav-link active text-white"
						href="listarProducto">Listar/Modificar/Eliminar Productos</a>
				</ul>
			</div>
		</div>
	</nav>

	<br>
	<br>

	<div class="container mt-5">
		<c:if test="${msgExito !=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgExito}"></c:out>
				<!-- Captura el dato y lo imprime -->
			</div>
		</c:if>

		<c:if test="${msgError !=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
				<!-- Captura el dato y lo imprime -->
			</div>
		</c:if>

		<h2>Modificar información de Producto</h2>
		<form action="modificarProducto" method="post">
			<input type="hidden" class="form-control" id="id_producto"
				name="id_producto"
				value='<c:out value="${producto.id_producto}"></c:out>'
				placeholder="Ingrese ID producto"> <br> <label
				for="nombre_producto" class="form-label">Nombre</label> <input
				type="text" class="form-control" id="nombre_producto"
				name="nombre_producto"
				value='<c:out value="${producto.nombre_producto}"></c:out>'
				placeholder="Ingrese nombre producto"> <br> <label
				for="precio_producto" class="form-label">Precio</label> <input
				type="text" class="form-control" id="precio_producto"
				name="precio_producto" value="${producto.precio_producto}"
				placeholder="Ingrese precio del producto"><br> <label
				for="descripcion_producto" class="form-label">Descripción </label> <input
				type="text" class="form-control" id="descripcion_producto"
				name="descripcion_producto" value="${producto.descripcion_producto}"
				placeholder="Ingrese descripción de producto"><br> <label
				for="categoria" class="form-label">Categoría</label> <select
				class="form-select" name="id_categoria">
				<option selected value="0">Seleccione una categoria de
					producto</option>
				<c:forEach items="${categorias}" var="categoria">
					<option value="${categoria.getId_categoria()}">${categoria.getNombre_categoria()}</option>
				</c:forEach>
			</select> <br> <br>

			<!--botones-->
			<button type="submit" class="btn btn-dark mb-4 p-2">Modificar</button>

		</form>
	</div>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p "
		crossorigin="anonymous "></script>


</body>