package soloElService;

import java.util.List;

import model.Pais;
import service.locator.PaisesLocalFactory;
import service.locator.PaisesLocator;

public class PaisesServiceIMPL implements PaisesService {
	//creamos el objeto locator para que podemos utilizar metodos de PaisesLocator
	PaisesLocator locator=PaisesLocalFactory.getPaisesLocator();
	
	@Override
	public List<Pais> listaDePaises(String continente){
		return locator
				.getJsonStream()
				.filter(e->e.getRegion().equalsIgnoreCase(continente))
				.distinct()
				.toList();
	}
	
	@Override
	public List<String> listaContinentes(){
		return locator
				.getJsonStream()
				.map(e->e.getRegion())
				.distinct()
				.toList();
	}
}