package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpleadosService;


@WebServlet("/GrabarEmpleadoServlet")
public class GrabarEmpleadoServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpleadosService grabarEmpleadoService=new EmpleadosService();
		
	
	}
}