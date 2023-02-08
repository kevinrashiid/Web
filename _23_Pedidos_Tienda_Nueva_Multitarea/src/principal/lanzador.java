package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TareaTienda;

public class lanzador {

	public static void main(String[] args) {
		/*
		 El ExecutorService es una interfaz en Java que proporciona 
		 un mecanismo para ejecutar tareas en segundo plano, 
		 también conocidas como hilos de ejecución. Cuando se crea un objeto de ExecutorService, 
		 se establece un pool de hilos que se utilizarán para realizar las tareas asignadas a través de la interfaz.
		 Esta interfaz proporciona métodos para enviar tareas al pool de hilos para su ejecución, monitorear su estado, 
		 esperar a que se completen, y controlar el cierre del pool de hilos. De esta manera, 
		 se puede realizar una tarea en segundo plano y continuar ejecutando otras tareas sin interrupciones.*/
		
		/*método estático "newCachedThreadPool" en la clase "Executors"
		 El método "newCachedThreadPool" crea un pool de hilos con un número 
		 dinámico de hilos. Este tipo de pool es adecuado para aplicaciones que 
		 ejecutan un gran número de tareas ligeras, ya que el número de hilos en el pool se 
		 ajusta automáticamente para satisfacer la demanda. Si un hilo termina de ejecutar una tarea, 
		 se mantiene en el pool para ser reutilizado para una tarea futura en lugar de ser descartado y recreado.
		 
		 El objeto ExecutorService se almacena en una variable "executor". 
		 Después, puede usar este objeto para enviar tareas al pool de hilos para su ejecución.
		 Por ejemplo, puede llamar al método "submit" en el objeto ExecutorService y pasarle una 
		 instancia de la clase "Callable" o "Runnable" para ejecutar la tarea.*/
		ExecutorService executor=Executors.newCachedThreadPool();
		TareaTienda t1=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda1.csv");
		TareaTienda t2=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda2.csv");
		TareaTienda t3=new TareaTienda("C:\\TufKevin\\Eclipse\\Ficheros\\tienda3.csv");
		/*
		 "submit" es una herramienta muy útil para enviar 
		 tareas al pool de hilos para su ejecución y monitorear su estado y resultado.*/
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