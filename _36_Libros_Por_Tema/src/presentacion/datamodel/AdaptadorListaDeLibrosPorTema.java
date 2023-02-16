package presentacion.datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Libro;
import serviceClientes.LibreriaServiceFactory;
import serviceLibros.LibrosService;

public class AdaptadorListaDeLibrosPorTema extends AbstractTableModel{
	List<Libro> listaDeLibrosPorTemas;

	public void AdaptadorListaTemas(int idTema) {

		LibrosService service=LibreriaServiceFactory.getLibrosService();
		listaDeLibrosPorTemas=service.librosPorTemas(idTema);
	}

	@Override
	public int getRowCount() {
		 return listaDeLibrosPorTemas.size();
	}

	@Override
	public int getColumnCount() {
		return 4;

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return switch(columnIndex) {
		case 0->listaDeLibrosPorTemas.get(rowIndex).getTitulo();
		case 1->listaDeLibrosPorTemas.get(rowIndex).getAutor();
		case 2->listaDeLibrosPorTemas.get(rowIndex).getPrecio();
		case 3->listaDeLibrosPorTemas.get(rowIndex).getPaginas();
		default->"";
		};
	}

	@Override
	public String getColumnName(int column) {
		return switch(column) {
		case 0->"Titulo";
		case 1->"Autor";
		case 2->"Paginas";
		default->"";
		};
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return switch(columnIndex) {
		case 0->String.class;
		case 1->String.class;
		case 2->Double.class;
		default->null;
		};
	}
	
}
