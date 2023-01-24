<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Pagina"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listdado de resultados</h1>
<%--Recuperamos el atributo de peticion que contiene la lista de paginas--%>
<%--se pone = por delante de cada linea que --%>
<%List<Pagina> paginas=(List<Pagina>)request.getAttribute("paginas");
for(Pagina p:paginas){%>
	<a href="<%=p.getUrl()%>"><%=p.getTitulo()%></a>
	<br>
	<div align="center">
		<%=p.getDescripcion()%>
	</div>
	<hr>
<%}%>
</body>
</html>