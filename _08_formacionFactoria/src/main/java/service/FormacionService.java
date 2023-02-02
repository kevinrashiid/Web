package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	//METODOS que manipulan lista que dentro tienen listas
	//duracion media de todos los cursos
	double duracionDeCursos();

	//lista de cursos con numeros de alumnos inferior a un determinado valor
	List<Curso> cursosInferiorAlumno(int numAlumno);

	//edad media del curso de una determinada denominacion
	double mediaCurso(String denominacion);

	//lista de nombres de alumnos
	List<String> nombresAlumnos();

	//nota media de todos los cursos
	double notaMediaDe();

	//lista de alumnos aprobados
	List<Alumno> aprobados();

	//lista de nombres de cursos
	List<String> listaCursos();

	//nota media del curso de una determinada denominacion
	double notaPorCurso(String deno);

	//lista de alumnos de un curso de una determinada denominacion
	List<Alumno> listaAlumnos(String alum);

}