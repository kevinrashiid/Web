package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PaisesService;

@WebServlet("/consultaServlet")
public class consultaServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoge lista de continentes y se la pasa a la JSP
		PaisesService consulta=new PaisesService();
		List<String> continentes=consulta.continentes();
		request.setAttribute("continente", continentes);
		request.getRequestDispatcher("continentes.jsp").forward(request, response);
	}
}
