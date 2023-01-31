package service;

import java.util.List;

import model.Pais;

public class PaisesService {
	//creamos el objeto locator para que podemos utilizar metodos de PaisesLocator
	PaisesLocator locator=new PaisesLocator();
	
	public List<Pais> listaDePaises(String region){
		return locator
				.getJsonStream()
				.filter(e->e.getCapital().equalsIgnoreCase(region))
				.toList();
	}
	
	public List<String> continentes(){
		return locator
				.getJsonStream()
				.map(e->e.getName())
				.toList();
	}
}