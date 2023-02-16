package serviceLibros;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {
	List<Libro> listaDeLibros();
	List<Tema> listaDeIdTema();
	List<Libro> librosPorTemas(int idTema);
}