<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%List<Alumno> alumnos=(List<Alumno>)request.getAttribute("name");%>
		<!--montamos la tabla de alumnos-->
		<table border="2">
			<tr><th>Nombre</th></tr> <th>Edad</th><th>Nota</th>
			<%for(Alumno a:alumnos){%>
				<tr>
					<td><%=a.nombre() %> </td>
					<td><%=a.edad() %> </td>
					<td><%=a.nota() %> </td>
				</tr>
			<%}%>
		</table>
		<br>
		<br>
		<a href="ConsultaServlet">Volver</a>
		
		
		
		<!--recogemos el atributo media y lo mostramos en la pagina-->
		<%double media=(Double)request.getAttribute("mediaCurso");%>
		<h2>Nota media:<%=media %></h2>
		
	</center>
</body>


</html>