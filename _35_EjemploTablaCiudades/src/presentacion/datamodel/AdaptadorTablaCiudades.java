package presentacion.datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ciudad;
import service.CiudadService;

public class AdaptadorTablaCiudades extends AbstractTableModel {
	
	List<Ciudad> ciudades;
	public AdaptadorTablaCiudades() {
		CiudadService service= new CiudadService();
		ciudades=service.todasLasCiudades();
	}

	
	@Override
	//total de filas de la tabla
	public int getRowCount() {
		 return ciudades.size();
	}

	@Override
	//dar el tamaño de la tabla
	public int getColumnCount() {
		//solo si sabemos el tamaño
		//return 3;
		//esto para cuando no sepamos las columnas de la tabla
		//para saber cuantos 
		return Ciudad.class.getDeclaredFields().length;
	}

	@Override
	public String getColumnName(int column) {
		/*switch(column) {
		case 0:
			return "nombre ciudad";
		case 1:
			return "poblacion";
		case 2:
			return "Temperatura media";
		}
		//cadena vacia 
		return "";*/
		
		//para ponerle titulos a las columnas
		//la nueva forma de del switch
		//se llama switch en expresiones
		return switch(column) {
		case 0->"Nombre ciudad";
		case 1->"Poblacion";
		case 2->"Temperatura media";
		default->"";
		};
	}

	@Override
	//este metodo debe proporcionar el contenido de cada celda
	public Object getValueAt(int row, int column) {
		return switch(column) {
		case 0->ciudades.get(row).getNombre();
		case 1->ciudades.get(row).getPoblacion();
		case 2->ciudades.get(row).getTemperaturas();
		default->"";
		};
	}

	@Override
	//Proporciona el tipo de dato de cada columna
	public Class<?> getColumnClass(int columnIndex) {
		/*return switch(columnIndex) {
		case 0->String.class;
		case 1->Integer.class;
		case 2->Double.class;
		default->null;
		};*/
		
		//forma corta de saber el tipo de dato de cada columna
		return Ciudad.class.getDeclaredFields()[columnIndex].getClass();
	}	
}