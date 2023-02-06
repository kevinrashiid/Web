package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.CursoService;
import service.CursosServiceFactory;

@WebServlet("/CursoFechaServlet")
public class CursoFechaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursoService service=CursosServiceFactory.getCursosService();
		String fecha=request.getParameter("fecha");
		LocalDate fechaConvertida=LocalDate.parse(fecha);//valido si el formato es yyyy-MM-dds
		List<Curso> cursos=service.cursosPorFechaInicioMax(fechaConvertida);
		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("cursos.jsp").forward(request, response);
	}
}