package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empleadosModel;
import service.EmpleadosService;


@WebServlet("/AltaEmpleadoServlet")
public class ConsultaEmpleadoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpleadosService empleadosService=new EmpleadosService();
		List<String> tr=empleadosService.listaDepartamentos();
		request.setAttribute("consultaEmpleado", tr);
		request.getRequestDispatcher("seleccion.jsp").forward(request, response);
	}
}