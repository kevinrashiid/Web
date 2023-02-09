package tareas;

import java.util.function.Supplier;

public class SumaNumeros2 implements Supplier<Integer>{

	@Override
	public Integer get(){
		//suma de numeros del 1 al 100
		int suma=0;
		for(int i=1;i<=100;i++){
			suma+=i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return suma;
		
	}
}