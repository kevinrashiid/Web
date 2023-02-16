package serviceClientes;

import serviceLibros.LibrosService;
import serviceLibros.LibrosServiceIMPL;

public class LibreriaServiceFactory {
	public static ClientesService getClientesService() {
		return new ClientesServiceIMPL();
	}
	public static LibrosService getLibrosService() {
		return new LibrosServiceIMPL();
	}
}