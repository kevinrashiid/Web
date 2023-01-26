package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import model.empleadosModel;

public class EmpleadosService {
/*
 El titulo es un dibujo en el cuaderno de 
 lo que quiere que se haga 
 */
	//creamos el fichero con Path y le lo identificamos con una variable
	private Path pt=Path.of("c:\\ficheros\\empleados.txt");
	
	//metodo que reciba un empleado y lo guardamos
	public  void altaEmpleado(empleadosModel empleado) {
		String linea=empleado.getNombreEmpleado()
				+","+empleado.getDepartamento()
				+","+empleado.getSalario()
				+","+empleado.getFechaEmpleado();
		try {
			Files.writeString(pt, linea+System.lineSeparator(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//metodo que devuelve la lista de empleados de un determinado departamento
	public  List<empleadosModel> consultaEmpleado(String departamento) {
		
		
	}
	//metodo que devuelve una lista de departamentos
	public List<String> listaDepartamentos(){
		
	}
}