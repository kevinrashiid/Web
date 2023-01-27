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

@WebServlet("/VerEmpleado")
public class VerEmpleadoServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogemos el parametro que contiene el departamento seleccionado
		//despues obetenemos la lista de empleados de ese departamento
		//lo guardamos en un atributo y transferimos el control a la JSP
		
		EmpleadosService verEmpleado=new EmpleadosService();
		String depa=request.getParameter("departamento");
		List<empleadosModel> listaEmpleados=verEmpleado.consultaEmpleado(depa);
		request.setAttribute("emplados" listaEmpleados);
		//le mandamos tambien le nombre del departamento seleccionado
		request.setAttribute("depart" depa);
		request.getAttribute("empleados.jsp").forward(request, response);
	}
}
