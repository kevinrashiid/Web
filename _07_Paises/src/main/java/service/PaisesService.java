package service;

import java.util.List;

import model.Pais;

public class PaisesService {
	//creamos el objeto locator para que podemos utilizar metodos de PaisesLocator
	PaisesLocator locator=new PaisesLocator();
	
	public List<Pais> listaDePaises(String continente){
		return locator
				.getJsonStream()
				.filter(e->e.getRegion().equalsIgnoreCase(continente))
				.toList();
	}
	
	public List<String> listaContinentes(){
		return locator
				.getJsonStream()
				.map(e->e.getRegion())
				.toList();
	}
}