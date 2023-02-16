package serviceLibros;

import java.util.List;

import model.Libro;
import model.Tema;
import model.Venta;

public interface LibrosService {
	List<Libro> listaDeLibros();
	List<Tema> listaDeIdTema();
	List<Libro> librosPorTemas(int idTema);
	List<Venta> ventaPorFechas(String fechaDeInicio, String fechaDeFinal);
}