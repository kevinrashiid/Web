package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TareaTienda;

public class lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		
		TareaTienda t1=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda1.csv");
		TareaTienda t2=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda2.csv");
		TareaTienda t3=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda3.csv");
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		System.out.println("Tareas en proceso");
		//el pool de executor service cuando termina 
		//de ejecutar las tareas sigue en proceso aun que las 
		//tareas hayan terminado al cabo de un rato cuando el jdk 
		//se da cuenta que es no lo usa nadie lo apaga pero eso se puede 
		//forzar para cerrar el proceso cuando acabe la tarea deseada y para eso ponemos 
		executor.shutdown();//en resumen para vaciar el pool
	}
}