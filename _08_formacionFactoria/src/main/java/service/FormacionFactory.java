package service;

public class FormacionFactory {
	//este es el metodo que proporciona las implementaciones de la interfaz
	public static FormacionService getFormacionService() {
		return new FormacionServiceIMPL();
	}	
}
