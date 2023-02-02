<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Pais"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
			<h2>Paises del continente: <%=request.getAttribute("continente") %></h2>
			<!-- hacemos la tabla -->
			<%List<Pais> paises=(List<Pais>)request.getAttribute("paises"); %>
			<table class="table table-striped table-bordered">
				<tr><th>Nombre</th><th>Capital</th><th>Poblacion</th><th>Bandera</th></tr>
	<!-- Recorro la lista de empleados y generados una fila en la tabla por cada empleado -->
				<%for(Pais e:paises){ %>
					<tr>
						<td><%=e.getName()%></td>
						<td><%=e.getCapital()%></td>
						<td><%=e.getPopulation()%></td>
						<td><img src="<%=e.getFlag()%>" width="32" height="16"></td>
					</tr>
				<%} %>
			</table>
			<br><br>
			<a href="ContinenteServlet">Volver</a>
	</div>
</body>
</html>