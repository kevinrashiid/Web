package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import model.Contador;

public class Test {

	public static void main(String[] args) throws InterruptedException {
			
		//para probar el contador creamos un objeto contador
		// y tres tareas concurrentes que llaman a incrementar
		//despues mostramos el valor del contador
		
		Contador c1=new Contador();
		//creamos un objeto de la clase Lock
		Lock lk=new ReentrantLock();
		ExecutorService executor=Executors.newCachedThreadPool();
		//metemos en la variable rn el objeto lk de lock para abrir 
		//la puerta pasa el c1 y utilizamos el metodo incrementar 
		//y cerramos la puerta con el objeto lock pero con el metodo unlock
		Runnable rn=()->{
			//cerramos la puerta
			lk.lock();
			c1.incrementar();
			//abrimos la puerta
			lk.unlock();
		};
		//lazamos las tareas con submit y utilizamos el 
		//objeto executor para utilizar submit y que se pueda lanzar el rn 
		executor.submit(rn);
		executor.submit(rn);
		executor.submit(rn);
		//le decimos que tarde 500 milisegundos
		Thread.sleep(500);
		System.out.println(c1.getValor());
	}
}