package service;

public class CursosServiceFactory {
	
	public static CursoService getCursosService() {
		return new CursosServiceIMPL();
	}
}