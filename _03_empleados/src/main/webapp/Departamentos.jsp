<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="VerEmpleado">
				Selecciones departamento:
				<select name="departamento">
				<%List<String> depars=(List<String>)request.getAttribute("departamentos");
				for(String d:depars){%>
					<option value="<%=d%>"><%=d%></option>
					<%}%>
				</select>
				<br><br>
				<input type="submit"value="ver empleados">
		</form>
	</center>
</body>
</html>