package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pedidos {
	private int idPedido;
	private String nombreProducto;
	private int unidadesProducto;
	private LocalDate fecha;
}