<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	import="java.util.List,model.empleadosModel"
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Empleados del departamento:<%= request.getAttribute(departamento)%></h2>
		<!-- hacemos la tabla -->
		<%List<empleadosModel> emps=(List<empleadosModel> request.getAttribute("empleados"); %>
		<table border="1";
			<tr><th>Nombre</th><th>Departamento</th><th>Salario</th></tr>
<!-- Recorro la lista de empleados y generados una fila en la tabla por cada empleado -->
			<%for(Empleado e:emps){%>
				<tr>
					<td><%=e.getNombre %></td>
					<td><%=e.getDepartamento %></td>
					<td><%=e.getSalario %></td>
					<td><%=e.getFecha%></td>
				<tr>
			<%}%>
		</table>
		<br><br>
		<a href="inicio.html">Volver</a>
	</center>
</body>
</html>