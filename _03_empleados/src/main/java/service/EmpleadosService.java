package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

import model.empleadosModel;

public class EmpleadosService {
/*
 El titulo es un dibujo en el cuaderno de 
 lo que quiere que se haga 
 */
	//creamos el fichero con Path y le lo identificamos con una variable
	 Path pt=Path.of("/Users/kevinrashid/Documents/ficheros/empleados.csv");
	
	//metodo que reciba un empleado y lo guardamos
	public  void altaEmpleado(empleadosModel empleado) {
		//tengo que construir una cadena de caracteres con los datos
		//del empleado, para poder guardarla en el fichero con la forma separada
		String linea=empleado.getNombreEmpleado()+","+empleado.getDepartamento()+","+empleado.getSalario()+","+empleado.getFechaEmpleado();
		try {
			Files.writeString(pt, linea+System.lineSeparator(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//metodo que devuelve la lista de empleados de un determinado departamento
	public  List<empleadosModel> consultaEmpleado(String departamento) {
		try {
			return Files.lines(pt)//Stream<String>
			.map(s->{
				String[] datos=s.split("[,]");
				return new empleadosModel(datos[0],datos[1],Double.parseDouble(datos[2]),LocalDate.parse(datos[3]));
			})//Stream<Empleado>
			.filter(e->e.getDepartamento().equals(departamento))//Stream<Empleado>
			.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of(); //devuelve lista vacía
		}
	}
	//metodo que devuelve una lista de departamentos
	public List<String> listaDepartamentos(){
		try {
			return Files.lines(pt)
					.map(s->s.split("[,]")[1])
					.distinct()
					.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return List.of(); //devuelve lista vacía
		}
	}
}