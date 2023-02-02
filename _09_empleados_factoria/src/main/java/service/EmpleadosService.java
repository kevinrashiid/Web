package service;

import java.util.List;

import model.Empleado;

public interface EmpleadosService {
	void guardarEmpleado(Empleado empleado);
	List<Empleado> empleadosDepartamento(String departamento);
	List<String> departamentos();
}
