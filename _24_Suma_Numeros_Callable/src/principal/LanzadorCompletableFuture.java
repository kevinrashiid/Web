package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.SumaNumeros2;

public class LanzadorCompletableFuture {

	public static void main(String[] args) {
		
		ExecutorService execurto=Executors.newCachedThreadPool();
		//aqui no vamos a llamar al submit por que devuelve un 
		//futere y futere no una solucion chapucera
		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(new SumaNumeros2(),execurto);
		//el completableFuture tiene la definicion el codigo 
		//que debe ser ejecutado cuando la tarea finalice
		//utilizamos el whenComleteAsync que le pasamos un biConsumer que le tenemos que dar dos parametros
		future.whenCompleteAsync((r,e)->System.out.println("La suma es: "+r));
		for(int i=1;i<=100;i++){
			System.out.println("haciendo algo");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			execurto.shutdown();
		}
	}
}