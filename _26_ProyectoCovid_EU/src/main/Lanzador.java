package main;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.ItemServiceFactory;
import service.PaisesEUService;

public class Lanzador {
/*
 * Desde una clase main, se mostraran los datos de incidencia de cada pais registrado.
 * Asi mismo, simultaneamente, se lanzara una tarea encargada de calcular los casos 
 * totales y completa, mostrara ese resultado en consola
 * */
	public static void main(String[] args) {
		ExecutorService excutor=Executors.newCachedThreadPool();
		PaisesEUService ItemService=ItemServiceFactory.getItemService();
		List<String> paises=ItemService.listaDePaises();
		//Lanzamos la tarea secundaria
		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->ItemService.cacosTotalesEU(),excutor);
		future.whenCompleteAsync((r,e)->System.out.println("El Total acumulado en Europa es: "+r));
		//paises.forEach(p->System.out.println("Incidencia de "+p+" es: "+ItemService.incidenciaAcumulada(p)));	
		//lanzamos el calculo de cada pais como tarea independiente
		paises.forEach(p->excutor.submit(()->System.out.println("El Total acumulado en Europa es: "+r+" es: ")));
	}
}