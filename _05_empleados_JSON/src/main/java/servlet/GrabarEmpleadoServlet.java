package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.empleadosModel;
import service.EmpleadosService;


@WebServlet("/GrabarEmpleadoServlet")
public class GrabarEmpleadoServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos los parametros enviados por la pagina de alta
		//los empaquetamos en un objeto Empleado
		//despues llamamos al metodo que guarda el empleado de la capa service 
		//y finalmente nos vamos a la pagina de inicio
		EmpleadosService grabarEmpleadoService=new EmpleadosService();
		//recogemos parametros
		String name=request.getParameter("empleado");
		String departamento=request.getParameter("departamento");
		//pasamos el salio y lo convertimos de string a double
		double salario=Double.parseDouble(request.getParameter("salario"));
		//pasamos el parametro de la fecha ACTUAL
		LocalDate fecha=LocalDate.now();
		empleadosModel altaTrabaja=new empleadosModel(name,departamento,salario,fecha);
		grabarEmpleadoService.guardarEmpleado(altaTrabaja);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}
}

