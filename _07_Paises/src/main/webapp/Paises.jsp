<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.Pais"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
			<h2>Paises del continente:<%= request.getAttribute("departamento")%></h2>
			<!-- hacemos la tabla -->
			<%List<Pais> emps=(List<Pais>)request.getAttribute("empleados");%>
			<table border="1";>
				<tr><th>Nombre</th><th>Capital</th><th>Poblacion</th><th>Bandera</th></tr>
	<!-- Recorro la lista de empleados y generados una fila en la tabla por cada empleado -->
				<%for(Pais e:emps){ %>
					<tr>
						<td><%=e.getName()%></td>
						<td><%=e.getCapital()%></td>
						<td><%=e.getPopulation()%></td>
						<td><img scr="<%e.getFlag()%>" width="32" height="16"></td>
					</tr>
				<%}%>
			</table>
			<br><br>
			<a href="continentes.jsp">Volver</a>
		</center>

</body>
</html>