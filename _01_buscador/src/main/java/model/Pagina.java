package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagina {
	private String[] tematica;
	private String url;
	private String descripcion;
	private String titulo;
}
