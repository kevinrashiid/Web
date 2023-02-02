package soloElService;

import java.util.List;

import model.Pais;

public interface PaisesService {

	List<Pais> listaDePaises(String continente);

	List<String> listaContinentes();

}