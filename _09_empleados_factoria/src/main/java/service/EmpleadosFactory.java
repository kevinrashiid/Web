package service;

public class EmpleadosFactory {
	public static EmpleadosService getEmpleadosService() {
		return new EmpleadosServiceJsonImpl();
	}
}
