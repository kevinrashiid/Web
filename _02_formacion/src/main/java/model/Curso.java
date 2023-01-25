package model;

import java.util.List;

public record Curso(String denominacion,int duracion,List<Alumno> matriculas) {
	//JavaBeans con record

}
