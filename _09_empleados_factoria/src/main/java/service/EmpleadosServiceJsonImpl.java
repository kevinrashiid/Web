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
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;

import model.Empleado;

public class EmpleadosServiceJsonImpl implements EmpleadosService{
	String url="c:\\ficheros\\empleados.json";
	//Gson gson=new Gson();
	Gson gson=(new GsonBuilder())
			.registerTypeAdapter(LocalDate.class, new Adaptador())
			.create();
	
	private Stream<Empleado> getJsonStream(){	
		try(FileReader fr=new FileReader(url);){
			Empleado[] empleados=gson.fromJson(fr, Empleado[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //esto genera un stream vacío
		}
	}
	//método que reciba un empleado y lo guarde
	public void guardarEmpleado(Empleado empleado) {
		//creamos un ArrayList para poder guardar el objeto Empleado
		ArrayList<Empleado> lista=new ArrayList<>(getJsonStream().toList());
		lista.add(empleado);
		try(FileWriter fw=new FileWriter(url);) {
			gson.toJson(lista, fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//método que devuelva la lista de empleados de un determinado departamento
	public List<Empleado> empleadosDepartamento(String departamento){
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
