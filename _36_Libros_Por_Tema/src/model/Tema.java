package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tema {
	
	private int idTema;
	private String tematica;
	@Override
	public String toString() {
		//sobrescribimos este metodo por 
		//que queremos que se muestre solo los NOMBRES
		return tematica;
	}
	
}