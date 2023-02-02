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
		<form action=VerPaisesServlet>
				Seleccione continente:
				<select name="continente">
				<%List<String> continentes=(List<String>)request.getAttribute("continentes");
				for(String d:continentes){%>
					<option value="<%=d%>"><%=d%></option>
				<%}%>
				</select>
				<br><br>
				<input type="submit"value="Ver paises">
		</form>
	</center>
</body>
</html>