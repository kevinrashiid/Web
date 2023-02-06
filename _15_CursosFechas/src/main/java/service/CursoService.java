package service;

import java.time.LocalDate;
import java.util.List;

import model.Curso;

public interface CursoService {
	List<Curso> cursosPorFechaInicioMax(LocalDate fecha);
}
