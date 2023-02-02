package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soloElService.PaisesService;
import soloElService.PaisesServiceFactory;
import soloElService.PaisesServiceIMPL;

@WebServlet("/ContinenteServlet")
public class ContinenteServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoge lista de continentes y se la pasa a la JSP
		PaisesService consulta=PaisesServiceFactory.getPaisesService();
		List<String> continentes=consulta.listaContinentes();
		request.setAttribute("continentes", continentes);
		request.getRequestDispatcher("continentes.jsp").forward(request, response);
	}
}