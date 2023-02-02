package soloElService;

public class PaisesServiceFactory {
	public static PaisesService getPaisesService() {
		return new PaisesServiceIMPL();
	}
}
