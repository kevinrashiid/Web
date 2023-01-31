package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.empleadosModel;

public class EmpleadosService {
/*
 El titulo es un dibujo en el cuaderno de 
 lo que quiere que se haga 
 */
	//creamos el fichero con Path y le lo identificamos con una variable
	//hay que leer en los 3 metodos para pasarlo a un Array []
	///Users/kevinrashid/Documents/ficheros
	String url="/Users/kevinrashid/Documents/ficheros/empleados.json";
	//Gson gson=new Gson();
	Gson gson=(new GsonBuilder())//
			.registerTypeAdapter(LocalDate.class, new Adaptador())
			.create();
	
	private Stream<empleadosModel> getJsonStream(){	
		try(FileReader fr=new FileReader(url);){
			empleadosModel[] empleados=gson.fromJson(fr, empleadosModel[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //esto genera un stream vacío
		}
	}
	
	//método que reciba un empleado y lo guarde
	public void guardarEmpleado(empleadosModel empleado) {
		//creamos un ArrayList para poder guardar el objeto Empleado
		ArrayList<empleadosModel> lista=new ArrayList<>(getJsonStream().toList());
		lista.add(empleado);
		try(FileWriter fw=new FileWriter(url);) {//
			gson.toJson(lista, fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//método que devuelva la lista de empleados de un determinado departamento
	public List<empleadosModel> empleadosDepartamento(String departamento){
		return getJsonStream()
				.filter(e->e.getDepartamento().equals(departamento))//Stream<Empleado>
				.toList();
	}

	//método que devuelva una lista de departamentos
	public List<String> departamentos(){
		return getJsonStream() //Stream<Empleado>
				.map(e->e.getDepartamento())//Stream<String>
				.distinct()
				.toList();
	}
}