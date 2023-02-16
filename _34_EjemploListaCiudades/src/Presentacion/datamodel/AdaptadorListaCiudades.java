package Presentacion.datamodel;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Ciudad;
import service.CiudadService;
	//extendemos DefaultListModel los datos de tipo ciudad
public class AdaptadorListaCiudades extends DefaultListModel<Ciudad>{
	
	List<Ciudad> ciudades;
	public AdaptadorListaCiudades() {
		//se conecta con la capa de negocio para obtener los datos originales 
		//que queremos mostrar en el JList
		
		CiudadService service=new CiudadService();
		ciudades=service.todasLasCiudades();
	}
	//sobrescribimos los metodos que van a ser llamados 
	//por el JList para rellenar su contenido
	@Override
	public int getSize() {
		//metodo sobrescrito de DefaultListModel
	//devuelve el tamaño de la lista
	return ciudades.size();
		
	}
	@Override
	public Ciudad getElementAt(int index) {
		//en cada posicion del JList asignaremos la correspondiente posicion que tenemos en el List
		return ciudades.get(index);	
	}
}