package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
	
	private int idContacto;
	private String usuario;
	private String pwd;
	private String email;
	private int telefono;
}