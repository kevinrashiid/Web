package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.FormacionService;


@WebServlet("/AlumnosServlet")
public class AlumnosServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoge el parametro que contiene el nombre de curso seleccionado, despues
		//obtiene la lista de alumnos de ese curso, la guarda en un lugar accesible
		//para el JSP y trsnfiere el control a la pagina alumnos.jsp
		FormacionService servletAlumno=new FormacionService();
		String name=request.getParameter("alum");
		List<Alumno> alumno=servletAlumno.listaAlumnos(name);
		request.setAttribute("alumnoCurso", alumno);
		request.getRequestDispatcher("alumnos.jsp").forward(request, response);
	}
}
