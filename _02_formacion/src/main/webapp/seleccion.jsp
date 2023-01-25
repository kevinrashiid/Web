<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--con error 404 el error puuede estar en la linea del href --%>
	<center>
	<h2>
	Seleccione curso</h2>
	<form action="AlumnosServlet">
		<%---hacemos una lista --%>
		<select> name="curso">
			<%List<String> nombres=(List<String>)request.getAttribute("nombresCursos");
			for(String s: nombres){%>
			<option value="<%=s%>"><%=s%></option>
			<%}%>
		</select>
		<br>
		<input type="submit" value="ver alumno">
		<br>
	</form>
	</center>
</body>
</html>