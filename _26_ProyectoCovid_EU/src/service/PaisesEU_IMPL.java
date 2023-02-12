package service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import locator.http_json;
import model.Item;

public class PaisesEU_IMPL  implements PaisesEUService{
	/*
	 PROGRAMA UTILIZANDO JSON
	 1.-Lista de paises
	 2.-Incidencia acumulada de un determinado pais
	 3.-Que devuelva casos en total en europa
	*/
	http_json locator= new http_json();
	@Override
	public List<String> listaDePaises() {
		return locator
				.getJsonStream()//Stream<Item>
				.map(e->e.getNombrePais())
				.distinct()
				.toList();
	}
	
	//incidencia acumulada 
	@Override
	public double incidenciaAcumulada(String pais) {
		return locator
				.getJsonStream()
				.filter(e->e.getNombrePais().equalsIgnoreCase(pais)&&e.getIndicador().equals("cases"))//solo nos interesa los casos del pais
				.max((f1,f2)->convertirTextoFecha(f1.getFecha().compareTo(convertirTextoFecha(f2.getFecha()))))//Optinal<Item>
				.orElse(new Item())
				.getIncidencia();
	}
	/*public int casosTotalesEU() {
		//hemos agrupado por pais 
		return locator
				.getJsonStream()
				.filter(e->e.getNombrePais().equalsIgnoreCase(pais)&&e.getIndicador().equals("cases"))
		
		
	}*/
	private LocalDate fechaMasReciente() {
		return locator.getJsonStream()
				.map(it->convertirTextoFecha(it.getFecha()))
				.max((f1,f2)->f1.compareTo(f2))
				.orElse(LocalDate.now());
	}
	@Override
	public int cacosTotalesEU() {
		LocalDate fechaMax=fechaMasReciente();
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases")&&convertirTextoFecha(it.getFecha().equals(fechaMax)))
				.collect(Collectors.summingInt(it->it.getAcumulados()));
	}
}