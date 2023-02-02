<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Empleado"%>
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
		<h2>Empleados del departamento: <%=request.getAttribute("departamento") %></h2>
		<%List<Empleado> emps=(List<Empleado>)request.getAttribute("empleados"); %>
		<table class="table table-striped table-bordered">
			<tr><th>Nombre</th><th>Departamento</th><th>Salario</th><th>Fecha</th></tr>
			<!-- Recorro la lista de empleados y generamos una fila en la tabla por cada empleado -->
			<%for(Empleado e:emps){ %>
				<tr>
					<td><%=e.getNombre()%></td>
					<td><%=e.getDepartamento()%></td>
					<td><%=e.getSalario()%></td>
					<td><%=e.getFecha()%>
				</tr>
			<%} %>
		</table>
		<br><br>
		<a href="inicio.html">Volver</a>
	</div>
</body>
</html>