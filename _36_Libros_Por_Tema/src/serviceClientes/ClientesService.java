package serviceClientes;

public interface ClientesService {

	//metodo que te dice si un contacto existe en un Base de datos en SQL
	
	boolean existeContacto(String usuario, String pwd);
}