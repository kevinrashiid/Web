package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) {
		//creamos el executorService
		//NUEVA FORMA DE LANZAR TAREAS
		//nos proporciona una forma mas eficiente de hacerlo 
		//
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//creamos dos objetos de las clases Ascendente Descendente
		Ascendente t1=new Ascendente();
		Descendente t2=new Descendente();
		
		
		//se ponen en ejecucion concurrente
		//SUPER ANTIGUO
		//t1.start();
		//t2.start();
		//
		//la ejecucion de t1 y t2 se haria de esta 
		//forma por que ahora estamos implementando Runnable
		//ANTIGUO
		//new Thread(t1).start();
		//new Thread(t2).start();
		//NUEVO
		executor.submit(t1);
		executor.submit(t2);
		/*te ejecuta primero todo del t1 y luego todo del t2
		 t1.run();
		  t2.run();*/
		//esto es una tarea mas, utilizamos otro hilo mas
		//se ejecuta junto con las otras dos tareas mas es decir 
		//me ejecuta a la vez el t1 t2  "haciendo cosas el main..."
		for(int i=1;i<=100;i++) {
			System.out.println("haciendo cosas el main...");
			try {
				//para que espere 500 milisegundo en que se vuelva a ejecutar 
				//y mientas se ejecuta otras instrucciones
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}