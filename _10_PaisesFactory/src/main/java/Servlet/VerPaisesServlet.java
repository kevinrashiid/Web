package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import soloElService.PaisesService;
import soloElService.PaisesServiceFactory;
import soloElService.PaisesServiceIMPL;

@WebServlet("/VerPaisesServlet")
public class VerPaisesServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaisesService verPais=PaisesServiceFactory.getPaisesService();
		//recogemos el parametro con el continente seleccionado
		String continente=request.getParameter("continente");
		List<Pais> ListaPais=verPais.listaDePaises(continente);
		request.setAttribute("paises", ListaPais);
		request.setAttribute("continente", continente);
		request.getRequestDispatcher("Paises.jsp").forward(request, response);
	}
}