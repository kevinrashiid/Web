package principal;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
			
		//para probar el contador creamos un objeto contador
		// y tres tareas concurrentes que llaman a incrementar
		//despues mostramos el valor del contador
		
		Contador c1=new Contador();
		//hacemos hilos 
		new Thread(()->c1.incrementar()).start();
		new Thread(()->c1.incrementar()).start();
		new Thread(()->c1.incrementar()).start();
		Thread.sleep(500);
		System.out.println(c1.getValor());
	}
}