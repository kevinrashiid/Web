package service;

import java.util.ArrayList;
import java.util.List;

import model.Ciudad;

public class CiudadService {
	
	static List<Ciudad> ciudades=new ArrayList<>(List.of(new Ciudad("Valladolid",230000),
			new Ciudad("Santander",100000),
			new Ciudad("Valencia",1230000),
			new Ciudad("Madrid",3230000),
			new Ciudad("Burgos",90000)));
	
	//metodo que saca datos de todas las ciudades	
	public List<Ciudad> todasLasCiudades(){
		return ciudades;
	}
	
	//metodo para eliminar la ciudad de la lista
	public void eliminarCiudad(String nombre) {
		ciudades.removeIf(c->c.getNombre().equalsIgnoreCase(nombre));
	}
}