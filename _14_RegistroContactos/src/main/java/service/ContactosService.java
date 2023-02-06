package service;

import model.Contacto;

public interface ContactosService {

	void agregarContacto(Contacto contacto);
	void eliminarContacto(String nombre);
	void modificarEmail(String nombre, String nuevoEmail);
	List<Contacto> 
}