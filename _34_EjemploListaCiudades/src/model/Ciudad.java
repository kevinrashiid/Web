package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ciudad {
	private String nombre;
	private int poblacion;
	
	@Override
	public String toString() {
		//sobrescribimos este metodo por 
		//que queremos que se muestre solo los NOMBRES
		return nombre;
	}
}