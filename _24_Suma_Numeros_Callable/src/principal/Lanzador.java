package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import tareas.SumaNumeros;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService execurto=Executors.newCachedThreadPool();
		//pone la tarea de suma de numeros en ejecucion concurrente(multitarea)
		Future<Integer> future=execurto.submit(new SumaNumeros());
		for(int i=1;i<=100;i++) {
			System.out.println("haciendo algo");
			//vamos preguntando si la tarea a finalizado o no.
			//cuando finaliza, obtenemos el resultado y lo mostramos
			if(future.isDone()) {//pregunta si future a terminado 
				try {//capturamos la execepcion por que .get da fallo sin el try
					System.out.println("la suma vale: "+future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
