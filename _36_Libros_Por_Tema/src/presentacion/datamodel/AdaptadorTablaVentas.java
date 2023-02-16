package presentacion.datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Venta;

public class AdaptadorTablaVentas extends AbstractTableModel{
	
	List<Venta> ventas;
	
	@Override
	public int getRowCount() {
		return ventas.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return switch(columnIndex) {
		case 0->ventas.get(rowIndex).getTitulo();
		case 1->ventas.get(rowIndex).getAutor();
		case 2->ventas.get(columnIndex).getTema();
		case 3->ventas.get(columnIndex).getFecha();
		default->"";
		};
	}

	@Override
	public String getColumnName(int column) {
		return switch(column) {
		case 0->"Titulo";
		case 1->"Autor";
		case 2->"Tema";
		case 3->"Fecha Compra";
		default->"";
		};
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {	
		return Venta.class.getDeclaredFields()[columnIndex].getClass();
	}
}
