package service;

import java.util.List;

public interface PaisesEUService {

	List<String> listaDePaises();

	//incidencia acumulada 
	double incidenciaAcumulada(String pais);

	int cacosTotalesEU();
}