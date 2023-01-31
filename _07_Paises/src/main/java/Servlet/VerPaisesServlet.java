package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisesService;

@WebServlet("/VerPaisesServlet")
public class VerPaisesServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaisesService verPais=new PaisesService();
		//recogemos el parametro con el continente seleccionado
		String continente=request.getParameter("region");
		List<Pais> ListaPais=verPais.listaDePaises(continente);
		request.setAttribute("paises", ListaPais);
		request.setAttribute("continente", continente);
		request.getRequestDispatcher("paises.jsp").forward(request, response);
	}
}