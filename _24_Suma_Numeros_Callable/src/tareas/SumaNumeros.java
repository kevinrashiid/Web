package tareas;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumaNumeros implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		//opcion fea
		//suma de numeros del 1 al 100
		/*int suma=0;
		for(int i=1;i<=100;i++){
			suma+=i;
		}
		return suma;*/
		
		//opcion mejorada con rangeClosed
		//para generar un int Stram del 1 al 100
		//una mejor solucion la suma de numeros entre dos rangos
		return IntStream.rangeClosed(1, 100).sum();
	}
}