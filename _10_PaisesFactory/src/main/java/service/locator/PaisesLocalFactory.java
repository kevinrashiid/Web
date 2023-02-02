package service.locator;

public class PaisesLocalFactory {
	
	public static PaisesLocator getPaisesLocator() {
		return new PaisesLocatorWebIMPL();
	}
}
