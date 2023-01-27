package model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class empleadosModel {
	private String nombreEmpleado;
	private String departamento; 
	private double salario; 
	private Date fechaEmpleado;
	
	
}
