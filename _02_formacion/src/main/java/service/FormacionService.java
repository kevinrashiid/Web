package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Alumno;
import model.Curso;

public class FormacionService {
	private static List<Curso> cursos=List.of(new Curso("Java for dummies",50,List.of(			
												new Alumno("alumno1",25,7),
												new Alumno("alumno2",32,2),
												new Alumno("alumno3",19,8)
										)),
										new Curso("Spring",60,List.of(			
												new Alumno("alumno5",18,6.9),
												new Alumno("alumno4",40,3.2),
												new Alumno("alumno8",28,6)
												)),
										new Curso("JavaScript",75,List.of(			
												new Alumno("alumno2",32,7.1),
												new Alumno("alumno4",40,8.3),
												new Alumno("alumno7",33,4)
												))
										);
	//METODOS que manipulan lista que dentro tienen listas
	//duracion media de todos los cursos
	public double duracionDeCursos() {
		return cursos.stream()
				.collect(Collectors.averagingDouble(c->c.duracion()));
	}
	//lista de cursos con numeros de alumnos inferior a un determinado valor
	public List<Curso> cursosInferiorAlumno(int numAlumno){
		return cursos.stream()
				.filter(c->c.matriculas().size()<numAlumno)//Stream<Curso>
				.toList();
	}
	
	//edad media del curso de una determinada denominacion
	public double mediaCurso(String denominacion) {
		return cursos.stream()
				.filter(c->c.denominacion().equalsIgnoreCase(denominacion))//Stream<Curso>
				.flatMap(c->c.matriculas().stream())//stream<Alumno>
				.collect(Collectors.averagingDouble(a->a.edad()));//media de la edad de los cursos
	}
	
	//lista de nombres de alumnos
	public List<String> nombresAlumnos(){
		return cursos.stream()//Stream<Curso>
				.flatMap(c->c.matriculas().stream())//Stream<Alumno>
				.map(a->a.nombre())//Stream<String>
				.toList();//convertimos a lista lo que extraemos 
	}
	
	//nota media de todos los cursos
	public double notaMediaDe() {
		return cursos.stream()
				.flatMap(c->c.matriculas().stream())
				.collect(Collectors.averagingDouble(a->a.nota()));
	}
	//lista de alumnos aprobados
	public List<Alumno> aprobados(){
		return cursos.stream()
				.flatMap(c->c.matriculas().stream())
				.filter(n->n.nota()>=5)
				.collect(Collectors.toList());//convertimos a una lista con toList()
				//.toList();//igual que el anterior, pero desde java 13
	}	
	//lista de nombres de cursos
	public List<String> listaCursos(){
		return cursos.stream()//String<Curso>
				.map(c->c.denominacion())
				.toList();	
	}
	//nota media del curso de una determinada denominacion
	public double notaPorCurso(String deno) {
		return cursos.stream()
				.filter(c->c.denominacion().equalsIgnoreCase(deno))
				.flatMap(c->c.matriculas().stream())
				.collect(Collectors.averagingDouble(a->a.nota()));
	}
	//lista de alumnos de un curso de una determinada denominacion
	public List<Alumno> listaAlumnos(String alum){
		//OPCION 1
		/*return cursos.stream()
				.filter(c->c.denominacion().equalsIgnoreCase(alum))
				.flatMap(c->c.matriculas().stream())
				.toList();*/
		return cursos.stream() 
				.filter(c->c.denominacion().equals(alum))//Stream<Curso>
				.findFirst()  //Optional<Curso>
				.get()  //Curso
				.matriculas();
	}
}