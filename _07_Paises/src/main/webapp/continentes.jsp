<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"     import="java.util.List,model.Pais"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<form action=consultaServlet>
				Selecciones continente:
				<select name="continente">
				<%List<String> continens=(List<String>)request.getAttribute("region");
				for(String d:continens){%>
					<option value="<%=d%>"><%=d%></option>
					<%}%>
				</select>
				<br><br>
				<input type="submit"value="Ver paises">
		</form>
	</center>
</body>
</html>