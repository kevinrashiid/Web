package service;

public class ItemServiceFactory {
	public static PaisesEUService getItemService() {
		return new PaisesEU_IMPL() ;
	}
}