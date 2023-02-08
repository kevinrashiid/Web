package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.PedidosTiendasServiceFactory;

public class Calculos {

	public static void main(String[] args) {
	//De manera concurrente , nos mostrara el total de unidades pedidas
	//y el nombre del ultimo producto pedido
	//como no tiene parametros ()->
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.totalDeUnidades()));		
		executor.submit(()->System.out.println(
				PedidosTiendasServiceFactory
				.getPedidosTiendasService()
				.productoUltimoProducto()));
		executor.shutdown();
		/*
		 "shutdown" es un método importante en la 
		 interfaz ExecutorService que le permite detener el pool de 
		 hilos de manera controlada y asegurarse de que todas las tareas 
		 en ejecución se hayan completado antes de finalizar el ExecutorService.*/
				
	}
}