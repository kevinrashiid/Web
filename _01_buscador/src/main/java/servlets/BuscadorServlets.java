package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;

//informa al servidor de aplicacion que la clase es un servlet y tiene
//la dirreccion indicada que es la de abajo
@WebServlet("/BuscadorServlets")//@WebServlet esto es una anotacion para el tomcat
public class BuscadorServlets extends HttpServlet {
	
	//sobrescritura del metodo service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//creamos un objeto de la capa de negocio 
		BuscadorService buscadorService=new BuscadorService();
		//recoge el parametro (datos enviados desde la pagina cliente)
		//que contiene el tema de busqueda
		String tema=request.getParameter("tema");//request significa peticion//tema es el nombre que se le da al campo
		//obtenemos lista de paginas de dicho tema
		List<Pagina> paginas=buscadorService.buscardor(tema);
		//con el metodo setAttribute guardamos la lista en un atributo de peticion para que pueda recoger la JSP
		request.setAttribute("paginas", paginas);
		//transfiero el control a la pagina JSP, osea se ejecuta el JSP
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
}