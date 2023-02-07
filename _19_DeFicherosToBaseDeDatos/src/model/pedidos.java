package model;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pedidos {
	private String nombreProducto;
	private int unidadesProducto;
	private LocalDate fecha;
}