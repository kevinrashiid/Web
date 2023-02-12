package main;

import presentacion.Mywindow;

public class Inicio {

	public static void main(String[] args) {
		//creamos el objeto en el main de Mywindow para que se abra la ventana 
		//si le damos a la x para cerrar la ventana no la cerramos si no que la ocultamos
		//a menos que cambiemos el comportamiento de ese boton
		new Mywindow();
		
	}
}