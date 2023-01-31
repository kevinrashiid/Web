package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisesService {

	String uRl="/Users/kevinrashid/Documents/ficheros/paises.json";
	Gson gson=new Gson();
	private Stream<Pais> getJsonStream(){	
		try(FileReader fr=new FileReader(uRl);){
			Pais[] empleados=gson.fromJson(fr, Pais[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //esto genera un stream vacío
		}
	}
	
	public List<Pais> listaDePaises(String region){
		return getJsonStream()
				.filter(e->e.getCapital().equalsIgnoreCase(region))
				.toList();
	}
	
	public List<String> continentes(){
		return getJsonStream()
				.map(e->e.getName())
				.toList();
	}
}